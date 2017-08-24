package com.example.wayne.arduinocarpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by nancy on 2017/8/18.
 */

public class KD_Seven extends AppCompatActivity {

    private Button Check,Back,Five,Three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kd_seven);

        Three = (Button)findViewById(R.id.button3);
        Five = (Button)findViewById(R.id.button5);
        Check = (Button) findViewById(R.id.check);
        Back = (Button) findViewById(R.id.back);


        //更換頁面到KD_Three
        Three.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v){
                jumpKD_Three();
            }
        });

        //更換頁面到KD_Five
        Five.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKD_Five();
            }
        });

        //更換頁面到KD_Enter_Seven
        Check.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKD_Enter_Three();
            }
        });

        //更換頁面到MainActivity
        Back.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpMain();
            }
        });


    }

    public void jumpKD_Three() {

        Intent Jump = new Intent(KD_Seven.this, KD_Three.class);
        startActivity(Jump);
    }

    public void jumpKD_Five(){

        Intent Jump = new Intent(KD_Seven.this,KD_Five.class);
        startActivity(Jump);

    }

    public void jumpKD_Enter_Three() {

        Intent Jump = new Intent(KD_Seven.this, KD_Enter_Seven.class);
        startActivity(Jump);
    }

    public void jumpMain() {

        Intent Jump = new Intent(KD_Seven.this, MainActivity.class);
        startActivity(Jump);
    }
}
