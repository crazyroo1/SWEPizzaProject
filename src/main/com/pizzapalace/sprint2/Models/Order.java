package com.pizzapalace.sprint2.Models;

import lombok.Getter;

import java.util.Date;
import java.util.List;

public class Order {
    String phoneNumber;
    Date orderDate;
    @Getter
    float amountPaid;
    String orderDescription;
    @Getter
    List<Item> items;
    @Getter
    PaymentMethod paymentMethod;
    Receipt receipt;

    public Order(float amountPaid, List<Item> items, PaymentMethod paymentMethod) {
        this.amountPaid = amountPaid;
        this.items = items;
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Order{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", orderDate=" + orderDate +
                ", amountPaid=" + amountPaid +
                ", orderDescription='" + orderDescription + '\'' +
                ", items=" + getItemsStrings() +
                ", paymentMethod=" + paymentMethod +
                ", receipt=" + receipt +
                '}';
    }

    private String getItemsStrings() {
        String items = "";
        for (Item item : this.items) {
            items += item.getName();
        }
        return items;
    }
}
