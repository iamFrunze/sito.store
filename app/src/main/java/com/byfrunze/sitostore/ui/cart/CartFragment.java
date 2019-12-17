package com.byfrunze.sitostore.ui.cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.byfrunze.sitostore.R;
import com.byfrunze.sitostore.sitoStoreElementsOfProducts.MyProduct;

import java.util.ArrayList;

public class CartFragment extends Fragment{

    private CartViewModel cartViewModel;

    private RecyclerView recyclerView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        cartViewModel = ViewModelProviders.of(this).get(CartViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cart, container, false);
        recyclerView = root.findViewById(R.id.recycleViewCart);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ProductAdapter productAdapter = new ProductAdapter(arrPorducts());
        recyclerView.setAdapter(productAdapter);
        return root;

    }
    public ArrayList arrPorducts(){
        ArrayList<MyProduct> MyProducts = new ArrayList<>();
        MyProducts.add(new MyProduct("MyTitle",
                "myDesc",
                "URL",
                "https://vans.ru/upload/iblock/7fe/7fe1862d42409df558e2f36439498a8b.jpg",
                "myBrand",
                "mySize",
                "myColor",
                "myPrice",
                "myOldPrice",
                "mySale"));
        MyProducts.add(new MyProduct("MyTitle",
                "myDesc",
                "URL",
                "https://vans.ru/upload/iblock/7fe/7fe1862d42409df558e2f36439498a8b.jpg",
                "myBrand",
                "mySize",
                "myColor",
                "myPrice",
                "myOldPrice",
                "mySale"));
        MyProducts.add(new MyProduct("MyTitle",
                "myDesc",
                "URL",
                "https://vans.ru/upload/iblock/7fe/7fe1862d42409df558e2f36439498a8b.jpg",
                "myBrand",
                "mySize",
                "myColor",
                "myPrice",
                "myOldPrice",
                "mySale"));
        MyProducts.add(new MyProduct("MyTitle",
                "myDesc",
                "URL",
                "https://vans.ru/upload/iblock/7fe/7fe1862d42409df558e2f36439498a8b.jpg",
                "myBrand",
                "mySize",
                "myColor",
                "myPrice",
                "myOldPrice",
                "mySale"));
        MyProducts.add(new MyProduct("MyTitle",
                "myDesc",
                "URL",
                "https://vans.ru/upload/iblock/7fe/7fe1862d42409df558e2f36439498a8b.jpg",
                "myBrand",
                "mySize",
                "myColor",
                "myPrice",
                "myOldPrice",
                "mySale"));
        MyProducts.add(new MyProduct("MyTitle",
                "myDesc",
                "URL",
                "https://vans.ru/upload/iblock/7fe/7fe1862d42409df558e2f36439498a8b.jpg",
                "myBrand",
                "mySize",
                "myColor",
                "myPrice",
                "myOldPrice",
                "mySale"));
        MyProducts.add(new MyProduct("MyTitle",
                "myDesc",
                "URL",
                "https://vans.ru/upload/iblock/7fe/7fe1862d42409df558e2f36439498a8b.jpg",
                "myBrand",
                "mySize",
                "myColor",
                "myPrice",
                "myOldPrice",
                "mySale"));

        return MyProducts;
    }

}
