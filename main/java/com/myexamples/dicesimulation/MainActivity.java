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

    public void setupSpinner(){
        Spinner diceSpinner = (Spinner) findViewById(R.id.spinner);
        Integer[] dice = new Integer[] {4,6,8,10,12,20};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, dice);
        diceSpinner.setAdapter(adapter);
    }

    public void setupPicker() {
        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.numberPicker);
        numberPicker.setMinValue(2);
        numberPicker.setMaxValue(1000);
    }

    public void sendDice(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(EXTRA_MESSAGE, getSpinnerValue());
        startActivity(intent);
    }

    public void sendNumber(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(EXTRA_MESSAGE, getPickerValue());
        startActivity(intent);
    }

    public Integer getSpinnerValue(){
        Spinner diceSpinner = (Spinner) findViewById(R.id.spinner);
        String dice = diceSpinner.getSelectedItem().toString();
        return Integer.parseInt(dice);
    }

    public Integer getPickerValue(){
        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.numberPicker);
        return numberPicker.getValue();
    }


}
