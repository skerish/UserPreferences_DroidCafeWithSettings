package com.example.ui_droidcafe;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


/**
 * The reason why you need the AdapterView is because you need an adapter—specifically
 * an ArrayAdapter—to assign the array to the Spinner. An adapter connects your data—in this
 * case, the array of spinner items—to the Spinner.
 */

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        RadioButton default_btn = findViewById(R.id.sameday);
        default_btn.setChecked(true);

        Spinner spinner = findViewById(R.id.label_spinner);
        if (spinner != null){
            spinner.setOnItemSelectedListener(this);
        }

        // Creates ArrayAdapter using the string array and default spinner layout.
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_choices, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears.
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner.
        if (spinner != null){
            spinner.setAdapter(arrayAdapter);
        }

    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.sameday:
                if(checked){
                    displayToast(getString(R.string.sameday));
                }
                break;
            case R.id.nextday:
                if (checked){
                    displayToast(getString(R.string.nextday));
                }
                break;
            case R.id.pickUp:
                if (checked){
                    displayToast(getString(R.string.pickup));
                }
                break;
        }
    }

    public void displayToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * The <?> is a Java type wildcard, enabling the method to be flexible enough to accept
     * any type of AdapterView as an argument.
     */

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        // To retrieve the user's selected item in the Spinner, use getItemAtPosition().
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        displayToast(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

}
