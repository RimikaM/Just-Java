package com.example.android.justjava;

import android.icu.text.NumberFormat;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    /* app displays an order form to order coffee */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* method called when order button is clicked */
    public void submitOrder(View view) {
        int price = quantity * 5;
        String priceMessage = "Total: $" + price;
        priceMessage = priceMessage + "\nThank you!";
        calculatePrice(quantity);
    }

    /* method called when plus button is clicked */
    public void increment (View view) {
        quantity += 1;
        displayQuantity(quantity);
    }

    /* method called when minus button is clicked */
    public void decrement (View view) {
        quantity -= 1;
        displayQuantity(quantity);
    }

    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     */
    private void calculatePrice(int quantity) {
        int price = quantity * 5;
    }

    /* method displays the given quantity values */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView)
                findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

}
