package com.gxg.demojiuxi6.mydemo6.http;

import com.gxg.demojiuxi6.mydemo6.http.exception.ApiException;
import com.gxg.demojiuxi6.mydemo6.http.result.HttpResult;
import com.gxg.demojiuxi6.mydemo6.http.service.HomeService;
import com.gxg.demojiuxi6.mydemo6.utils.AppUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by gaoxuge on 17/6/29.
 *
 */

public class HttpMethods {
    /**
     * 开发环境
     **/
    public static final String BASE_URL = "http://123.56.77.94:8080/jiuxi-api/";

    /**
     * 正式环境
     */
//    public static final String BASE_URL = "http://api.9xi.com/jiuxi-api/";
//    public static final String BASE_URL = "https://api.9xi.com/jiuxi-api/";




    private static final int DEFAULT_TIMEOUT = 5;
    private HomeService homeFragmentService;
    //构造方法私有
    private HttpMethods() {

        //备用
//        OkHttpClient client = newer OkHttpClient
//                .Builder()
//        //拓展功能：网络请求的log，compile 'com.squareup.okhttp3:logging-interceptor:3.2.0'
//        .addInterceptor(newer HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
//                //拓展功能：数据请求的压缩，下面会解析自定义：
//                .addInterceptor(newer GzipRequsetIn　　terceptor())
//                .build()

        init();

    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final HttpMethods INSTANCE = new HttpMethods();
    }
    //获取单例
    public static HttpMethods getInstance() {
        return SingletonHolder.INSTANCE;
    }
    /**
     * 获取首页数据2.4
     *
     * @param subscriber 由调用者传过来的观察者对象
     */
    public void getSelectNewHomeData(Subscriber<HomeBean> subscriber, HashMap<String, Object> request) {

        Observable observable = homeFragmentService.getSelectNewHomeData(request)
                .map(new HttpResultFunc<HomeBean>());

        toSubscribe(observable, subscriber);
    }

















    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    private class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

        @Override
        public T call(HttpResult<T> httpResult) {
            if (!httpResult.get_code().equals("000000")) {
                throw new ApiException(httpResult.get_code(), httpResult.get_msg());
            }

            return httpResult.get_data() == null ? null : httpResult.get_data();
        }
    }

    private void init() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //手动创建一个OkHttpClient并设置超时时间
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.addInterceptor(new HeaderInterceptor());
        builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

        Retrofit retrofit = new Retrofit.Builder()
                .client(builder.build())
                //使用Gson对Json进行解析，导入的库：compile 'com.squareup.retrofit2:converter-gson:2.0.2'
                .addConverterFactory(GsonConverterFactory.create())
                //拓展添加RxJava的功能，导入的库：compile 'com.squareup.retrofit2:adapter-rxjava:2.0.2'
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

//
        homeFragmentService = retrofit.create(HomeService.class);
//
    }

    private <T> void toSubscribe(Observable<T> o, Subscriber<T> s) {
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }


    /**
     * 设置请求Header
     */
        static class HeaderInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();
            Request compressedRequest = originalRequest.newBuilder()
                    //根据服务器的要求，自行添加IP报文的头部
//                    .addHeader("User-Agent", "SampleDemo/" + " (android;" + android.os.Build.VERSION.RELEASE + ";" + android.os.Build.MODEL + ")")
//                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
//                    .addHeader("Accept", "*/*")
//                    .addHeader("Connection", "close")
                    .addHeader("version", AppUtil.getOSVersion())
                    .build();
            return chain.proceed(compressedRequest);
        }
    }



}
