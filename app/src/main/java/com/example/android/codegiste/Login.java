package com.example.android.codegiste;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    Button registerBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_login.xml layout file
        setContentView(R.layout.activity_login);

        //Get the required button
        registerBtn = (Button) findViewById(R.id.registerButton);

        //Setup the button when it clicked
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Go to the next Register Activity
                Intent intent = new Intent(Login.this , Register.class);
                startActivity(intent);
            }
        });
    }
}
