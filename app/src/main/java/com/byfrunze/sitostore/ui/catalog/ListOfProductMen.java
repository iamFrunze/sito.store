package com.byfrunze.sitostore.ui.catalog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.byfrunze.sitostore.R;

public class ListOfProductMen extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.catalog_men, container, false);
        ListView productsList = root.findViewById(R.id.list_view_men);
        String[] produts = getResources().getStringArray(R.array.arrayListViewMen);

        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, produts);
        productsList.setAdapter(adapter);
        return root;

    }
}
