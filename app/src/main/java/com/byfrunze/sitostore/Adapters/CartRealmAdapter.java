package com.byfrunze.sitostore.Adapters;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.byfrunze.sitostore.FavouriteDataBase;
import com.byfrunze.sitostore.R;
import com.squareup.picasso.Picasso;

import io.realm.OrderedRealmCollection;
import io.realm.RealmChangeListener;
import io.realm.RealmRecyclerViewAdapter;

public class CartRealmAdapter extends RealmRecyclerViewAdapter<FavouriteDataBase, CartRealmAdapter.ViewHolder> implements RealmChangeListener {


    @Override
    public void onChange(Object o) {
        notifyDataSetChanged();
    }

    public interface OnItemClickListener{
        void onItemClickListener(int position);
    }
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(CartRealmAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public CartRealmAdapter(@Nullable OrderedRealmCollection<FavouriteDataBase> data, boolean autoUpdate) {
        super(data, autoUpdate);
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_for_cart, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FavouriteDataBase favouriteItem = getItem(position);
        Picasso.get().load(favouriteItem.getImg())
                .placeholder(R.drawable.defoult_product).into(holder.imageViewCatalog);
        holder.textViewTitle.setText(favouriteItem.getTitle());
        holder.textViewDescription.setText(favouriteItem.getDescription());
        holder.textViewPrice.setText(String.valueOf(favouriteItem.getPrice() ));
        holder.textViewOldPrice.setText(String.valueOf(favouriteItem.getOldprice() ));
        holder.textViewOldPrice.setPaintFlags(holder.textViewOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.textViewSale.setText(favouriteItem.getSale() + " %");
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageViewCatalog;
        TextView textViewTitle;
        TextView textViewDescription;
        TextView textViewOldPrice;
        TextView textViewPrice;
        TextView textViewSale;
        Button btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewCatalog = itemView.findViewById(R.id.imageViewRecCartProduct);
            textViewTitle = itemView.findViewById(R.id.textViewRecCartTitle);
            textViewDescription = itemView.findViewById(R.id.textViewRecCartDescription);
            textViewOldPrice = itemView.findViewById(R.id.textViewRecCartOldPrice);
            textViewPrice = itemView.findViewById(R.id.textViewRecCartPrice);
            textViewSale = itemView.findViewById(R.id.textViewRecCartSale);
            btnDelete = itemView.findViewById(R.id.buttonRecCartDelete);
            btnDelete.setOnClickListener(v -> {
                if(onItemClickListener != null){
                    onItemClickListener.onItemClickListener(getAdapterPosition());
                }
            });

        }


    }
}
