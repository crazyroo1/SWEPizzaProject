package com.pizzapalace.sprint2.ViewControllers;

import com.pizzapalace.sprint2.Models.*;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class OrderHistory {
    @FXML
    GridPane content;

    private int currentContentRow = 0;

    @FXML
    public void initialize() {
        this.content.setVgap(4);
        this.content.setGridLinesVisible(false);
        for (Order order : ViewController.signedInUser.getOrderHistory()) {
            GridPane content = new GridPane();
            int currentRow = 0;
            System.out.println(order);
            for(Item item : order.getItems()) {
                System.out.println(item.getName());
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

            PaymentType paymentType = order.getPaymentMethod().getPaymentType();

            String paymentTypeString = "";
            if(paymentType instanceof Cash) paymentTypeString = "Cash";
            if(paymentType instanceof CreditCard) paymentTypeString = "Card";
            if(paymentType instanceof Check) paymentTypeString = "Check";

            Label paymentTypeLabel = new Label(paymentTypeString);
            content.add(paymentTypeLabel, 1, currentRow);
            GridPane.setHalignment(paymentTypeLabel, HPos.CENTER);

            Label totalLabel = new Label("Total");
            content.add(totalLabel, 2, currentRow);
            GridPane.setHalignment(totalLabel, HPos.CENTER);

            Label total = new Label("$" + order.getAmountPaid());
            content.add(total, 3, currentRow);
            GridPane.setHalignment(total, HPos.CENTER);

            this.content.add(content, 0, currentContentRow);
            currentContentRow++;

            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(25);
            content.getColumnConstraints().add(columnConstraints);
            content.getColumnConstraints().add(columnConstraints);
            content.getColumnConstraints().add(columnConstraints);
            content.getColumnConstraints().add(columnConstraints);
            content.setGridLinesVisible(true);
            content.setPadding(new Insets(8));
        }
    }
}
