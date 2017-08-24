package com.example.android.justjava;

import android.icu.text.NumberFormat;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /* app displays an order form to order coffee */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* method called when order button is clicked */
    public void submitOrder(View view) {
        int numberOfCoffees = 2;
        display(numberOfCoffees);
        displayPrice(numberOfCoffees*5);
    }

    public void increment (View view) {
        int quantity = 3;
        display(quantity);
        displayPrice(quantity);
    }

    public void decrement (View view) {
        int quantity = 1;
        display(quantity);
        displayPrice(quantity);
    }

    /* method displays the given quantity values */
    private void display(int number) {
        TextView quantityTextView = (TextView)
                findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /* method displays given price */
    private void displayPrice(int number){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
        }
    }
}
