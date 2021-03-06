package com.byfrunze.sitostore.ui.catalog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.byfrunze.sitostore.Adapters.ViewPagerAdapter;
import com.byfrunze.sitostore.R;
import com.google.android.material.tabs.TabLayout;


public class CatalogFragment extends Fragment{



    private FragmentActivity myContext;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_catalog, container, false);
        viewPager = root.findViewById(R.id.viewPager_catalog);
        tabLayout = root.findViewById(R.id.tabLayout_catalog);

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

}
