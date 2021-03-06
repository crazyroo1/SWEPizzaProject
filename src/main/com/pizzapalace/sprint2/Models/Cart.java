package com.pizzapalace.sprint2.Models;

import com.pizzapalace.sprint2.ViewControllers.ViewController;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Item> cart = new ArrayList<>();

    public Order placeOrder(PaymentMethod paymentMethod) {
        Order order = new Order(subtotal(), new ArrayList<>(cart), paymentMethod);
        ViewController.signedInUser.orderHistory.add(order);
        System.out.println(ViewController.signedInUser.orderHistory.size());
        cart.clear();
        return order;
    }

    void add(Item item) {
        cart.add(item);
    }
    void remove(Item item) {
        cart.remove(item);
    }

    public float subtotal() {
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

    public List<Item> getItems() {
        return cart;
    }
}
