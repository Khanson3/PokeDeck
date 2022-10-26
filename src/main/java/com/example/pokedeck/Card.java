package com.example.pokedeck;

import java.util.List;

public class Card {
    private String name = "";
    private double price = 0;
    private String set = "";
    private int quantity = 0;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getSet() {
        return set;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String s) {
        name = s;
    }

    public void setPrice(double d) {
        price = d;
    }

    public void setSet(String s) {
        set = s;
    }

    public void setQuantity(int i) {
        quantity = i;
    }

    public void incrementQuantity() {
        quantity++;
    }

    public void decrementQuantity() {
        if(quantity != 0) {
            quantity--;
        }
    }
}
