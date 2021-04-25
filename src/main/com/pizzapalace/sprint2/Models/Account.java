package com.pizzapalace.sprint2.Models;

import java.util.List;

public class Account {
    String phoneNumber;

    String firstName;
    String lastName;

    String username;
    String password;

    List<Contact> contacts;

    List<PaymentMethod> paymentMethods;

    List<Order> orderHistory;

    Cart cart;


    static Account logIn(String username, String password) throws Exception {
        return new Account();
    }

    void addItemToCart(Item item) {
        cart.add(item);
    }

    void removeItemFromCart(Item item) {
        cart.remove(item);
    }

    Receipt placeOrder() {
        Order order = cart.placeOrder();
        orderHistory.add(order);
        return order.receipt;
    }

    void addContactInformation(Contact contact) {

    }

    void addPaymentMethod(PaymentMethod paymentMethod) {

    }
}

