package com.pizzapalace.sprint2.Models;

import lombok.Getter;
import lombok.Setter;

public class CreditCard extends PaymentType {
    @Getter @Setter
    private String ownerName;
    @Getter @Setter
    private String cvv;
    @Getter @Setter
    private String cardNumber;
    @Getter @Setter
    private String expirationDate;

    public CreditCard(String ownerName, String cvv, String cardNumber, String expirationDate) {
        this.ownerName = ownerName;
        this.cvv = cvv;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }

    public CreditCard() {
    }
}
