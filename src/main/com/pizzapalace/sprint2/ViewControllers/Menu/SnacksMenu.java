package com.pizzapalace.sprint2.ViewControllers.Menu;

import com.pizzapalace.sprint2.ViewControllers.NavigationDestination;
import com.pizzapalace.sprint2.ViewControllers.ViewController;
import javafx.fxml.FXML;

public class SnacksMenu {
    @FXML
    public void snack0Tapped() {
        ViewController.shared.navigate(NavigationDestination.SNACKS_DETAIL);
    }

    @FXML
    public void snack1Tapped() {
        ViewController.shared.navigate(NavigationDestination.SNACKS_DETAIL);
    }
}
