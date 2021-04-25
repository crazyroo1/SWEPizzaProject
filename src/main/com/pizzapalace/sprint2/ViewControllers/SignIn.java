package com.pizzapalace.sprint2.ViewControllers;

import com.pizzapalace.sprint2.Models.Account;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SignIn {
    @FXML public TextField phoneNumberTextField;
    @FXML public TextField passwordTextField;

    public ViewController viewController;

    @FXML public void forgotPasswordPressed() {
    }

    @FXML public void logInPressed() {
        if(phoneNumberTextField.getText().isEmpty() || passwordTextField.getText().isEmpty()) { return; }

        Account account = logIn(phoneNumberTextField.getText(), passwordTextField.getText());
        if(account == null) {
            //todo: present error to user
        } else {
            phoneNumberTextField.clear();
            passwordTextField.clear();
            viewController.navigate(NavigationDestination.HOME);
        }
        viewController.setSignedInUser(account);
    }

    @FXML public void signUpPressed() {
    }

    private Account logIn(String phoneNumber, String password) {
        //string enteredUser,enteredPassword //retrieve from the text fields and place in here
        Account account = null;

        Scanner scanner;
        try {
            scanner = new Scanner(new File(getClass().getResource("/Users.csv").toURI()));
        } catch(Exception ignored) {
            return null;
        }
        scanner.useDelimiter(",");

        while(scanner.hasNext()) {
            String number = scanner.next();
            String pass = scanner.next();
            if(number.equals(phoneNumber) && pass.equals(password)) {
                account = new Account(phoneNumber);
                break;
            }
            scanner.nextLine();
        }
        if(account == null) {
            System.out.println("Login Not Found");
        }
        return account;
    }
}
