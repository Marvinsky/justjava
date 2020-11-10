package com.example.android.justjava;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
        int price = 5;
        String priceMessage = createOrderSummary(price);
        displayMessage(priceMessage);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    /**
     * Create summary of the order
     * @param price of the order
     * @return Summary
     */
    private String createOrderSummary(int price) {
        String priceMessage = "Name: Kaptain Kunal";
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price*quantity;
        priceMessage += "\nThank you!";
        return priceMessage;
    }


    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        quantity = quantity - 1;
        if (quantity < 0) {
            quantity = 0;
        }

        displayQuantity(quantity);
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView)findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}