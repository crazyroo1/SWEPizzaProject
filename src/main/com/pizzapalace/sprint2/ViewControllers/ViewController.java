package com.pizzapalace.sprint2.ViewControllers;

import com.pizzapalace.sprint2.Models.Account;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class ViewController {
    public static ViewController shared;
    public static Account signedInUser = null;

    @FXML public BorderPane content;

    @FXML public PPTabBar tabbarController;

    @FXML public void initialize() {
        tabbarController.parent = this;
        shared = this;
        navigate(NavigationDestination.HOME);
    }

    public void navigate(NavigationDestination destination) {
        content.setCenter(load(destination));
    }

    private Parent load(NavigationDestination destination) {
        try {
            switch(destination) {
                case HOME:
                    return FXMLLoader.load(getClass().getResource("/Home.fxml"));
                case ABOUT_US:
                    return FXMLLoader.load(getClass().getResource("/AboutUs.fxml"));
                case LOG_IN:
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/SignIn.fxml"));
                    Parent root = loader.load();
                    SignIn controller = loader.getController();
                    controller.viewController = this;
                    return root;
                case MENU:
                    return FXMLLoader.load(getClass().getResource("/menu/Home.fxml"));
                case PIZZA_MENU:
                    return FXMLLoader.load(getClass().getResource("/menu/Pizza.fxml"));
                case SIGN_UP:
                    return FXMLLoader.load(getClass().getResource("/SignUp.fxml"));
                case PIZZA_DETAIL:
                    return FXMLLoader.load(getClass().getResource("/menu/PizzaDetail.fxml"));
                case SNACKS_MENU:
                    return FXMLLoader.load(getClass().getResource("/menu/Snacks.fxml"));
                case SNACKS_DETAIL:
                    return FXMLLoader.load(getClass().getResource("/menu/SnacksDetail.fxml"));
                case DRINKS_MENU:
                    return FXMLLoader.load(getClass().getResource("/menu/Drinks.fxml"));
                case DRINKS_DETAIL:
                    return FXMLLoader.load(getClass().getResource("/menu/DrinksDetail.fxml"));
            }
        } catch(Exception e) {
            System.out.println("Unable to load destination " + destination.toString());
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void setSignedInUser(Account account) {
        signedInUser = account;
        String firstName = account.getFirstName();
        if(firstName == null) {
            firstName = account.getPhoneNumber();
        }
        tabbarController.signInButton.setText(account == null ? "Log In" : "Welcome back, " + firstName);
    }
}

