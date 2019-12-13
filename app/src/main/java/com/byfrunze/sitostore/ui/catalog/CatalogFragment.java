package com.byfrunze.sitostore.ui.catalog;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.byfrunze.sitostore.R;
import com.byfrunze.sitostore.myRetrofit.NetworkService;
import com.byfrunze.sitostore.myRetrofit.SitoStoreApi;
import com.byfrunze.sitostore.myRetrofit.SitoStoreProduct;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CatalogFragment extends Fragment{

    private CatalogViewModel catalogViewModel;
    private Button btn;
    private EditText editText;
    public final String BASE_URL = "http://sito.store:8081";


    public Gson gson = new GsonBuilder().create();
    private Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .build();

    private SitoStoreApi sitoStoreApi = retrofit.create(SitoStoreApi.class);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        catalogViewModel = ViewModelProviders.of(this).get(CatalogViewModel.class);
        View root = inflater.inflate(R.layout.fragment_catalog, container, false);
        btn = root.findViewById(R.id.button);
        editText = root.findViewById(R.id.editText);



        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getProduct();
            }
        });

        return root;
    }


    public void getProduct(){
        Map <String, Integer> mapJson = new HashMap<>();
        mapJson.put("page", 1);
        Call<Object> call = sitoStoreApi.getProduct(mapJson);
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
