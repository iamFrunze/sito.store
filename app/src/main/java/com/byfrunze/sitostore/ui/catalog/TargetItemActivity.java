package com.byfrunze.sitostore.ui.catalog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.byfrunze.sitostore.ArgRequest.GetProducts;
import com.byfrunze.sitostore.R;
import com.byfrunze.sitostore.myRetrofit.JSONUtils;

import java.util.Collections;

public class TargetItemActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private int category;
    private JSONUtils jsonUtils;

    private String BUNDLE_LAST_PAGE = "LAST_PAGE";
    private String BUNDLE_HOME_KEY = "HOME PAGE";
    private String BUNDLE_FROM_MEN = "MEN";
    private String BUNDLE_FROM_WOMEN = "WOMEN";
    private String BUNDLE_LIST_WOMEN = "LIST WOMEN PAGE";
    private String BUNDLE_LIST_UNISEX = "LIST UNISEX PAGE";
    private String BUNDLE_LIST_MEN = "LIST MEN PAGE";
    String titleCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target_item);
        Bundle bundle = getIntent().getExtras();
        recyclerView = findViewById(R.id.recycler_view_target);
        setupActionBar(bundle);
        titleCategory = bundle.getString("Title");
        jsonUtils = new JSONUtils(recyclerView, this);
        setItems(bundle);


    }

    public void setItems(Bundle bundle) {
        GetProducts getProducts = new GetProducts();

        if (!bundle.isEmpty()) {
            if (bundle.getString(BUNDLE_LAST_PAGE).equals(BUNDLE_HOME_KEY)) {

                if (bundle.getString(BUNDLE_HOME_KEY).equals(BUNDLE_FROM_MEN)) {
                    getProducts.setSex_id(1);
                    jsonUtils.getProductsApi(getProducts);
                }
                if (bundle.getString(BUNDLE_HOME_KEY).equals(BUNDLE_FROM_WOMEN)) {
                    getProducts.setSex_id(2);
                    getProducts.getCategories(2);
                    jsonUtils.getProductsApi(getProducts);
                }
            }
            if (bundle.getString(BUNDLE_LAST_PAGE).equals(BUNDLE_LIST_MEN)) {
                category = ListOfProductMen.createMap().get(titleCategory);
                getProducts.setCategories(Collections.singletonList(category));
                getProducts.setSex_id(1);
                jsonUtils.getProductsApi(getProducts);
            }
            if (bundle.getString(BUNDLE_LAST_PAGE).equals(BUNDLE_LIST_WOMEN)) {
                category = ListOfProductWoman.createMap().get(titleCategory);
                getProducts.setCategories(Collections.singletonList(category));
                getProducts.setSex_id(2);
                jsonUtils.getProductsApi(getProducts);
            }
            if (bundle.getString(BUNDLE_LAST_PAGE).equals(BUNDLE_LIST_UNISEX)) {
                category = ListOfProductUnisex.createMap().get(titleCategory);
                getProducts.setCategories(Collections.singletonList(category));
                getProducts.setSex_id(0);
                jsonUtils.getProductsApi(getProducts);
            }

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    public void setupActionBar(Bundle bundle) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(bundle.getString("Title"));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}


