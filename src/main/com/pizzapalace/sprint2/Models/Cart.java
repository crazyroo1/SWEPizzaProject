package com.pizzapalace.sprint2.Models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Item> cart = new ArrayList<>();

    Order placeOrder() {
        return new Order();
    }

    void add(Item item) {
        cart.add(item);
    }
    void remove(Item item) {
        cart.remove(item);
    }

    float subtotal() {
        float price = 0.0f;
        for(Item item : cart) {
            price += item.price;
        }
        return price;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cart{");
        for(Item item : cart) {
            stringBuilder.append(item.toString());
            stringBuilder.append(", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
