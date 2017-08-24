package com.example.wayne.arduinocarpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by nancy on 2017/8/18.
 */

public class KP_Three extends AppCompatActivity {

    private Button Check,Back,Five,Seven;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kp_three);

        Five = (Button)findViewById(R.id.button5);
        Seven = (Button)findViewById(R.id.button7);
        Check = (Button) findViewById(R.id.check);
        Back = (Button) findViewById(R.id.back);


        //更換頁面到KD_Five
        Five.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKP_Five();
            }
        });
        //更換頁面到KD_Seven
        Seven.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v){
                jumpKP_Seven();
            }
        });

        //更換頁面到KD_Enter_Three
        Check.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKP_Enter_Three();
            }
        });

        //更換頁面到MainActivity
        Back.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpMain();
            }
        });


    }

    public void jumpKP_Five(){

        Intent Jump = new Intent(KP_Three.this,KP_Five.class);
        startActivity(Jump);

    }

    public void jumpKP_Seven() {

        Intent Jump = new Intent(KP_Three.this, KP_Seven.class);
        startActivity(Jump);
    }

    public void jumpKP_Enter_Three() {

        Intent Jump = new Intent(KP_Three.this, KP_Enter_Three.class);
        startActivity(Jump);
    }

    public void jumpMain() {

        Intent Jump = new Intent(KP_Three.this, MainActivity.class);
        startActivity(Jump);
    }
}
