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
        String priceMessage = "Free";
        displayMessage(priceMessage);
    }

    /* method called when plus button is clicked */
    public void increment (View view) {
        quantity += 1;
        display(quantity);
    }

    /* method called when minus button is clicked */
    public void decrement (View view) {
        quantity -= 1;
        display(quantity);
    }

    /* method displays the given quantity values */
    private void display(int number) {
        TextView quantityTextView = (TextView)
                findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String message){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    /* method displays given price */
    private void displayPrice(int number){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
        }
    }
}
