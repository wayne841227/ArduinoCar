package com.example.wayne.arduinocarpage;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.os.Bundle;
import com.example.wayne.arduinocarpage.R;

public class Activity_Five extends AppCompatActivity {

    private Button Check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);

        Button three = (Button)findViewById(R.id.button3);
        Button seven = (Button)findViewById(R.id.button7);
        Check = (Button) findViewById(R.id.check);


        //更換頁面到Activity_Five
        three.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpAcivity_Three();
            }
        });
        //更換頁面到Activity_Seven
        seven.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View view){
                jumpActivity_Seven();
            }
        });

        //更換頁面到Enter_Five
        Check.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpEnter_Five();
            }
        });


    }

    public void jumpAcivity_Three(){

        Intent Jump = new Intent(Activity_Five.this,Activity_Three.class);
        startActivity(Jump);

    }

    public void jumpActivity_Seven() {

        Intent Jump = new Intent(Activity_Five.this, Activity_Seven.class);
        startActivity(Jump);
    }

    public void jumpEnter_Five() {

        Intent Jump = new Intent(Activity_Five.this, Enter_Five.class);
        startActivity(Jump);
    }
}
