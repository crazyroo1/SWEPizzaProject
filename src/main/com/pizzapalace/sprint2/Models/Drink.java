package com.pizzapalace.sprint2.Models;

public class Drink extends Item {
    String drinkID;
    Size size;

    public Drink(String name, float price, int quantity, Size size) {
        super(name, price, quantity);
        this.size = size;
    }
}
