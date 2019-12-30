package com.byfrunze.sitostore.myRetrofit;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.byfrunze.sitostore.productsForAdapter.POJOProducts;
import com.byfrunze.sitostore.productsForAdapter.Product;
import com.byfrunze.sitostore.Adapters.TargetItemAdapter;
import com.byfrunze.sitostore.ArgRequest.GetProducts;
import com.byfrunze.sitostore.productsForAdapter.MainSearch;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JSONUtils {


    private NetworkService networkService;
    private SitoStoreApi sitoStoreApi;
    private List<Product> resProducts;
    private TargetItemAdapter targetItemAdapter;
    private RecyclerView recyclerView;
    private Context contex;
    String TAG = "TAG";

    public JSONUtils(RecyclerView recyclerView, Context contex, TargetItemAdapter targetItemAdapter) {
        this.networkService = NetworkService.getInstance();
        this.sitoStoreApi = NetworkService.getApi();
        this.recyclerView = recyclerView;
        this.contex = contex;
        this.targetItemAdapter = targetItemAdapter;
    }

    public JSONUtils() {
        this.networkService = NetworkService.getInstance();
        this.sitoStoreApi = NetworkService.getApi();
    }

    public List<Product> getResProducts() {
        return resProducts;
    }


    public void getProductsApi(GetProducts getProducts) {
        GetProducts product = getProducts;
        Call<POJOProducts> call = sitoStoreApi.getProductCategories("application/json", product);
        call.enqueue(new Callback<POJOProducts>() {

            @Override
            public void onResponse(Call<POJOProducts> call, Response<POJOProducts> response) {
                resProducts = response.body().getProducts();
                targetItemAdapter.setProductList(resProducts);
                Log.i("Inf", getResProducts().size() + "");
            }

            @Override
            public void onFailure(Call<POJOProducts> call, Throwable t) {
                Log.i("RETRO", t.getMessage());
            }
        });
    }

    public void getProductsForCatalog(int sex_id, int category, final RecyclerView recyclerView, final Context context) {
        List<Integer> categoriesList = new ArrayList<>();
        categoriesList.add(category);
        GetProducts product = new GetProducts(sex_id, 1, categoriesList);
        Call<POJOProducts> call = sitoStoreApi.getProductCategories("application/json", product);
        call.enqueue(new Callback<POJOProducts>() {

            @Override
            public void onResponse(Call<POJOProducts> call, Response<POJOProducts> response) {
                resProducts = response.body().getProducts();
                targetItemAdapter.setProductList(resProducts);
            }

            @Override
            public void onFailure(Call<POJOProducts> call, Throwable t) {
                Log.i("RETRO", t.getMessage());
            }
        });
    }

    public void getProductsOnSearching(String text) {
        MainSearch mainSearch = new MainSearch(text);
        Call<POJOProducts> call = sitoStoreApi.getMainSearch("application/json", mainSearch);
        call.enqueue(new Callback<POJOProducts>() {

            @Override
            public void onResponse(Call<POJOProducts> call, Response<POJOProducts> response) {
                resProducts = response.body().getProducts();
                targetItemAdapter.setProductList(resProducts);
            }

            @Override
            public void onFailure(Call<POJOProducts> call, Throwable t) {
                Log.i("RETRO", t.getMessage());
            }
        });
    }

}
