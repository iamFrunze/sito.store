package com.byfrunze.sitostore.ui.cart;

import com.byfrunze.sitostore.FavouriteDataBase;

import io.realm.RealmResults;

public class Results {
    private int countItem;
    private long summPrice;
    private long summSale;


    private Long setSummPrice(RealmResults<FavouriteDataBase> products) {
        long i = 0;
        for (FavouriteDataBase f : products) {
            i += f.getPrice();
        }
        return i;
    }

    private Long setSummSale(RealmResults<FavouriteDataBase> products) {
        long i = 0;
        for (FavouriteDataBase f : products) {
            i += (f.getOldprice() - f.getPrice());
        }
        return i;
    }

    public int getCountItem(RealmResults<FavouriteDataBase> DB) {
        return DB.size();
    }

    public long getSummPrice(RealmResults<FavouriteDataBase> DB) {
        return setSummPrice(DB);
    }

    public long getSummSale(RealmResults<FavouriteDataBase> DB) {
        return setSummSale(DB);
    }
}
