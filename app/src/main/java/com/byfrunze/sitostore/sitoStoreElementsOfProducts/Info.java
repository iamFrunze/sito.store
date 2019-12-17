package com.byfrunze.sitostore.sitoStoreElementsOfProducts;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("totalPages")
    @Expose
    private Integer totalPages;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

}