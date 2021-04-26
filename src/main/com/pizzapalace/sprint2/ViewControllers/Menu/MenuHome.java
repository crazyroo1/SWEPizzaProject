package com.pizzapalace.sprint2.ViewControllers.Menu;

import com.pizzapalace.sprint2.ViewControllers.NavigationDestination;
import com.pizzapalace.sprint2.ViewControllers.ViewController;
import javafx.fxml.FXML;

public class MenuHome {
    @FXML
    public void onPizzaPress() {
        ViewController.shared.navigate(NavigationDestination.PIZZA_MENU);
    }

    @FXML
    public void onSnacksPress() {

    }

    @FXML
    public void onDrinksPress() {

    }
}
