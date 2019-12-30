package com.byfrunze.sitostore.ArgRequest;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GetProducts {
    private int sex_id;
    private int page;
    private List<String> brands;
    private List<Integer> categories;
    private List<String> size;
    private List<String> color;
    private List<Integer> prices;
    private List<Integer> sales;
    private int limit;
    private boolean isFavourite;


    public GetProducts(int page, List<String> brands, List<Integer> categories, List<String> sizes, List<String> colors, List<Integer> prices, List<Integer> sales, int limit) {
        this.page = page;
        this.brands = brands;
        this.categories = categories;
        this.size = sizes;
        this.color = colors;
        if (!prices.isEmpty()) {
            this.prices = prices;
        } else {
            this.prices = Arrays.asList(0, 30000);
        }
        if (!sales.isEmpty()) {
            this.sales = sales;
        } else {
            this.sales = Arrays.asList(30, 100);
        }
        this.limit = limit;
    }

    public GetProducts(int sex_id, int page, List<Integer> categories) {
        this.sex_id = sex_id;
        this.page = page;
        this.categories = categories;
    }

    public GetProducts() {
        this.page = 1;

        this.limit = 10;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public void setSex_id(int sex_id) {
        this.sex_id = sex_id;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setBrands(List<String> brands) {
        this.brands = brands;
    }

    public void setCategories(List<Integer> categories) {
        this.categories = categories;
    }

    public void setSizes(List<String> sizes) {
        this.size = sizes;
    }

    public void setColors(List<String> colors) {
        this.color = colors;
    }

    public void setPrices(List<Integer> prices) {
        this.prices = prices;
    }

    public void setSales(List<Integer> sales) {
        this.sales = sales;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @NonNull
    @Override
    public String toString() {
        return "{" + " \"sex_id\" : " + sex_id + ", " +
                " \" page\" : " + page + ", " +
                " \" brands\" : " + brands + ", " +
                " \" categories\" : " + categories + ", " +
                " \" sizes\" : " + size + ", " +
                " \" colors\" : " + color + ", " +
                " \" prices\" : " + prices + ", " +
                " \" sales\" : " + sales + ", " +
                " \" limit\" : " + limit + "}";
    }

    public void getCategories(int sex_id_FP) {
        switch (sex_id_FP) {
            case 0:
            case 2:
                setCategories(Arrays.asList(1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009,
                        1010, 1011, 1012, 1013, 1014, 2000, 2001, 2002, 2003, 2004, 2005, 3000, 3001, 3002, 3003,
                        3004, 3005, 3006, 3007, 3008, 3009, 3010, 3011));
                break;
            case 1:
                setCategories(Arrays.asList(1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1010, 1011,
                        1012, 1013, 2000, 2001, 2002, 2003, 2004, 2005, 3000, 3001, 3002, 3004, 3005, 3006,
                        3007, 3008, 3009, 3010, 3011));
                break;
            default:
                setCategories(null);

        }

//        List<Integer> men = Arrays.asList(1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1010, 1011,
//                1012, 1013, 2000, 2001, 2002, 2003, 2004, 2005, 3000, 3001, 3002, 3004, 3005, 3006,
//                3007, 3008, 3009, 3010, 3011);
//        List<Integer> women = Arrays.asList(1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009,
//                1010, 1011, 1012, 1013, 1014, 2000, 2001, 2002, 2003, 2004, 2005, 3000, 3001, 3002, 3003,
//                3004, 3005, 3006, 3007, 3008, 3009, 3010, 3011);
//        List<Integer> unisex = Arrays.asList(1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009,
//                1010, 1011, 1012, 1013, 1014, 2000, 2001, 2002, 2003, 2004, 2005, 3000, 3001, 3002, 3003,
//                3004, 3005, 3006, 3007, 3008, 3009, 3010, 3011);
    }
}

