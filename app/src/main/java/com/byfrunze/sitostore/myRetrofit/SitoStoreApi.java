package com.byfrunze.sitostore.myRetrofit;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface SitoStoreApi {

    @FormUrlEncoded
    @POST("/api/products/getProducts")
    Call<Object> getProduct(@FieldMap Map<String, Integer> map);
}
