package com.byfrunze.sitostore.myRetrofit;

import android.content.Context;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.byfrunze.sitostore.myRetrofit.NetworkService;
import com.byfrunze.sitostore.myRetrofit.SitoStoreApi;
import com.byfrunze.sitostore.sitoStoreElementsOfProducts.Info;
import com.byfrunze.sitostore.sitoStoreElementsOfProducts.POJOProducts;
import com.byfrunze.sitostore.sitoStoreElementsOfProducts.Product;
import com.byfrunze.sitostore.ui.catalog.CatalogProductAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JSONUtils {


    private NetworkService networkService;
    private SitoStoreApi sitoStoreApi;
    private List<Product> resProducts ;
    private CatalogProductAdapter catalogProductAdapter;

    public JSONUtils(){
        networkService = NetworkService.getInstance();
        sitoStoreApi = NetworkService.getApi();
    }
    public void getProduct(String page, int value, final RecyclerView recyclerView, final Context context) {
        Map<String, Integer> mapJson = new HashMap<>();
        mapJson.put(page, value);
        Call<POJOProducts> call = sitoStoreApi.getProduct(mapJson);
        call.enqueue(new Callback<POJOProducts>() {

            @Override
            public void onResponse(Call<POJOProducts> call, Response<POJOProducts> response) {
                resProducts = response.body().getProducts();
                catalogProductAdapter = new CatalogProductAdapter(resProducts);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(catalogProductAdapter);
                Log.i("POJO", response.body().getProducts().get(1).getBrand());
            }

            @Override
            public void onFailure(Call<POJOProducts> call, Throwable t) {
            }
        });
    }
    public void getProduct( ) {
        Map<String, Integer> mapJson = new HashMap<>();
        mapJson.put("page", 1);
        Call<Object> call = sitoStoreApi.getProductObject(mapJson);
        call.enqueue(new Callback<Object>() {

            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Log.i("RETRO", response.body().toString());
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
            }
        });
    }


}
