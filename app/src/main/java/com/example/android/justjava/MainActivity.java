package com.example.android.justjava;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    /**
    THis app displays an order form to order coffee
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * THis method is called when the order button is clicked
     */
    public void submitOrder(View view) {
        int price = quantity*5;
        //displayPrice(quantity*5);
        //String priceMessage = "The Price is $" + String.valueOf(quantity*5);
        String priceMessage = price + " dollars for " + quantity + " cups of coffee. Pay up.";
        priceMessage += " \nThank you!";
        displayMessage(priceMessage);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    /**
     * This method displays the given quantity value of the screen
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view) {
        quantity = quantity - 1;
        if (quantity < 0) {
            quantity = 0;
        }

        display(quantity);
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }


}