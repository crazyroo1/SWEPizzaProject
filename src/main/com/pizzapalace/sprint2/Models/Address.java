package com.pizzapalace.sprint2.Models;

import java.util.UUID;

public class Address {
    private String phoneNumber;
    private UUID contactID;
    private UUID addressID;

    private String streetName;
    private String streetNumber;
    private String city;
    private String state;
    private String postalCode;

    public Address(String phoneNumber, String streetName, String streetNumber, String city, String state, String postalCode) {
        this.phoneNumber = phoneNumber;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }
}
