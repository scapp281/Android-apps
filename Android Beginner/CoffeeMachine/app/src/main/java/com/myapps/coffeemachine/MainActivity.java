package com.myapps.coffeemachine;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private int numberOfCoffees = 99;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whippedCreamCkbox);
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolateCkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        boolean wantChocolate = chocolate.isChecked();
        EditText customerName = (EditText) findViewById(R.id.name);
        name = customerName.getText().toString();

        //displayMessage(createOrderSummary(calculatePrice(hasWhippedCream, wantChocolate), hasWhippedCream, wantChocolate, name));
        String message = createOrderSummary(calculatePrice(hasWhippedCream, wantChocolate), hasWhippedCream, wantChocolate, name);
        composeEmail(message);
    }

    public int calculatePrice(boolean addWhippedCream, boolean wantChocolate) {
        int basePrice = 5;

        if (addWhippedCream) {
            basePrice += 1;
        }
        if (wantChocolate) {
            basePrice += 2;
        }
        return numberOfCoffees * basePrice;

    }

    public void composeEmail(String message) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
//        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Hello, this is your orders");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /*
    * Create a string and display */
    private String createOrderSummary(int price, boolean addWhippedCream, boolean wantChocolate, String name) {
        String priceMessage = "Name: " + name;
        priceMessage += "\nYou add cream? " + addWhippedCream;
        priceMessage += "\nYou add chocolate? " + wantChocolate;
        priceMessage += "\nQuantity: " + numberOfCoffees;
        priceMessage += "\nTotal: " + NumberFormat.getCurrencyInstance().format(price);
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    /*
    * Called when plus button click
    */
    public void increment(View view) {
        if (numberOfCoffees == 100) {
            Toast.makeText(this, "You can not make more than 100 cups of coffee", Toast.LENGTH_SHORT).show();
            return;
        } else {
            displayQuantity(numberOfCoffees += 1);
        }
    }

    /*
    * Called when minus button click
    */
    public void decrement(View view) {
        if (numberOfCoffees == 1) {
            Toast.makeText(this, "You can not make less than 1 cups of coffee", Toast.LENGTH_SHORT).show();
            return;
        } else {
            displayQuantity(numberOfCoffees -= 1);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

        /**
     * This method displays the given text on the screen.
     */
//    private void displayMessage(String message) {
//        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
//        orderSummaryTextView.setText(message);
//    }
}