package com.byfrunze.sitostore.ui.catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetProducts {
    private int sex_id;
    private int page;
    private List<String> brands;
    private List<Integer> categories;
    private List<String> sizes;
    private List<String> colors;
    private List<Integer> prices;
    private List<Integer> sales;
    private int limit;


    public GetProducts(int page, List<String> brands, List<Integer> categories, List<String> sizes, List<String> colors, List<Integer> prices, List<Integer> sales, int limit) {
        this.page = page;
        this.brands = brands;
        this.categories = categories;
        this.sizes = sizes;
        this.colors = colors;
        if(!prices.isEmpty()){
            this.prices = prices;
        }
        else {
            this.prices = Arrays.asList(0, 30000);
        }
        if(!sales.isEmpty()){
            this.sales = sales;
        }
        else {
            this.sales = Arrays.asList(30, 100);
        }
        this.limit = limit;
    }

    public GetProducts(int sex_id, int page, List<Integer> categories) {
        this.sex_id = sex_id;
        this.page = page;
        this.categories = categories;
    }
}

