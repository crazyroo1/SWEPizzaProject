package com.pizzapalace.sprint2.Models;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Account {
    @Getter
    String phoneNumber;

    @Getter
    String firstName;

    @Getter
    String lastName;

    String username;

    @Getter
    String password;

    List<Contact> contacts;

    @Setter
    @Getter
    List<PaymentMethod> paymentMethods;

    @Getter
    List<Order> orderHistory;

    @Getter
    Cart cart = new Cart();

    public Account(String phoneNumber) {
        this.phoneNumber = phoneNumber;

        Scanner scanner;
        try {
            scanner = new Scanner(new File(getClass().getResource("/Users.csv").toURI()));
        } catch(Exception ignored) { return; }
        scanner.useDelimiter(",");

        while(scanner.hasNext()) {
            String number = scanner.next();
            if(number.equals(phoneNumber)) {
                password = scanner.next();
                firstName = scanner.next();
                lastName = scanner.next();
                break;
            }
            scanner.nextLine();
        }

        this.paymentMethods = new ArrayList<>();
        this.orderHistory = new ArrayList<>();
    }

    public Account(String phoneNumber, String firstName, String lastName, String password, List<Contact> contacts) {
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.contacts = contacts;

        this.paymentMethods = new ArrayList<>();
        this.orderHistory = new ArrayList<>();
    }

    public void addItemToCart(Item item) {
        cart.add(item);
    }

    public void removeItemFromCart(Item item) {
        cart.remove(item);
    }

    void addContactInformation(Contact contact) {

    }

    void addPaymentMethod(PaymentMethod paymentMethod) {

    }

    @Override
    public String toString() {
        return "Account{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", contacts=" + contacts +
                ", paymentMethods=" + paymentMethods +
                ", orderHistory=" + orderHistory +
                ", cart=" + cart +
                '}';
    }
}

