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

import androidx.fragment.app.Fragment;

import com.byfrunze.sitostore.R;

import java.util.HashMap;
import java.util.Map;

public class ListOfProductWoman extends Fragment {

    private String BUNDLE_LAST_PAGE = "LAST_PAGE";
    private String BUNDLE_NAME_PAGE = "LIST WOMEN PAGE";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.catalog_women, container, false);
        ListView productsList = root.findViewById(R.id.list_view_women);
        final String[] products = getResources().getStringArray(R.array.arrayListViewWomen);

        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, products);
        productsList.setAdapter(adapter);

        productsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), TargetItemActivity.class);
                intent.putExtra("Title", products[position]);
                intent.putExtra(BUNDLE_LAST_PAGE, BUNDLE_NAME_PAGE);

                startActivity(intent);
            }
        });

        return root;
    }

    static public HashMap<String, Integer> createMap() {
        HashMap<String, Integer> women = new HashMap<>();
        women.put("Одежда (прочее)", 1000);
        women.put("Футболки, майки и топы", 1001);
        women.put("Рубашки и блузы", 1002);
        women.put("Толстовки и свитеры", 1003);
        women.put("Костюмы, пиджаки и жакеты", 1004);
        women.put("Джинсы и одежда из денима", 1005);
        women.put("Брюки и леггинсы", 1006);
        women.put("Шорты", 1007);
        women.put("Платья и сарафаны", 1008);
        women.put("Юбки", 1009);
        women.put("Куртки", 1010);
        women.put("Пальто, шубы и дубленки", 1011);
        women.put("Спорт", 1012);
        women.put("Нижнее белье и боди", 1013);
        women.put("Комбенизоны", 1014);
        women.put("Обувь (прочее)", 2000);
        women.put("Кеды и кроссовки", 2001);
        women.put("Ботинки и сапоги", 2002);
        women.put("Туфли", 2003);
        women.put("Лоферы", 2004);
        women.put("Летняя обувь", 2005);
        women.put("Без категории", 3000);
        women.put("Сумки и рюкзаки", 3001);
        women.put("Кошельки и визитницы", 3002);
        women.put("Косметички", 3003);
        women.put("Головные уборы", 3004);
        women.put("Шарфы и платки", 3005);
        women.put("Перчатки и варежки", 3006);
        women.put("Украшения и часы", 3007);
        women.put("Очки", 3008);
        women.put("Ремни", 3009);
        women.put("Зонт", 3011);
        return women;
    }
}
