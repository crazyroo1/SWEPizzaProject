package com.pizzapalace.sprint2.ViewControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class PPTabBar {
    public ViewController parent;

    @FXML public ImageView logo;
    @FXML public Label signInButton;

    public void onHomeButtonPressed() {
        parent.navigate(NavigationDestination.HOME);
    }

    public void onAboutUsPressed() {
        parent.navigate(NavigationDestination.ABOUT_US);
    }

    public void onMenuPressed() {
        if(ViewController.signedInUser == null) {
            parent.navigate(NavigationDestination.LOG_IN);
            return;
        }
        parent.navigate(NavigationDestination.MENU);
    }

    public void onDIYPressed() {
        if(ViewController.signedInUser == null) {
            parent.navigate(NavigationDestination.LOG_IN);
            return;
        }
        parent.navigate(NavigationDestination.DIY);
    }

    public void onSpecialsPressed() {
        parent.navigate(NavigationDestination.SPECIALS);
    }

    public void onCartPressed() {
        parent.navigate(NavigationDestination.CART);
    }

    public void onLogInPressed() {
        if(ViewController.signedInUser == null) {
            parent.navigate(NavigationDestination.LOG_IN);
        } else {
            parent.navigate(NavigationDestination.ACCOUNT);
        }
    }
}
