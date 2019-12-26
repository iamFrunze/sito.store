package com.byfrunze.sitostore.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.byfrunze.sitostore.R;
import com.byfrunze.sitostore.myRetrofit.JSONUtils;

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private RecyclerView recyclerView;
    private JSONUtils  jsonUtils;
    private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        recyclerView = findViewById(R.id.recycler_view_search);
        searchView = findViewById(R.id.searchViewAll);
        searchView.setOnQueryTextListener(this);
        //jsonUtils = new JSONUtils(recyclerView, this, recycle);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.i("TEXT", query);
        jsonUtils.getProductsOnSearching(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.i("TEXT", newText);

        return false;
    }
}
