package com.pizzapalace.sprint2.ViewControllers.Menu;

import com.pizzapalace.sprint2.Models.Drink;
import com.pizzapalace.sprint2.Models.Size;
import com.pizzapalace.sprint2.ViewControllers.NavigationDestination;
import com.pizzapalace.sprint2.ViewControllers.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class DrinksDetail {
    @FXML public ToggleGroup size;

    @FXML
    public void onAddToCartPress() {
        RadioButton size = (RadioButton) this.size.getSelectedToggle();

        if(ViewController.signedInUser == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Not signed in");
            alert.setContentText("Please sign in to order a pizza.");
            alert.show();
            return;
        }

        Drink drink = new Drink("Mount Olympus", 3.59f, 1, Size.valueOf(size.getText().toUpperCase()));
        ViewController.signedInUser.addItemToCart(drink);

        ViewController.shared.navigate(NavigationDestination.HOME);
    }
}
