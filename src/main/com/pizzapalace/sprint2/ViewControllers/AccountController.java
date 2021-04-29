package com.pizzapalace.sprint2.ViewControllers;

import com.pizzapalace.sprint2.Models.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.Array;
import java.util.ArrayList;

public class AccountController {
    @FXML
    private TextField checkNumberTextField;

    @FXML
    private TextField bankNumberTextField;

    @FXML
    private TextField routingNumberTextField;

    @FXML
    private TextField cardholderTextField;

    @FXML
    private TextField cardNumberTextField;

    @FXML
    private TextField expirationDateTextField;

    @FXML
    private TextField cvvTextField;

    @FXML
    void onLogOutPress() {
        ViewController.shared.setSignedInUser(null);
        ViewController.shared.navigate(NavigationDestination.HOME);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Logged out");
        alert.show();
    }

    @FXML
    void onOrderHistoryPress(MouseEvent event) {
        ViewController.shared.navigate(NavigationDestination.ORDER_HISTORY);
    }

    @FXML
    void onSavePress(MouseEvent event) {
        Account account = ViewController.signedInUser;

        ArrayList<PaymentMethod> paymentMethods = new ArrayList<>();

        if(!(checkNumberTextField.getText().isEmpty() || bankNumberTextField.getText().isEmpty() || routingNumberTextField.getText().isEmpty())) {
            PaymentMethod check = new PaymentMethod(new Check(bankNumberTextField.getText(), checkNumberTextField.getText(), routingNumberTextField.getText()));
            paymentMethods.add(check);
        }

        if(!(cardholderTextField.getText().isEmpty() || cardNumberTextField.getText().isEmpty() || expirationDateTextField.getText().isEmpty() || cvvTextField.getText().isEmpty())) {
            PaymentMethod card = new PaymentMethod(new CreditCard(cardholderTextField.getText(), cvvTextField.getText(), cardNumberTextField.getText(), expirationDateTextField.getText()));
            paymentMethods.add(card);
        }

        account.setPaymentMethods(paymentMethods);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Saved successfully");
        alert.show();

        ViewController.shared.navigate(NavigationDestination.HOME);
    }

    @FXML
    public void initialize() {
        Account account = ViewController.signedInUser;

        if(account.getPaymentMethods() == null) return;

        for (PaymentMethod paymentMethod : account.getPaymentMethods()) {
            if(paymentMethod.getPaymentType() instanceof CreditCard) {
                CreditCard card = (CreditCard) paymentMethod.getPaymentType();
                cardholderTextField.setText(card.getOwnerName());
                cardNumberTextField.setText(card.getCardNumber());
                expirationDateTextField.setText(card.getExpirationDate());
                cvvTextField.setText(card.getCvv());
            }

            if(paymentMethod.getPaymentType() instanceof Check) {
                Check check = (Check) paymentMethod.getPaymentType();
                checkNumberTextField.setText(check.getCheckNumber());
                bankNumberTextField.setText(check.getBankNumber());
                routingNumberTextField.setText(check.getRoutingNumber());
            }
        }
    }
}
