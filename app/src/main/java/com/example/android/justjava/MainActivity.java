package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int quantity = 2;
    int whipped_cream_price = 1;
    int chocolate_price = 2;

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
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        CheckBox chocalateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        EditText nameEditText = (EditText) findViewById(R.id.name_edit_text_view);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        boolean hasChocalate = chocalateCheckBox.isChecked();
        String name = nameEditText.getText().toString();
        Log.v(this.getClass().getName(), "Has whipped cream: " + hasWhippedCream);
        Log.v(this.getClass().getName(), "Has chocolate: "+ hasChocalate);
        Log.v(this.getClass().getName(), "Name: " + name);
        String priceMessage = createOrderSummary(name, price, hasWhippedCream, hasChocalate);

        /*
        Handle Maps View
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:-12.1353916,-77.0241859"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        */

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        //intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order for "+ name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
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
    private String createOrderSummary(String name, int price, boolean hasWhippedCream, boolean hasChocolate) {
        String priceMessage = "Name: "+ name;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nhas whipped cream: " + (hasWhippedCream ? "Yes" : "No");
        priceMessage += "\nhas chocolate: " + (hasChocolate ? "Yes" : "No");
        priceMessage += "\nTotal: $" + (price*quantity + (hasWhippedCream ? whipped_cream_price : 0) + (hasChocolate ? chocolate_price : 0));
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    public void increment(View view) {

        if (quantity == 100) {
            Toast.makeText(this, "You cannot have more than 100 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }
}