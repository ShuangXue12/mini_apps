package com.example.mylibrary.Utils.Net;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiServcie {
//    https://cdplay.cn/api/index
    String BaseUrl = " https://cdplay.cn/";
    @GET
    Observable<ResponseBody> get(@Url String baseUrl);
}
