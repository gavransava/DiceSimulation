package com.myexamples.dicesimulation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.NumberPicker;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.myexamples.dicesimulation.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupSpinner();
        setupPicker();
    }

    // Initialisation of the Spinner View
    public void setupSpinner(){
        Spinner diceSpinner = (Spinner) findViewById(R.id.spinner);
        Integer[] dice = new Integer[] {4,6,8,10,12,20};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, dice);
        diceSpinner.setAdapter(adapter);
    }

    // Initialisation of the Picker View
    public void setupPicker() {
        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.numberPicker);
        numberPicker.setMinValue(2);
        numberPicker.setMaxValue(1000);
    }

    // Method to be called when "Roll the Dice" button clicked
    public void sendDice(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(EXTRA_MESSAGE, getSpinnerValue());
        startActivity(intent);
    }

    // Method to be called when "Generate random number" button clicked
    public void sendNumber(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(EXTRA_MESSAGE, getPickerValue());
        startActivity(intent);
    }

    // Extract current spinner value
    public Integer getSpinnerValue(){
        Spinner diceSpinner = (Spinner) findViewById(R.id.spinner);
        String dice = diceSpinner.getSelectedItem().toString();
        return Integer.parseInt(dice);
    }

    // Extract current picker value
    public Integer getPickerValue(){
        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.numberPicker);
        return numberPicker.getValue();
    }


}
