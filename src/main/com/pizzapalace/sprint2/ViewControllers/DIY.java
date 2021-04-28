package com.pizzapalace.sprint2.ViewControllers;

import com.pizzapalace.sprint2.Models.*;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class DIY {

    @FXML
    private ChoiceBox<String> sizeDropDown;

    @FXML
    private ChoiceBox<String> crustDropDown;

    @FXML
    private ChoiceBox<String> cheeseDropDown;

    @FXML
    private ChoiceBox<String> sauceDropDown;

    @FXML
    private CheckBox pepperoniCheckBox;

    @FXML
    private CheckBox sausageCheckBox;

    @FXML
    private CheckBox hamCheckBox;

    @FXML
    private CheckBox baconCheckBox;

    @FXML
    private CheckBox pineappleCheckBox;

    @FXML
    private CheckBox greenPepperCheckBox;

    @FXML
    private CheckBox mushroomCheckBox;

    @FXML
    private CheckBox jalapenosCheckBox;

    @FXML
    void onNextPress(MouseEvent event) {
        Size size = Size.valueOf(sizeDropDown.getSelectionModel().getSelectedItem().toUpperCase());
        PizzaCrustType crustType = PizzaCrustType.valueOf(crustDropDown.getSelectionModel().getSelectedItem().toUpperCase().replace(' ', '_'));
        Quantity cheese = Quantity.valueOf(cheeseDropDown.getSelectionModel().getSelectedItem().toUpperCase());
        Quantity sauce = Quantity.valueOf(sauceDropDown.getSelectionModel().getSelectedItem().toUpperCase());

        ArrayList<Topping> toppings = new ArrayList<>();
        if(pepperoniCheckBox.isSelected()) toppings.add(new Topping("Pepperoni"));
        if(sausageCheckBox.isSelected()) toppings.add(new Topping("Sausage"));
        if(hamCheckBox.isSelected()) toppings.add(new Topping("Ham"));
        if(baconCheckBox.isSelected()) toppings.add(new Topping("Bacon"));
        if(pineappleCheckBox.isSelected()) toppings.add(new Topping("Pineapple"));
        if(greenPepperCheckBox.isSelected()) toppings.add(new Topping("Green Peppers"));
        if(mushroomCheckBox.isSelected()) toppings.add(new Topping("Mushrooms"));
        if(jalapenosCheckBox.isSelected()) toppings.add(new Topping("Jalapenos"));

        Pizza pizza = new Pizza(crustType, cheese, sauce, size, toppings);

        ViewController.signedInUser.addItemToCart(pizza);
        ViewController.shared.navigate(NavigationDestination.HOME);
    }

    @FXML
    public void initialize() {
        sizeDropDown.getItems().addAll("Small", "Medium", "Large", "Emperor");
        sizeDropDown.setValue("Medium");

        crustDropDown.getItems().addAll("Thin", "Hand Tossed", "Normal", "Garlic", "Stuffed");
        crustDropDown.setValue("Normal");

        cheeseDropDown.getItems().addAll("Light", "Normal", "Extra");
        cheeseDropDown.setValue("Normal");

        sauceDropDown.getItems().addAll("Light", "Normal", "Extra");
        sauceDropDown.setValue("Normal");
    }
}
