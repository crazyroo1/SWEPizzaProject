package com.pizzapalace.sprint2.ViewControllers.Menu;

import com.pizzapalace.sprint2.Models.*;
import com.pizzapalace.sprint2.ViewControllers.NavigationDestination;
import com.pizzapalace.sprint2.ViewControllers.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;

import java.util.Collections;

public class SnacksDetail {
    @FXML
    public void onAddToCartPress() {
        if(ViewController.signedInUser == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Not signed in");
            alert.setContentText("Please sign in to order a pizza.");
            alert.show();
            return;
        }

        Dessert dessert = new Dessert("Antoinette's Deadly Cake", 19.99f, 1);
        ViewController.signedInUser.addItemToCart(dessert);

        ViewController.shared.navigate(NavigationDestination.HOME);
    }
}
