package com.byfrunze.sitostore.sitoStoreElementsOfProducts;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PriceHist {

    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("date")
    @Expose
    private String date;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}