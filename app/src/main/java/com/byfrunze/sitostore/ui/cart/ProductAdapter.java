package com.byfrunze.sitostore.ui.cart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.byfrunze.sitostore.R;
import com.byfrunze.sitostore.sitoStoreElementsOfProducts.MyProduct;
import com.squareup.picasso.*;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private ArrayList<MyProduct> products;

    public ProductAdapter(ArrayList<MyProduct> products) {
        this.products = products;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{

        ImageView imageViewProduct;
        TextView textViewTitle;
        TextView textViewBrand;
        TextView textViewDescription;
        TextView textViewColor;
        TextView textViewSize;
        TextView textViewPrice;
        TextView textViewOldPrice;
        TextView textViewSale;
        Button buttonDelete;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewProduct = itemView.findViewById(R.id.imageViewRecCartProduct);
            textViewTitle = itemView.findViewById(R.id.textViewRecCartTitle);
            textViewBrand = itemView.findViewById(R.id.textViewRecCartBrand);
            textViewDescription= itemView.findViewById(R.id.textViewRecCartDescription);
            textViewColor = itemView.findViewById(R.id.textViewRecCartColor);
            textViewSize = itemView.findViewById(R.id.textViewRecCartSize);
            textViewPrice = itemView.findViewById(R.id.textViewRecCartPrice);
            textViewOldPrice = itemView.findViewById(R.id.textViewRecCartOldPrice);
            textViewSale = itemView.findViewById(R.id.textViewRecCartSale);
            buttonDelete = itemView.findViewById(R.id.buttonRecCartDelete);

        }

    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_for_cart, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Picasso.get().load(products.get(position).getImage())
                .placeholder(R.drawable.defoult_product).into(holder.imageViewProduct);
        holder.textViewTitle.setText(products.get(position).getTitle());
        holder.textViewBrand.setText(products.get(position).getBrand());
        holder.textViewDescription.setText(products.get(position).getDescription());
        holder.textViewColor.setText(products.get(position).getColor());
        holder.textViewSize.setText(products.get(position).getSize());
        holder.textViewPrice.setText(products.get(position).getPrice());
        holder.textViewOldPrice.setText(products.get(position).getOldPrice());
        holder.textViewSale.setText(products.get(position).getSale());

    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
