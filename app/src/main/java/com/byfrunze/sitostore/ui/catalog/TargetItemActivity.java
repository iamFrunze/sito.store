package com.byfrunze.sitostore.ui.catalog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView.OnQueryTextListener;

import com.byfrunze.sitostore.R;
import com.byfrunze.sitostore.myRetrofit.JSONUtils;
import com.byfrunze.sitostore.myRetrofit.NetworkService;
import com.byfrunze.sitostore.myRetrofit.SitoStoreApi;
import com.byfrunze.sitostore.sitoStoreElementsOfProducts.MyProduct;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import retrofit2.Call;

public class TargetItemActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CatalogProductAdapter adapter;
    private final String PAGE = "page";
    Toolbar toolbar;
    private int category;
    private int sex_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target_item);
        Intent bundle = getIntent();
        setupActionBar(bundle.getExtras());
        JSONUtils jsonUtils = new JSONUtils();
        recyclerView = findViewById(R.id.recycler_view_target);
        String titleCategory = bundle.getStringExtra("Title");
        sex_id = bundle.getIntExtra("sex_id", 0);
        switch (sex_id) {
            case 0:
                category = ListOfProductUnisex.createMap().get(titleCategory);
                break;
            case 1:
                category = ListOfProductMen.createMap().get(titleCategory);
                break;
            case 2:
                category = ListOfProductWoman.createMap().get(titleCategory);
                break;
            default:
                category = 0;

        }
        Log.i("INFO", sex_id + " " + category);
        jsonUtils.getProductsForCatalog(sex_id, category, recyclerView, this);
        toolbar = findViewById(R.id.toolbar_item_catalog);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.catalog_search, menu);
        MenuItem menuItem;
        SearchView searchView = (SearchView) menu.findItem(R.id.menu_catalog_search).getActionView();
        RxSearch.fromSearchView(searchView)
                .debounce(300, TimeUnit.MILLISECONDS)
                .filter(item -> item.length() > 1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(query -> {
                    Log.i("SUB", query);

                });
        return true;
    }

    public void setupActionBar(Bundle bundle) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(bundle.getString("Title"));
        bundle.clear();
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


