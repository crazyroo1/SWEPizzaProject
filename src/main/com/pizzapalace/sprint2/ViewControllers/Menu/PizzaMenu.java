package com.pizzapalace.sprint2.ViewControllers.Menu;

import com.pizzapalace.sprint2.ViewControllers.NavigationDestination;
import com.pizzapalace.sprint2.ViewControllers.ViewController;
import javafx.fxml.FXML;

public class PizzaMenu {
    @FXML
    public void pizza0Tapped() {

    }

    @FXML
    public void pizza1Tapped() {

    }

    @FXML
    public void pizza2Tapped() {

    }

    @FXML
    public void diyPizzaTapped() {
        ViewController.shared.navigate(NavigationDestination.DIY);
    }
}
