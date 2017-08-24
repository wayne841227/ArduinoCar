package com.example.wayne.arduinocarpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by nancy on 2017/8/18.
 */

public class KP_Seven extends AppCompatActivity {

    private Button Check,Back,Five,Three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kp_seven);

        Three = (Button)findViewById(R.id.button3);
        Five = (Button)findViewById(R.id.button5);
        Check = (Button) findViewById(R.id.check);
        Back = (Button) findViewById(R.id.back);


        //更換頁面到KP_Three
        Three.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v){
                jumpKP_Three();
            }
        });

        //更換頁面到KP_Five
        Five.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKP_Five();
            }
        });

        //更換頁面到KP_Enter_Seven
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

    public void jumpKP_Three() {

        Intent Jump = new Intent(KP_Seven.this, KP_Three.class);
        startActivity(Jump);
    }

    public void jumpKP_Five(){

        Intent Jump = new Intent(KP_Seven.this,KP_Five.class);
        startActivity(Jump);

    }

    public void jumpKP_Enter_Three() {

        Intent Jump = new Intent(KP_Seven.this, KP_Enter_Seven.class);
        startActivity(Jump);
    }

    public void jumpMain() {

        Intent Jump = new Intent(KP_Seven.this, MainActivity.class);
        startActivity(Jump);
    }
}
