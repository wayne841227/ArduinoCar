package com.example.wayne.arduinocarpage;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.os.Bundle;
import com.example.wayne.arduinocarpage.R;

public class Activity_Seven extends AppCompatActivity {

    private Button Check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven);

        Button three = (Button)findViewById(R.id.button3);
        Button five = (Button)findViewById(R.id.button5);
        Check = (Button) findViewById(R.id.check);


        //更換頁面到Activity_Five
        three.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpAcivity_Three();
            }
        });
        //更換頁面到Activity_Seven
        five.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View view){
                jumpActivity_Five();
            }
        });

        //更換頁面到Enter_Seven
        Check.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpEnter_Seven();
            }
        });
    }

    public void jumpAcivity_Three(){

        Intent Jump = new Intent(Activity_Seven.this,Activity_Three.class);
        startActivity(Jump);

    }

    public void jumpActivity_Five() {

        Intent Jump = new Intent(Activity_Seven.this, Activity_Five.class);
        startActivity(Jump);
    }
    public void jumpEnter_Seven() {

        Intent Jump = new Intent(Activity_Seven.this, Enter_Seven.class);
        startActivity(Jump);
    }
}
