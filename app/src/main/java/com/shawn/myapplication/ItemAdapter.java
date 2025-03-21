package com.shawn.myapplication;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
        holder.tvItemDescription.setText(item.getDescription());
        updateQuantityText(holder, item);

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

        // Set expanded state
        boolean isExpanded = item.isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

        // Add button click listener
        holder.btnAddItem.setOnClickListener(v -> {
            item.incrementQuantity();
            updateQuantityText(holder, item);
            Toast.makeText(context,
                    "Added 1 " + item.getName() + " to inventory",
                    Toast.LENGTH_SHORT).show();
        });

        // Remove button click listener
        holder.btnRemoveItem.setOnClickListener(v -> {
            boolean removed = item.decrementQuantity();
            if (removed) {
                updateQuantityText(holder, item);
                Toast.makeText(context,
                        "Removed 1 " + item.getName() + " from inventory",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context,
                        "No " + item.getName() + " left in inventory",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateQuantityText(ItemViewHolder holder, Item item) {
        holder.tvQuantity.setText("In Stock: " + item.getQuantity());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvItemName, tvItemPrice, tvCategoryBadge, tvItemDescription, tvQuantity;
        LinearLayout expandableLayout;
        Button btnAddItem, btnRemoveItem;
        LinearLayout mainLayout;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItemName = itemView.findViewById(R.id.tvItemName);
            tvItemPrice = itemView.findViewById(R.id.tvItemPrice);
            tvCategoryBadge = itemView.findViewById(R.id.tvCategoryBadge);
            tvItemDescription = itemView.findViewById(R.id.tvItemDescription);
            tvQuantity = itemView.findViewById(R.id.tvQuantity);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);
            btnAddItem = itemView.findViewById(R.id.btnAddItem);
            btnRemoveItem = itemView.findViewById(R.id.btnRemoveItem);
            mainLayout = itemView.findViewById(R.id.mainLayout);

            // Set click listener for the card
            mainLayout.setOnClickListener(v -> {
                Item item = itemList.get(getAdapterPosition());
                item.setExpanded(!item.isExpanded());
                notifyItemChanged(getAdapterPosition());
            });
        }
    }
}