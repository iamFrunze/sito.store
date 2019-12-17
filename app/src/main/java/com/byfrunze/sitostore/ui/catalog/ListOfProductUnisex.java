package com.byfrunze.sitostore.ui.catalog;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.byfrunze.sitostore.MainActivity;
import com.byfrunze.sitostore.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListOfProductUnisex extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.catalog_unisex, container, false);

        final ListView productsList = root.findViewById(R.id.list_view_unisex);
        final String[] products = getResources().getStringArray(R.array.arrayListViewUnisex);

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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public Map<String, Integer> createMap() {
        Map<String, Integer> unisex = new HashMap<>();
        unisex.put("Одежда (прочее)", 1000);
        unisex.put("Футболки, майки и топы", 1001);
        unisex.put("Рубашки и блузы", 1002);
        unisex.put("Толстовки и свитеры", 1003);
        unisex.put("Костюмы, пиджаки и жакеты", 1004);
        unisex.put("Джинсы и одежда из денима", 1005);
        unisex.put("Брюки и леггинсы", 1006);
        unisex.put("Шорты", 1007);
        unisex.put("Платья и сарафаны", 1008);
        unisex.put("Юбки", 1009);
        unisex.put("Куртки", 1010);
        unisex.put("Пальто, шубы и дубленки", 1011);
        unisex.put("Спорт", 1012);
        unisex.put("Нижнее белье и боди", 1013);
        unisex.put("Комбенизоны", 1014);
        unisex.put("Обувь (прочее)", 2000);
        unisex.put("Кеды и кроссовки", 2001);
        unisex.put("Ботинки и сапоги", 2002);
        unisex.put("Туфли", 2003);
        unisex.put("Лоферы", 2004);
        unisex.put("Летняя обувь", 2005);
        unisex.put("Без категории", 3000);
        unisex.put("Сумки и рюкзаки", 3001);
        unisex.put("Кошельки и визитницы", 3002);
        unisex.put("Косметички", 3003);
        unisex.put("Головные уборы", 3004);
        unisex.put("Шарфы и платки", 3005);
        unisex.put("Перчатки и варежки", 3006);
        unisex.put("Украшения и часы", 3007);
        unisex.put("Очки", 3008);
        unisex.put("Ремни", 3009);
        unisex.put("Галстуки и бабочки", 3010);
        unisex.put("Зонты", 3011);
        return unisex;
    }


}
