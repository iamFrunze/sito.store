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

import java.util.HashMap;
import java.util.Map;

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
                intent.putExtra("sex_id", 1);
                startActivity(intent);
            }
        });
        return root;

    }

    static public HashMap<String, Integer> createMap() {
        HashMap<String, Integer> men = new HashMap<>();

        men.put("Одежда (прочее)", 1000);
        men.put("Футболки и поло", 1001);
        men.put("Рубашки", 1002);
        men.put("Толстовки и свитеры", 1003);
        men.put("Костюмы и пиджаки", 1004);
        men.put("Джинсы и одежда из денима", 1005);
        men.put("Брюки и чиносы", 1006);
        men.put("Шорты", 1007);
        men.put("Куртки", 1010);
        men.put("Пальто", 1011);
        men.put("Спорт", 1012);
        men.put("Нижнее белье и носки", 1013);
        men.put("Обувь (прочее)", 2000);
        men.put("Кеды и кроссовки", 2001);
        men.put("Ботинки и сапоги", 2002);
        men.put("Туфли", 2003);
        men.put("Лоферы и мокасины", 2004);
        men.put("Летняя обувь", 2005);
        men.put("Без категории", 3000);
        men.put("Сумки и рюкзаки", 3001);
        men.put("Кошельки и визитницы", 3002);
        men.put("Головные уборы", 3004);
        men.put("Шарфы и платки", 3005);
        men.put("Перчатки и варежки", 3006);
        men.put("Украшения и часы", 3007);
        men.put("Очки", 3008);
        men.put("Ремни", 3009);
        men.put("Галстуки и бабочки", 3010);
        men.put("Зонты", 3011);
        return men;
    }
}
