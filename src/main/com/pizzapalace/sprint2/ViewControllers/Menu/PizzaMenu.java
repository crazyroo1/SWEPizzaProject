package com.pizzapalace.sprint2.ViewControllers.Menu;

import com.pizzapalace.sprint2.ViewControllers.NavigationDestination;
import com.pizzapalace.sprint2.ViewControllers.ViewController;
import javafx.fxml.FXML;

public class PizzaMenu {
    @FXML
    public void pizza0Tapped() {
        ViewController.shared.navigate(NavigationDestination.PIZZA_DETAIL);
    }

    @FXML
    public void pizza1Tapped() {
        ViewController.shared.navigate(NavigationDestination.PIZZA_DETAIL);
    }

    @FXML
    public void pizza2Tapped() {
        ViewController.shared.navigate(NavigationDestination.PIZZA_DETAIL);
    }

    @FXML
    public void diyPizzaTapped() {
        ViewController.shared.navigate(NavigationDestination.DIY);
    }
}
