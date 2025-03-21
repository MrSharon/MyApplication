package com.shawn.myapplication;

public class Item {
    private String name;
    private double price;
    private String category;
    private String description;
    private int quantity;
    private boolean expanded;

    public Item(String name, double price, String category, String description, int quantity) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.quantity = quantity;
        this.expanded = false;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public void incrementQuantity() {
        this.quantity++;
    }

    public boolean decrementQuantity() {
        if (this.quantity > 0) {
            this.quantity--;
            return true;
        }
        return false;
    }
}
