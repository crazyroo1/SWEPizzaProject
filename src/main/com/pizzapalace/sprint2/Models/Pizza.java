package com.pizzapalace.sprint2.Models;

import java.util.List;
import java.util.function.Function;

public class Pizza extends Item {
    String pizzaID;
    PizzaCrustType crustType;
    Quantity cheeseQuantity;
    Quantity sauceQuantity;
    Size size;
    List<Topping> toppings;

    public Pizza(PizzaCrustType crustType, Quantity cheeseQuantity, Quantity sauceQuantity, Size size, List<Topping> toppings) {
        super("Napoleon's Revolution", 17.99f + toppings.stream().reduce(0.0f, (subtotal, topping) -> subtotal + topping.price, Float::sum), 1);
        this.crustType = crustType;
        this.cheeseQuantity = cheeseQuantity;
        this.sauceQuantity = sauceQuantity;
        this.size = size;
        this.toppings = toppings;
    }
}

