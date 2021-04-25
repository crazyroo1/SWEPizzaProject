package com.pizzapalace.sprint2.Models;

import java.util.Date;
import java.util.List;

public class Order {
    String phoneNumber;
    Date orderDate;
    float amountPaid;
    String orderDescription;
    List<Item> items;
    PaymentMethod paymentMethod;
    Receipt receipt;
}
