package com.pizzapalace.sprint2.ViewControllers.Menu;

import com.pizzapalace.sprint2.Models.*;
import com.pizzapalace.sprint2.ViewControllers.NavigationDestination;
import com.pizzapalace.sprint2.ViewControllers.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.util.Collections;

public class PizzaDetail {
    @FXML public ToggleGroup size;
    @FXML public ToggleGroup cheese;
    @FXML public ToggleGroup sauce;
    @FXML public ToggleGroup pepperoni;
    @FXML public ToggleGroup crust;

    @FXML
    public void onAddToCartPress() {
        if(ViewController.signedInUser == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Not signed in");
            alert.setContentText("Please sign in to order a pizza.");
            alert.show();
            return;
        }
        RadioButton crust = (RadioButton) this.crust.getSelectedToggle();
        RadioButton cheese = (RadioButton) this.cheese.getSelectedToggle();
        RadioButton sauce = (RadioButton) this.sauce.getSelectedToggle();
        RadioButton size = (RadioButton) this.size.getSelectedToggle();
        RadioButton pepperoni = (RadioButton) this.pepperoni.getSelectedToggle();

        System.out.println(crust.getText().toUpperCase());
        System.out.println(PizzaCrustType.NORMAL.toString());

        Pizza pizza = new Pizza(PizzaCrustType.valueOf(crust.getText().toUpperCase()),
                Quantity.valueOf(cheese.getText().toUpperCase()),
                Quantity.valueOf(sauce.getText().toUpperCase()),
                Size.valueOf(size.getText().toUpperCase()),
                Collections.singletonList(new Topping("Pepperoni", Quantity.valueOf(pepperoni.getText().toUpperCase()), 0)));
        ViewController.signedInUser.addItemToCart(pizza);

        System.out.println(ViewController.signedInUser);

        ViewController.shared.navigate(NavigationDestination.HOME);
    }
}
