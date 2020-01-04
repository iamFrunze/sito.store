package com.byfrunze.sitostore.ui.cart;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.byfrunze.sitostore.Adapters.CartRealmAdapter;
import com.byfrunze.sitostore.DBRealm.DataHelper;
import com.byfrunze.sitostore.FavouriteDataBase;
import com.byfrunze.sitostore.R;
import com.byfrunze.sitostore.viewModels.CartViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

import io.realm.Realm;
import io.realm.RealmResults;

public class CartFragment extends Fragment {


    private RecyclerView recyclerView;
    private CartViewModel viewModel;
    private TextView textViewAllCount;
    private TextView textViewAllSumm;
    private TextView textViewAllSale;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_cart, container, false);
        viewModel = ViewModelProviders.of(this).get(CartViewModel.class);
        recyclerView = root.findViewById(R.id.recycleViewCart);
        textViewAllCount = root.findViewById(R.id.textViewAllCount);
        textViewAllSumm = root.findViewById(R.id.textViewAllSumm);
        textViewAllSale = root.findViewById(R.id.textViewAllPrice);



        Results results = new Results();


        Realm realm = Realm.getDefaultInstance();
        RealmResults<FavouriteDataBase> DB = realm.where(FavouriteDataBase.class).findAll();
        Log.i("TAG", "onCreateView: " + DB.size());
        textViewAllCount.setText(String.valueOf(results.getCountItem(DB)));
        textViewAllSumm.setText(String.valueOf(results.getSummPrice(DB)));
        textViewAllSale.setText(String.valueOf(results.getSummSale(DB)));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        CartRealmAdapter adapter = new CartRealmAdapter(DB, true);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(position -> {
            DataHelper.deleteItem(realm, DB.get(position).getId());
            textViewAllCount.setText(String.valueOf(results.getCountItem(DB)));
            textViewAllSumm.setText(String.valueOf(results.getSummPrice(DB)));
            textViewAllSale.setText(String.valueOf(results.getSummSale(DB)));
        });
        return root;

    }


}
