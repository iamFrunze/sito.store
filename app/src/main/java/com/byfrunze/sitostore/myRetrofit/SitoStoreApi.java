package com.byfrunze.sitostore.myRetrofit;

import com.byfrunze.sitostore.productsForAdapter.POJOProducts;
import com.byfrunze.sitostore.ArgRequest.GetProducts;
import com.byfrunze.sitostore.productsForAdapter.MainSearch;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface SitoStoreApi {

    @POST("/api/products/getProducts")
    Call<POJOProducts> getProductCategories(@Header ("Content-Type") String type, @Body GetProducts GetProducts);

    @POST("/api/search/mainSearch")
    Call<POJOProducts> getMainSearch(@Header ("Content-Type") String type, @Body MainSearch mainSearch);
}
