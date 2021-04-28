package com.pizzapalace.sprint2.Models;

import lombok.Getter;

public class PaymentMethod {
    private String phoneNumber;
    private String paymentID;
    private String paymentName;
    private boolean isPreferredPayment;
    @Getter
    private PaymentType paymentType;

    public PaymentMethod(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
