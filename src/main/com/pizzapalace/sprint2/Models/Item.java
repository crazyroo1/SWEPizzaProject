package com.pizzapalace.sprint2.Models;

import java.util.List;

public class Item {
    String itemID;
    String name;
    float price;
    String description;
    int quantity;
    List<ItemPicture> pictures;

    public Item(String name, float price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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
