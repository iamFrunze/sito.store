package com.byfrunze.sitostore.myRetrofit;

import android.content.Context;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.byfrunze.sitostore.sitoStoreElementsOfProducts.POJOProducts;
import com.byfrunze.sitostore.sitoStoreElementsOfProducts.Product;
import com.byfrunze.sitostore.ui.catalog.CatalogProductAdapter;
import com.byfrunze.sitostore.ui.catalog.GetProducts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
            }

            @Override
            public void onFailure(Call<POJOProducts> call, Throwable t) {
            }
        });
    }

    public void getProductsForCatalog(int sex_id, int category, final RecyclerView recyclerView, final Context context) {
        List<Integer> categoriesList = new ArrayList<>();
        categoriesList.add(category);
        GetProducts product = new GetProducts(sex_id,1, categoriesList);
        Call<POJOProducts> call = sitoStoreApi.getProductCategories("application/json", product);
        call.enqueue(new Callback<POJOProducts>() {

            @Override
            public void onResponse(Call<POJOProducts> call, Response<POJOProducts> response) {
                resProducts = response.body().getProducts();
                catalogProductAdapter = new CatalogProductAdapter(resProducts);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(catalogProductAdapter);
            }

            @Override
            public void onFailure(Call<POJOProducts> call, Throwable t) {
                Log.i("RETRO", t.getMessage());
            }
        });
    }

}
