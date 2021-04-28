package com.pizzapalace.sprint2.ViewControllers;

import com.pizzapalace.sprint2.Models.Account;
import com.pizzapalace.sprint2.Models.Item;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;

public class Cart {
    @FXML public GridPane content;

    private int currentRow = 0;

    @FXML
    public void initialize() {
        Account account = ViewController.signedInUser;
        if(account == null) { return; }

        content.setGridLinesVisible(true);
        GridPane.setMargin(content, new Insets(32));

        for(Item item : account.getCart().getItems()) {
            Label name = new Label(item.getName());
            content.add(name, 0, currentRow);
            GridPane.setHalignment(name, HPos.CENTER);

            Label description = new Label(item.getDescription());
            description.setWrapText(true);
            description.setPadding(new Insets(8));
            content.add(description, 1, currentRow);
            GridPane.setHalignment(description, HPos.CENTER);

            Label quantity = new Label(String.valueOf(item.getQuantity()));
            content.add(quantity, 2, currentRow);
            GridPane.setHalignment(quantity, HPos.CENTER);

            Label price = new Label("$" + item.getPrice());
            content.add(price, 3, currentRow);
            GridPane.setHalignment(price, HPos.CENTER);

            currentRow++;
        }

        Label totalLabel = new Label("Total");
        content.add(totalLabel, 2, currentRow);
        GridPane.setHalignment(totalLabel, HPos.CENTER);

        Label total = new Label("$" + account.getCart().subtotal());
        content.add(total, 3, currentRow);
        GridPane.setHalignment(total, HPos.CENTER);
    }
}
