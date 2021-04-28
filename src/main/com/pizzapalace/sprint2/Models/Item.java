package com.pizzapalace.sprint2.Models;

import lombok.Getter;

import java.util.List;

public class Item {
    String itemID;

    @Getter
    String name;

    @Getter
    float price;

    String description;

    @Getter
    int quantity;

    List<ItemPicture> pictures;

    public Item(String name, float price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getDescription() {
        StringBuilder stringBuilder = new StringBuilder();
        if(this instanceof Pizza) {
            Pizza pizza = (Pizza) this;
            stringBuilder.append("Size: ").append(pizza.size).append("\n");
            stringBuilder.append("Cheese: ").append(pizza.cheeseQuantity).append("\n");
            stringBuilder.append("Sauce: ").append(pizza.sauceQuantity).append("\n");
            stringBuilder.append("Pepperoni: ").append(pizza.toppings.get(0).quantity).append("\n");
            stringBuilder.append("Crust: ").append(pizza.crustType).append("\n");
        }

        if(this instanceof Drink) {
            Drink drink = (Drink) this;
            stringBuilder.append("Size: ").append(drink.size).append("\n");
        }

        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemID='" + itemID + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", pictures=" + pictures +
                '}';
    }
}
