package com.example.android.codegiste;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Verification extends AppCompatActivity {

    //Initialize the counter text view
    TextView counterTextView ;

    //Initialize the counter button
    Button resendBtn ;

    //Initialize the seconds text view
    TextView secondsTextView ;

    //Initialize the timer in mSec
    private static final int TIMER = 30000 ;

    //Variable for the change in time
    private long timeChanger = TIMER ;

    //Initialize the counter timer
    CountDownTimer countDownTimer ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_verification.xml layout file
        setContentView(R.layout.activity_verification);

        //Select the text view from layout
        counterTextView = (TextView) findViewById(R.id.counter_text_view);

        //Select the resend button from the layout
        resendBtn = (Button) findViewById(R.id.resend_button);

        //Select the seconds text view from the layout
        secondsTextView = (TextView) findViewById(R.id.seconds_text_view);

        //When resend button clicked , Start counting up
        resendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer(); //The method responsible to start the timer when the button clicked
            }
        });
    }

    /**
     * To start count
     */
    public void startTimer (){

        //Set the counter down timer
        countDownTimer = new CountDownTimer(timeChanger , 1000) { //timeChanger--> the start time ,1000--> the step
            /**
             * After clicking the button
             * @param millisUntilFinished
             */
            @Override
            public void onTick(long millisUntilFinished) {

                //Set the required text every second
                counterTextView.setText("" + millisUntilFinished/1000);
            }

            /**
             * When the counter is finish
             */
            @Override
            public void onFinish() {
                secondsTextView.setVisibility(View.INVISIBLE);
                counterTextView.setText("The code sent again");
            }
        }.start() ; // <--- to start the method
    }
}
