package com.byfrunze.sitostore.ui.catalog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.byfrunze.sitostore.Adapters.TargetItemAdapter;
import com.byfrunze.sitostore.ArgRequest.GetProducts;
import com.byfrunze.sitostore.DBRealm.DataHelper;
import com.byfrunze.sitostore.FavouriteDataBase;
import com.byfrunze.sitostore.R;
import com.byfrunze.sitostore.myRetrofit.JSONUtils;
import com.byfrunze.sitostore.productsForAdapter.Product;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import io.realm.Realm;
import io.realm.RealmResults;

public class TargetItemActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ImageView imageViewFavourite;
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
    private List<Product> listOfProduct;
    private TargetItemAdapter adapter;
    private Realm mRealm;

    private TextView textViewFilterBrands;
    private TextView textViewFilterSexId;
    private TextView textViewFilterCategories;
    private TextView textViewFilterSizes;
    private TextView textViewFilterColors;
    private TextView textViewFilterPrices;
    private TextView textViewFilterSales;
    private View llbottomSheet;
    private BottomSheetBehavior bottomSheetBehavior;

    private EditText editTextFrom;
    private EditText editTextTo;


    private String TAG = "TAG";

    private int favouriteIcon = R.drawable.icon_favourite;
    private int unfavouriteIcon = R.drawable.icon_unfavourite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target_item);
        textViewFilterBrands = findViewById(R.id.filter_brands);
        textViewFilterSexId = findViewById(R.id.filter_sex_id);
        textViewFilterCategories = findViewById(R.id.filter_categories);
        textViewFilterSizes = findViewById(R.id.filter_sizes);
        textViewFilterColors = findViewById(R.id.filter_colors);
        textViewFilterPrices = findViewById(R.id.filter_prices);
        textViewFilterSales = findViewById(R.id.filter_sales);
        llbottomSheet = findViewById(R.id.bottom_sheet);
        bottomSheetBehavior = BottomSheetBehavior.from(llbottomSheet);
        editTextFrom = findViewById(R.id.editTextFrom);
        editTextTo = findViewById(R.id.editTextTo);

        mRealm = Realm.getDefaultInstance();

        Bundle bundle = getIntent().getExtras();
        recyclerView = findViewById(R.id.recycler_view_target);
        setupActionBar(bundle);
        titleCategory = bundle.getString("Title");
        adapter = new TargetItemAdapter(mRealm.where(FavouriteDataBase.class).findAll());

        jsonUtils = new JSONUtils(recyclerView, this, adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        setItems(bundle);

        DataHelper.res = mRealm.where(FavouriteDataBase.class).findAll();
        Log.i("TAG", "\n" + DataHelper.res.size());


        adapter.setListener((itemView, position, view, listProduct) -> {
            String TAG = "TAG";
            if (view.getTag().equals("true")) {
                DataHelper.addItem(mRealm, listProduct, position);
                Log.i(TAG, "onCreateADD: " + mRealm.where(FavouriteDataBase.class).findAllAsync());
                Log.i(TAG, "SIZE: " + mRealm.where(FavouriteDataBase.class).findAll().size());

            } else {
                DataHelper.deleteItem(mRealm, listProduct.get(position).getId());
                //DataHelper.deleteItem(mRealm, listProduct, position);
                Log.i(TAG, "onCreateDELETE: " + mRealm.where(FavouriteDataBase.class).findAllAsync());
                Log.i(TAG, "SIZE: " + mRealm.where(FavouriteDataBase.class).findAll().size());
            }
        });
        recyclerView.setOnFlingListener(new RecyclerView.OnFlingListener() {
            @Override
            public boolean onFling(int velocityX, int velocityY) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                return false;
            }
        });
        setupDialogSexId();
        setupDialogBrands();
        setupDialogCategories();
        setupDialogSizes();
        setupDialogColors();
        setupDialogPrices();
        setupDialogSales();


    }

    public void setupDialogSexId() {
        boolean[] isCheckedItems = {false, false, false};
        textViewFilterSexId.setOnClickListener(v -> {
            String[] items = {"Унисекс", "Мужской", "Женский"};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.sex_id);

            builder.setMultiChoiceItems(items, isCheckedItems,
                    (dialog, which, isChecked) -> {
                        Log.i(TAG, "onClick: " + which + " " + isChecked);
                        isCheckedItems[which] = isChecked;
                    });

            builder.setPositiveButton("Okey", null);

            builder.setNegativeButton("Cancel",
                    (dialog, which) -> {
                        for (int i = 0; i < 3; i++) isCheckedItems[i] = false;
                    });

            builder.show();
        });
    }

    public void setupDialogBrands() {
        textViewFilterBrands.setOnClickListener(v -> {
            //ЖДЕМ АПИ
        });

    }

    public void setupDialogCategories() {
        String[] сategoriesForDA = getResources().getStringArray(R.array.arrayListViewUnisex);
        int sizeCat = сategoriesForDA.length;
        boolean[] isCheckedCategories = new boolean[sizeCat];
        for (int i = 0; i < sizeCat; i++) {
            isCheckedCategories[i] = false;
        }
        textViewFilterCategories.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle(R.string.categories);

            builder.setMultiChoiceItems(R.array.arrayListViewUnisex, isCheckedCategories,
                    (dialog, which, isChecked) -> {
                        isCheckedCategories[which] = isChecked;
                    }
            );

            builder.setPositiveButton("Okey", null);

            builder.setNegativeButton("Cancel",
                    (dialog, which) -> {
                        for (int i = 0; i < sizeCat; i++) isCheckedCategories[i] = false;
                    });

            builder.show();
        });
    }

    public void setupDialogSizes() {

    }

    public void setupDialogColors() {

    }

    public void setupDialogPrices() {
        textViewFilterPrices.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            final View v1 = getLayoutInflater().inflate(R.layout.dialog_price_sale, null);
            builder.setTitle(R.string.prices);
            builder.setView(v1);
            builder.setPositiveButton("Okey", (dialog, which) -> {
                long priceFrom = Long.valueOf(editTextFrom.getText().toString());

                long priceTo = Long.valueOf(editTextTo.getText().toString());
            });
            builder.setNegativeButton("Cancel", (dialog, which) -> {

            });
            builder.create();
            builder.show();
        });

    }

    public void setupDialogSales() {
        textViewFilterPrices.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            final View v1 = getLayoutInflater().inflate(R.layout.dialog_price_sale, null);
            builder.setTitle(R.string.sales);
            builder.setView(v1);
            builder.setPositiveButton("Okey", (dialog, which) -> {
                long priceFrom = Long.valueOf(editTextFrom.getText().toString());

                long priceTo = Long.valueOf(editTextTo.getText().toString());
            });
            builder.setNegativeButton("Cancel", (dialog, which) -> {

            });
            builder.create();
            builder.show();
        });
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
                    listOfProduct = jsonUtils.getResProducts();
                }
            }
            if (bundle.getString(BUNDLE_LAST_PAGE).equals(BUNDLE_LIST_MEN)) {
                category = ListOfProductMen.createMap().get(titleCategory);
                getProducts.setCategories(Collections.singletonList(category));
                getProducts.setSex_id(1);
                jsonUtils.getProductsApi(getProducts);
                listOfProduct = jsonUtils.getResProducts();
            }
            if (bundle.getString(BUNDLE_LAST_PAGE).equals(BUNDLE_LIST_WOMEN)) {
                category = ListOfProductWoman.createMap().get(titleCategory);
                getProducts.setCategories(Collections.singletonList(category));
                getProducts.setSex_id(2);
                jsonUtils.getProductsApi(getProducts);
                listOfProduct = jsonUtils.getResProducts();
            }
            if (bundle.getString(BUNDLE_LAST_PAGE).equals(BUNDLE_LIST_UNISEX)) {
                category = ListOfProductUnisex.createMap().get(titleCategory);
                getProducts.setCategories(Collections.singletonList(category));
                getProducts.setSex_id(0);
                jsonUtils.getProductsApi(getProducts);
                listOfProduct = jsonUtils.getResProducts();
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


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRealm.close();
    }

    public void check(View view) {
        if (bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        } else bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

    }


}


