package com.shawn.myapplication;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private List<Item> itemList;
    private Context context;

    public ItemAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = itemList.get(position);

        holder.tvItemName.setText(item.getName());
        holder.tvItemPrice.setText(String.format("$%.2f", item.getPrice()));

        // Set the category badge
        String category = item.getCategory();
        holder.tvCategoryBadge.setText(String.valueOf(category.charAt(0)));

        // Change badge color based on category
        GradientDrawable drawable = (GradientDrawable) holder.tvCategoryBadge.getBackground();
        if (category.equalsIgnoreCase("electronics")) {
            drawable.setColor(ContextCompat.getColor(context, R.color.electronicsBadge));
        } else if (category.equalsIgnoreCase("clothing")) {
            drawable.setColor(ContextCompat.getColor(context, R.color.clothingBadge));
        } else {
            drawable.setColor(ContextCompat.getColor(context, R.color.colorPrimary));
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvItemName, tvItemPrice, tvCategoryBadge;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItemName = itemView.findViewById(R.id.tvItemName);
            tvItemPrice = itemView.findViewById(R.id.tvItemPrice);
            tvCategoryBadge = itemView.findViewById(R.id.tvCategoryBadge);
        }
    }
}