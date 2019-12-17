package com.byfrunze.sitostore.ui.catalog;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.byfrunze.sitostore.R;
import com.byfrunze.sitostore.sitoStoreElementsOfProducts.MyProduct;
import com.byfrunze.sitostore.sitoStoreElementsOfProducts.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CatalogProductAdapter extends RecyclerView.Adapter<CatalogProductAdapter.CustomViewHolder> {
    private List<Product> productList;

    public CatalogProductAdapter(List<Product> productList) {
        this.productList = productList;
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
        holder.textViewSale.setText(price);

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
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
        }
    }
}
