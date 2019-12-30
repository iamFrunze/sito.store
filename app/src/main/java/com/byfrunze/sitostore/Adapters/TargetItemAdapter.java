package com.byfrunze.sitostore.Adapters;

import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.byfrunze.sitostore.DBRealm.DataHelper;
import com.byfrunze.sitostore.FavouriteDataBase;
import com.byfrunze.sitostore.R;
import com.byfrunze.sitostore.productsForAdapter.Product;
import com.squareup.picasso.Picasso;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class TargetItemAdapter extends RecyclerView.Adapter<TargetItemAdapter.CustomViewHolder> implements RealmChangeListener {


    private FavouriteDataBase favouriteDataBase;
    private RealmResults<FavouriteDataBase> mFavouriteDB;
    private int favouriteIcon = R.drawable.icon_favourite;
    private int unfavouriteIcon = R.drawable.icon_unfavourite;

    public interface OnItemClickListener {
        void onItemClickListener(View itemView, int position, ImageView view, List<Product> LProduct);
    }


    private OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    private List<Product> productList;


    public void setProductList(List<Product> productList) {
        this.productList = productList;
        notifyDataSetChanged();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public TargetItemAdapter() {

        this.productList = new ArrayList<>();
        this.favouriteDataBase = new FavouriteDataBase();
    }

    public TargetItemAdapter(RealmResults<FavouriteDataBase> favouriteDataBases) {
        this.mFavouriteDB = favouriteDataBases;
        this.productList = new ArrayList<>();
        this.favouriteDataBase = new FavouriteDataBase();
    }

    private final String RUB = " RUB";

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_for_catalog, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Product myProduct = productList.get(position);
        Picasso.get().load(productList.get(position).getImg().get(0))
                .placeholder(R.drawable.defoult_product).into(holder.imageViewCatalog);
        holder.textViewTitle.setText(myProduct.getTitle());
        holder.textViewDescription.setText(myProduct.getDescription());
        String price = myProduct.getPrice() + RUB;
        holder.textViewPrice.setText(price);
        String olPrice = myProduct.getOldprice() + RUB;
        holder.textViewOldPrice.setText(olPrice);
        holder.textViewOldPrice.setPaintFlags(holder.textViewOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        String sale = myProduct.getSale() + RUB;
        holder.textViewSale.setText(sale);
        String TAG = "TAG";
        for (int i = 0; i < mFavouriteDB.size(); i++) {
            if (mFavouriteDB.get(i).getId().equals(myProduct.getId())) {
                holder.imageViewFavourite.setImageResource(favouriteIcon);
                myProduct.setFavourite(true);
                holder.imageViewFavourite.setTag("true");
            }

        }

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    @Override
    public void onChange(Object o) {
        notifyDataSetChanged();
    }

    public FavouriteDataBase getFavouriteDataBase() {
        return favouriteDataBase;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageViewCatalog;
        TextView textViewTitle;
        TextView textViewDescription;
        TextView textViewOldPrice;
        TextView textViewPrice;
        TextView textViewSale;
        ImageView imageViewFavourite;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewCatalog = itemView.findViewById(R.id.image_view_item);
            textViewTitle = itemView.findViewById(R.id.title_item_catalog);
            textViewDescription = itemView.findViewById(R.id.desc_item_catalog);
            textViewOldPrice = itemView.findViewById(R.id.oldPrice_item_catalog);
            textViewPrice = itemView.findViewById(R.id.price_item_catalog);
            textViewSale = itemView.findViewById(R.id.sale_item_catalog);
            imageViewFavourite = itemView.findViewById(R.id.imageViewLike);

            imageViewFavourite.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            if (listener != null) {
                if (imageViewFavourite.getTag().equals("false")) {
                    imageViewFavourite.setImageResource(favouriteIcon);
                    imageViewFavourite.setTag("true");
                } else {
                    imageViewFavourite.setImageResource(unfavouriteIcon);
                    imageViewFavourite.setTag("false");
                }
//                favouriteDataBase.setId(productList.get(getLayoutPosition()).getId());
//                favouriteDataBase.setTitle(productList.get(getLayoutPosition()).getTitle());
//                favouriteDataBase.setDescription(productList.get(getLayoutPosition()).getDescription());
//                favouriteDataBase.setUrl(productList.get(getLayoutPosition()).getUrl());
//                favouriteDataBase.setImg(productList.get(getLayoutPosition()).getImg().get(0));
//                favouriteDataBase.setBrand(productList.get(getLayoutPosition()).getBrand());
//                favouriteDataBase.setPrice(productList.get(getLayoutPosition()).getPrice());
//                favouriteDataBase.setOldprice(productList.get(getLayoutPosition()).getOldprice());
//                favouriteDataBase.setSale(productList.get(getLayoutPosition()).getSale());
                listener.onItemClickListener(itemView, getLayoutPosition(), (ImageView) v, productList);

            }

        }

    }
}
