package com.byfrunze.sitostore.ui.catalog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
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

import java.util.Set;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import retrofit2.Call;

public class TargetItemActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CatalogProductAdapter adapter;
    private final String PAGE = "page";
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target_item);
        Bundle bundle = getIntent().getExtras();
        setupActionBar(bundle);
        JSONUtils jsonUtils = new JSONUtils();
        recyclerView = findViewById(R.id.recycler_view_target);
        jsonUtils.getProduct(PAGE, 1, recyclerView, getApplicationContext());

        toolbar = findViewById(R.id.toolbar_item_catalog);


    }

    @SuppressLint("CheckResult")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.catalog_search, menu);
        MenuItem menuItem;
        final SearchView searchView = (SearchView) menu.findItem(R.id.menu_catalog_search).getActionView();
        ;

        Observable.create((ObservableOnSubscribe<String>)
                emitter -> searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.i("RX" , query);
                return false;
            }


            @Override
            public boolean onQueryTextChange(String newText) {
                Log.i("RX1" , newText);
                return false;
            }
        }));

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
            case R.id.navigation_home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
