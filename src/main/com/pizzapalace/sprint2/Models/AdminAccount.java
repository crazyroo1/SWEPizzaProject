package com.pizzapalace.sprint2.Models;

import java.util.ArrayList;
import java.util.List;

public class AdminAccount extends Account {
    public AdminAccount(String phoneNumber) {
        super(phoneNumber);
    }

    Item addItem(Item item) {
        return item;
    }

    List<Order> getOrders() {
        return new ArrayList<Order>();
    }

    void updateUser(Account current, Account newAccount) {

    }
}
