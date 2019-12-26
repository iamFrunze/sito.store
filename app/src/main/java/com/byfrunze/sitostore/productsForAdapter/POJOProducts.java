package com.byfrunze.sitostore.productsForAdapter;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class POJOProducts {

    @SerializedName("products")
    @Expose
    private List<Product> products = null;
    @SerializedName("info")
    @Expose
    private List<Info> info = null;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Info> getInfo() {
        return info;
    }

    public void setInfo(List<Info> info) {
        this.info = info;
    }

}