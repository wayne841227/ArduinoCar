package com.example.wayne.arduinocarpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Activity_Three extends AppCompatActivity {

    private Button Check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Button five = (Button)findViewById(R.id.button5);
        Button seven = (Button)findViewById(R.id.button7);
        Check = (Button) findViewById(R.id.check);


        //更換頁面到Activity_Five
        five.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpActivity_Five();
            }
        });
        //更換頁面到Activity_Seven
        seven.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View view){
                jumpActivity_Seven();
            }
        });

        //更換頁面到Enter_Three
        Check.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpEnter_Three();
            }
        });
    }

    public void jumpActivity_Five(){

        Intent Jump = new Intent(Activity_Three.this,Activity_Five.class);
        startActivity(Jump);

    }

    public void jumpActivity_Seven() {

        Intent Jump = new Intent(Activity_Three.this, Activity_Seven.class);
        startActivity(Jump);
    }

    public void jumpEnter_Three() {

        Intent Jump = new Intent(Activity_Three.this, Enter_Three.class);
        startActivity(Jump);
    }
}
