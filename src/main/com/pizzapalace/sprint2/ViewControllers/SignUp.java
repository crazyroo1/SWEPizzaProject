package com.pizzapalace.sprint2.ViewControllers;

import com.pizzapalace.sprint2.Models.Account;
import com.pizzapalace.sprint2.Models.Address;
import com.pizzapalace.sprint2.Models.Contact;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SignUp {
    @FXML public TextField firstNameTextField;
    @FXML public TextField lastNameTextField;

    @FXML public TextField phoneNumberTextField;
    @FXML public TextField emailAddressTextField;
    @FXML public TextField passwordTextField;
    @FXML public TextField confirmPasswordTextField;

    @FXML public TextField streetAddressTextField;
    @FXML public TextField cityTextField;
    @FXML public TextField stateTextField;
    @FXML public TextField zipTextField;

    @FXML
    public void onSignUpButtonPress() {
        if(
                phoneNumberTextField.getText().isEmpty() ||
                emailAddressTextField.getText().isEmpty() ||
                passwordTextField.getText().isEmpty() ||
                confirmPasswordTextField.getText().isEmpty() ||
                streetAddressTextField.getText().isEmpty() ||
                cityTextField.getText().isEmpty() ||
                stateTextField.getText().isEmpty() ||
                zipTextField.getText().isEmpty()
        ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Empty Field");
            alert.setContentText("Please enter all information.");
            alert.show();
            return;
        }

        String streetNumber = streetAddressTextField.getText().split(" ")[0];
        String streetAddress = streetAddressTextField.getText().substring(streetNumber.length());

        List<Contact> contacts = Collections.singletonList(new Contact(
                phoneNumberTextField.getText(),
                emailAddressTextField.getText(),
                Collections.singletonList(new Address(
                        phoneNumberTextField.getText(),
                        streetAddress,
                        streetNumber,
                        cityTextField.getText(),
                        stateTextField.getText(),
                        zipTextField.getText())
                ))
        );

        Account account = new Account(
                phoneNumberTextField.getText(),
                firstNameTextField.getText(),
                lastNameTextField.getText(),
                passwordTextField.getText(),
                contacts
        );

        ViewController.shared.setSignedInUser(account);
        ViewController.shared.navigate(NavigationDestination.HOME);

        saveToFile(account);
    }

    private void saveToFile(Account account) {
        try {
//            File output = new File(getClass().getResource("/Users.csv").toURI());
            PrintWriter writer = new PrintWriter((new FileOutputStream(new File(getClass().getResource("/Users.csv").toURI()), true)));
            writer.println(account.getPhoneNumber() + "," + account.getPassword() + "," + account.getFirstName() + "," + account.getLastName());
            writer.close();
        } catch(Exception e) {
            System.out.println("Can't get the file");
        }
    }
}
