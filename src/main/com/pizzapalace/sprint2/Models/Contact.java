package com.pizzapalace.sprint2.Models;

import java.util.List;
import java.util.UUID;

public class Contact {
    private String phoneNumber;
    private UUID contactID;
    private String email;
    private ContactPreferredContactMethod preferredContactMethod;
    private List<Address> addresses;
}

enum ContactPreferredContactMethod {
    EMAIL,
    PHONE_NUMBER,
}
