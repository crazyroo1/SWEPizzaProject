package com.pizzapalace.sprint2.Models;

public class Topping {
    String pizzaID;
    String toppingID;
    String name;
    Quantity quantity;
    float price;

    public Topping(String name, Quantity quantity, float price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
