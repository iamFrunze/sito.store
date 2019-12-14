package com.byfrunze.sitostore.ui.catalog;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.byfrunze.sitostore.R;
import com.byfrunze.sitostore.myRetrofit.NetworkService;
import com.byfrunze.sitostore.myRetrofit.SitoStoreApi;
import com.google.android.material.tabs.TabLayout;


import java.util.HashMap;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatalogFragment extends Fragment{

    private CatalogViewModel catalogViewModel;

    private NetworkService networkService;
    private SitoStoreApi sitoStoreApi;
    private FragmentActivity myContext;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        catalogViewModel = ViewModelProviders.of(this).get(CatalogViewModel.class);
        View root = inflater.inflate(R.layout.fragment_catalog, container, false);
        viewPager = root.findViewById(R.id.viewPager_catalog);
        tabLayout = root.findViewById(R.id.tabLayout_catalog);
        networkService = NetworkService.getInstance();
        sitoStoreApi = NetworkService.getApi();



        ViewPagerAdapter adapter =
                new ViewPagerAdapter(myContext.getSupportFragmentManager());
        adapter.addFragment(new ListOfProductUnisex(), "Unisex");
        adapter.addFragment(new ListOfProductMen(), "Men");
        adapter.addFragment(new ListOfProductWoman(), "Women");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return root;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public void onAttach(@NonNull Context context) {
        myContext = (FragmentActivity) context;
        super.onAttach(context);

    }

    public void getProduct() {
        Map<String, Integer> mapJson = new HashMap<>();
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
