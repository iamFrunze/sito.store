package com.byfrunze.sitostore.myRetrofit;

import com.byfrunze.sitostore.sitoStoreElementsOfProducts.POJOProducts;
import com.byfrunze.sitostore.ui.catalog.GetProducts;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface SitoStoreApi {

    @FormUrlEncoded
    @POST("/api/products/getProducts")
    Call<POJOProducts> getProduct(@FieldMap Map<String, Integer> map);

    @FormUrlEncoded
    @POST("/api/products/getProducts")
    Call<Object> getProductObject(@FieldMap Map<String, Integer> map);

    @POST("/api/products/getProducts")
    Call<POJOProducts> getProductCategories(@Header ("Content-Type") String type, @Body GetProducts GetProducts);
}
