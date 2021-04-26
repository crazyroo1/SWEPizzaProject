package com.pizzapalace.sprint2.ViewControllers.Menu;

import com.pizzapalace.sprint2.ViewControllers.NavigationDestination;
import com.pizzapalace.sprint2.ViewControllers.ViewController;
import javafx.fxml.FXML;

public class DrinksMenu {
    @FXML
    public void drink0Tapped() {
        ViewController.shared.navigate(NavigationDestination.DRINKS_DETAIL);
    }

    public void drink1Tapped() {
        ViewController.shared.navigate(NavigationDestination.DRINKS_DETAIL);
    }
}
