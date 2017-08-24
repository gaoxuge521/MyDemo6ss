/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gxg.demojiuxi6.mydemo6.http.service;

import com.gxg.demojiuxi6.mydemo6.http.HomeBean;
import com.gxg.demojiuxi6.mydemo6.http.result.HttpResult;

import java.util.HashMap;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 *
 * @author yuliuyue
 */
public interface HomeService {



    @POST("home/select/list")
    Observable<HttpResult<HomeBean>> getSelectNewHomeData(@Body HashMap<String, Object> body);


}
