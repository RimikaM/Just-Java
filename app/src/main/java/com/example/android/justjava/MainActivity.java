package com.example.android.justjava;

import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.CheckBox;
import android.text.Editable;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    /* app displays an order form to order coffee */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /* method called when plus button is clicked */
    public void increment (View view) {
        if (quantity == 100) {
            return;
        }
        quantity += 1;
        displayQuantity(quantity);
    }

    /* method called when minus button is clicked */
    public void decrement (View view) {
        if (quantity == 0) {
            return;
        }
        quantity -= 1;
        displayQuantity(quantity);
    }

    /* method called when order button is clicked */
    public void submitOrder(View view) {
        // Get user's name
        EditText nameField = (EditText) findViewById(R.id.name_field);
        Editable nameEditable = nameField.getText();
        String name = nameEditable.toString();

        // Figure out if the user wants whipped cream topping
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        // Figure out if the user wants choclate topping
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        // Calculate the price
        int price = calculatePrice(hasWhippedCream, hasChocolate);

        // Display the order summary on the screen
        String message = createOrderSummary(name, price, hasWhippedCream, hasChocolate);
        displayOrder(message);
    }

    /* method calculates the price of the order */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        // calculate the price of one cup of coffee
        int basePrice = 5;

        // add $1 to base price per cup
        if (addWhippedCream) {
            basePrice += 1;
        }

        // add $2 to base price per cup
        if (addChocolate) {
            basePrice += 2;
        }

        return quantity * basePrice;
    }

    /* method puts together the user's order on the coffee */
    private String createOrderSummary(String name, int price, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = getString(R.string.order_summary_name, name);
        priceMessage += "\n" + getString(R.string.order_summary_whipped_cream, addWhippedCream);
        priceMessage += "\n" + getString(R.string.order_summary_chocolate, addChocolate);
        priceMessage += "\n" + getString(R.string.order_summary_quantity, quantity);
        priceMessage += "\n" + getString(R.string.order_summary_price,
                NumberFormat.getCurrencyInstance().format(price));
        priceMessage += "\n" + getString(R.string.thank_you);
        return priceMessage;
    }

    /* method displays the user's order */
    private void displayOrder(String message) {
        TextView orderTextView = (TextView)
                findViewById(R.id.order_text_view);
        orderTextView.setText(message);
    }

    /* method displays the given quantity values */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView)
                findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

}
