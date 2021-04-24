package com.pizzapalace.sprint2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ViewController {
    @FXML public BorderPane content;

    @FXML public PPTabBar tabbarController;

    @FXML public void initialize() {
        tabbarController.parent = this;
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
            }
        } catch(Exception ignored) { }
        return null;
    }
}

enum NavigationDestination {
    HOME,
    ABOUT_US,
    MENU,
    DIY,
    SPECIALS,
    CART,
    LOG_IN,
    ACCOUNT
}
