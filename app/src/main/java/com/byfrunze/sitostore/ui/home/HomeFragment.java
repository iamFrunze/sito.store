package com.byfrunze.sitostore.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.byfrunze.sitostore.R;
import com.byfrunze.sitostore.ui.catalog.TargetItemActivity;



public class HomeFragment extends Fragment {

    private CardView cardViewMen;
    private CardView cardViewWomen;
    private CardView cardViewFavourite;

    private String BUNDLE_LAST_PAGE = "LAST_PAGE";
    private String BUNDLE_NAME_PAGE = "HOME PAGE";
    private String BUNDLE_KEY_MEN = "MEN";
    private String BUNDLE_KEY_WOMEN = "WOMEN";


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_home, container, false);
        getActivity().setTitle(R.string.app_name);
        cardViewMen = root.findViewById(R.id.cardViewMen);
        cardViewWomen = root.findViewById(R.id.CVWomen);
        cardViewFavourite = root.findViewById(R.id.CVFavourite);

        cardViewMen.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), TargetItemActivity.class);
            intent.putExtra(BUNDLE_NAME_PAGE, BUNDLE_KEY_MEN);
            intent.putExtra(BUNDLE_LAST_PAGE, BUNDLE_NAME_PAGE);
            startActivity(intent);
        });
        cardViewWomen.setOnClickListener(v-> {
            Intent intent = new Intent(getContext(), TargetItemActivity.class);
            intent.putExtra(BUNDLE_NAME_PAGE, BUNDLE_KEY_WOMEN);
            intent.putExtra(BUNDLE_LAST_PAGE, BUNDLE_NAME_PAGE);

            startActivity(intent);
        });


        return root;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

}