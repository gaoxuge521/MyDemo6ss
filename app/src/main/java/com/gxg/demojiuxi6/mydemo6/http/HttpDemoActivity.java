package com.gxg.demojiuxi6.mydemo6.http;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gxg.demojiuxi6.mydemo6.R;
import com.gxg.demojiuxi6.mydemo6.http.subscribers.ProgressSubscriber;
import com.gxg.demojiuxi6.mydemo6.http.subscribers.SubscriberOnNextListener;
import com.gxg.demojiuxi6.mydemo6.utils.AppUtil;
import com.gxg.demojiuxi6.mydemo6.utils.ToastUtils;

import java.util.HashMap;

public class HttpDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_demo);


        getHomeData();

    }


    //获取首页数据
    private void getHomeData() {

        SubscriberOnNextListener getHomeDataOnNext = new SubscriberOnNextListener<HomeBean>() {
            @Override
            public void onNext(HomeBean homeBean) {

                ToastUtils.showLongToast(homeBean.getBanners().toString());

            }
        };

        if (!AppUtil.isConnNet()) {
            return;
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("token", "");
        map.put("version", AppUtil.getVersionCode());

        HttpMethods.getInstance().getSelectNewHomeData(new ProgressSubscriber(getHomeDataOnNext, HttpDemoActivity.this), map);
    }
}
