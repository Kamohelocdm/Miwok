package com.example.ekasilabalexcdtb.miwok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find view that shows the numbers category
        TextView numbers = (TextView) findViewById(R.id.numbers);
        // Set a clicklistener on that view
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent numbersIntent = new Intent((MainActivity.this), NumbersActivity.class);
                //Start the new activity
                startActivity(numbersIntent);

            }


        });

        // Find view that shows the family category
        TextView family = (TextView) findViewById(R.id.family);
        // Set a clicklistener on that view
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new intent to open the {@link FamilyActivity}
                Intent familyIntent = new Intent((MainActivity.this), FamilyActivity.class);
                //Start the new activity
                startActivity(familyIntent);

            }


        });
        // Find view that shows the colours category
        TextView colours = (TextView) findViewById(R.id.colours);
        // Set a clicklistener on that view
        colours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new intent to open the {@link ColorsActivity}
                Intent coloursIntent = new Intent((MainActivity.this), ColorsActivity.class);
                //Start the new activity
                startActivity(coloursIntent);
                ;
            }

        });
        // Find view that shows the phrases category
        TextView phrases = (TextView) findViewById(R.id.phrases);
        // Set a clicklistener on that view
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new intent to open the {@link PhrasesActivity}
                Intent phrasesIntent = new Intent((MainActivity.this), PhrasesActivity.class);
                //Start the new activity
                startActivity(phrasesIntent);
                ;
            }
        });
    }
}