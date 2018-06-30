package com.example.android.codegiste;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class PhoneAuth extends AppCompatActivity {

    //Initialize the spinner
    Spinner countrySpinner ;

    //Initialize the array adapter
    ArrayAdapter<CharSequence> adapter ;

    //Initialize the button
    Button verityBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_phone_auth.xml layout file
        setContentView(R.layout.activity_phone_auth);

        //Setup the required spinner
        countrySpinner = (Spinner) findViewById(R.id.countrySpinner);

        //Setup the array adapter to select the required string array
        adapter = ArrayAdapter.createFromResource(this , R.array.countries , android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Set the adapter in the spinner
        countrySpinner.setAdapter(adapter);

        //--------------------------------------------------------------------------------------------------
        //Setup the required button
        verityBtn = (Button) findViewById(R.id.verityButton);

        //Move to the next activity if the button is clicked
        verityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Choose the required activity to move
                Intent intent = new Intent(PhoneAuth.this , Verification.class);
                startActivity(intent);
            }
        });
    }
}
