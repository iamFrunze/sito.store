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

import com.byfrunze.sitostore.Adapters.CartRealmAdapter;
import com.byfrunze.sitostore.FavouriteDataBase;
import com.byfrunze.sitostore.R;
import com.byfrunze.sitostore.viewModels.CartViewModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class CartFragment extends Fragment {


    private RecyclerView recyclerView;
    private CartViewModel viewModel;
    private Realm realm;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_cart, container, false);
        viewModel = ViewModelProviders.of(this).get(CartViewModel.class);
        recyclerView = root.findViewById(R.id.recycleViewCart);

        Realm realm = Realm.getDefaultInstance();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        CartRealmAdapter adapter = new CartRealmAdapter(realm.where(FavouriteDataBase.class).findAllAsync(), true);
        recyclerView.setAdapter(adapter);

        return root;

    }


}
