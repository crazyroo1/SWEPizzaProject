package com.pizzapalace.sprint2.Models;

import java.util.List;

public class Pizza extends Item {
    String pizzaID;
    PizzaCrustType crustType;
    Quantity cheeseQuantity;
    Quantity sauceQuantity;
    Size size;
    List<Topping> toppings;
}

enum PizzaCrustType {
    THIN,
    NORMAL,
    HAND_TOSSED,
    GARLIC,
    STUFFED
}

