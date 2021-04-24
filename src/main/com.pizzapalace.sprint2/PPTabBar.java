package com.pizzapalace.sprint2;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class PPTabBar {
    public ViewController parent;

    @FXML public ImageView logo;

    public void onHomeButtonPressed() {
        parent.navigate(NavigationDestination.HOME);
    }

    public void onAboutUsPressed() {
        parent.navigate(NavigationDestination.ABOUT_US);
    }

    public void onMenuPressed() {
        parent.navigate(NavigationDestination.MENU);
    }

    public void onDIYPressed() {
        parent.navigate(NavigationDestination.DIY);
    }

    public void onSpecialsPressed() {
        parent.navigate(NavigationDestination.SPECIALS);
    }

    public void onCartPressed() {
        parent.navigate(NavigationDestination.CART);
    }

    public void onLogInPressed() {
        // TODO: Handle sign in versus navigating to account page
    }
}