package com.example.android.codegiste;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    //Initialize the register button
    Button registerBtn ;

    //Initialize the login button to move to the main screen activity
    Button loginBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_login.xml layout file
        setContentView(R.layout.activity_login);

        //Get the required button
        registerBtn = (Button) findViewById(R.id.registerButton);

        //Select the button to move to the next activity
        loginBtn = (Button) findViewById(R.id.login_button);

        //Setup the register button when it clicked
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Go to the next Register Activity
                Intent intent = new Intent(Login.this , Register.class);
                startActivity(intent);
            }
        });


        //Setup the login button to move to the next activity when the button is clicked
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this , MainScreen.class);
                startActivity(intent);
            }
        });

    }
}
