package com.byfrunze.sitostore.ui.catalog;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
                             final Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.catalog_men, container, false);
        ListView productsList = root.findViewById(R.id.list_view_men);
        final String[] products = getResources().getStringArray(R.array.arrayListViewMen);

        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, products);
        productsList.setAdapter(adapter);


        productsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), TargetItemActivity.class);
                intent.putExtra("Title", products[position]);
                startActivity(intent);
            }
        });
        return root;

    }
}
