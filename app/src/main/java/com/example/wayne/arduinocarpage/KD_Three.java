package com.example.wayne.arduinocarpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by nancy on 2017/8/18.
 */

public class KD_Three extends AppCompatActivity {

    private Button Check,Back,Five,Seven;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kd_three);

        Five = (Button)findViewById(R.id.button5);
        Seven = (Button)findViewById(R.id.button7);
        Check = (Button) findViewById(R.id.check);
        Back = (Button) findViewById(R.id.back);


        //更換頁面到KD_Five
        Five.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKD_Five();
            }
        });
        //更換頁面到KD_Seven
        Seven.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v){
                jumpKD_Seven();
            }
        });

        //更換頁面到KD_Enter_Three
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

    public void jumpKD_Five(){

        Intent Jump = new Intent(KD_Three.this,KD_Five.class);
        startActivity(Jump);

    }

    public void jumpKD_Seven() {

        Intent Jump = new Intent(KD_Three.this, KD_Seven.class);
        startActivity(Jump);
    }

    public void jumpKD_Enter_Three() {

        Intent Jump = new Intent(KD_Three.this, KD_Enter_Three.class);
        startActivity(Jump);
    }

    public void jumpMain() {

        Intent Jump = new Intent(KD_Three.this, MainActivity.class);
        startActivity(Jump);
    }
}
