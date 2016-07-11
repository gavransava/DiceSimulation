package com.myexamples.dicesimulation;

import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Random;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Display processed value sent from main activity
        TextView resultText = (TextView) findViewById(R.id.textView3);
        resultText.setText(getResultValue());
    }

    // Process value sent from main activity
    public String getResultValue() {
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        Integer maxValue = extras.getInt(MainActivity.EXTRA_MESSAGE);
        return generateRandomNumber(maxValue).toString();
    }

    // Random integer number generator (range: 1-max)
    public Integer generateRandomNumber(Integer max) {
        Random gen = new Random();
        return gen.nextInt(max) + 1;
    }

    // Method to be called when "Back" button clicked
    public void BackToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
