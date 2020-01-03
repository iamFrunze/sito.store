package com.byfrunze.sitostore.DBRealm;

import android.util.Log;

import com.byfrunze.sitostore.FavouriteDataBase;
import com.byfrunze.sitostore.productsForAdapter.Product;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class DataHelper {

    public static RealmResults<FavouriteDataBase> res;
    public static void addItem(Realm realm, List<Product> productList, int pos) {
        realm.executeTransaction(realm1 -> {
            FavouriteDataBase favouriteDataBase = realm.createObject(FavouriteDataBase.class);
            favouriteDataBase.setId(productList.get(pos).getId());
            favouriteDataBase.setTitle(productList.get(pos).getTitle());
            favouriteDataBase.setDescription(productList.get(pos).getDescription());
            favouriteDataBase.setUrl(productList.get(pos).getUrl());
            favouriteDataBase.setImg(productList.get(pos).getImg().get(0));
            favouriteDataBase.setBrand(productList.get(pos).getBrand());
            favouriteDataBase.setPrice(productList.get(pos).getPrice());
            favouriteDataBase.setOldprice(productList.get(pos).getOldprice());
            favouriteDataBase.setSale(productList.get(pos).getSale());
        });
    }

    public static void deleteItem(Realm mRealm,String id) {
        mRealm.executeTransaction(realm -> {
            RealmResults<FavouriteDataBase> favouriteDB = mRealm.where(FavouriteDataBase.class)
                    .equalTo("id", id).findAll();
            if (!favouriteDB.isEmpty()) {
                for (FavouriteDataBase DB : favouriteDB) {
                    Log.i("TAG", "\ndeleteItem: " + DB.getTitle());

                    DB.deleteFromRealm();

                }
            }
        });
    }


}
