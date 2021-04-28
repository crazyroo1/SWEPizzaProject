package com.pizzapalace.sprint2.ViewControllers;

import com.pizzapalace.sprint2.Models.*;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.List;

import static com.pizzapalace.sprint2.ViewControllers.ViewController.signedInUser;

public class Cart {
    @FXML public GridPane content;

    private int currentRow = 0;

    @FXML
    public void initialize() {
        Account account = signedInUser;
        if(account == null) { return; }

        content.setGridLinesVisible(true);
        GridPane.setMargin(content, new Insets(32));

        for(Item item : account.getCart().getItems()) {
            Label name = new Label(item.getName());
            content.add(name, 0, currentRow);
            GridPane.setHalignment(name, HPos.CENTER);

            Label description = new Label(item.getDescription());
            description.setWrapText(true);
            description.setPadding(new Insets(8));
            content.add(description, 1, currentRow);
            GridPane.setHalignment(description, HPos.CENTER);

            Label quantity = new Label(String.valueOf(item.getQuantity()));
            content.add(quantity, 2, currentRow);
            GridPane.setHalignment(quantity, HPos.CENTER);

            Label price = new Label("$" + item.getPrice());
            content.add(price, 3, currentRow);
            GridPane.setHalignment(price, HPos.CENTER);

            currentRow++;
        }

        Label totalLabel = new Label("Total");
        content.add(totalLabel, 2, currentRow);
        GridPane.setHalignment(totalLabel, HPos.CENTER);

        Label total = new Label("$" + account.getCart().subtotal());
        content.add(total, 3, currentRow);
        GridPane.setHalignment(total, HPos.CENTER);
    }

    @FXML
    public void onPickUpPress() {
        placeOrder(false, new PaymentMethod(new Cash()));
    }

    @FXML
    public void onCashPress() {
        placeOrder(true, new PaymentMethod(new Cash()));
    }

    @FXML
    public void onCardPress() {
        List<PaymentMethod> paymentMethods = signedInUser.getPaymentMethods();

        PaymentMethod paymentMethod = null;
        for (PaymentMethod method : paymentMethods) {
            if(method.getPaymentType() instanceof CreditCard) {
                paymentMethod = method;
                break;
            }
        }

        if(paymentMethod != null) {
            placeOrder(true, paymentMethod);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("No card in account");
            alert.setContentText("Go to your account to add one.");
            alert.show();
        }
    }

    @FXML
    public void onCheckPress() {
        List<PaymentMethod> paymentMethods = signedInUser.getPaymentMethods();

        PaymentMethod paymentMethod = null;
        for (PaymentMethod method : paymentMethods) {
            if(method.getPaymentType() instanceof Check) {
                paymentMethod = method;
                break;
            }
        }

        if(paymentMethod != null) {
            placeOrder(true, paymentMethod);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("No check in account");
            alert.setContentText("Go to your account to add one.");
            alert.show();
        }
    }

    private void placeOrder(boolean delivery, PaymentMethod paymentMethod) {
        if(signedInUser == null) return;

        if(signedInUser.getCart().getItems().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Cart empty");
            alert.setContentText("Cannot check out with an empty cart. ");
            alert.show();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Order placed successfully");
        alert.setContentText("Your order has been received and will be " + (delivery ? "delivered" : "ready for pickup") + " in 25 minutes.\nYour receipt has been emailed to you.\nThank you for dining with Pizza Palace!");
        alert.show();

        ViewController.shared.navigate(NavigationDestination.HOME);

        signedInUser.getCart().placeOrder(paymentMethod);
    }
}
