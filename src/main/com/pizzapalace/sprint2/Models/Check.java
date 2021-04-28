package com.pizzapalace.sprint2.Models;

import lombok.Getter;
import lombok.Setter;

public class Check extends PaymentType {
    @Getter @Setter
    private String bankNumber;
    @Getter @Setter
    private String checkNumber;
    @Getter @Setter
    private String routingNumber;

    public Check(String bankNumber, String checkNumber, String routingNumber) {
        this.bankNumber = bankNumber;
        this.checkNumber = checkNumber;
        this.routingNumber = routingNumber;
    }

    public Check() {
    }
}
