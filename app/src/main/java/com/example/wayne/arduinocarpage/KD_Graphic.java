package com.example.wayne.arduinocarpage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by nancy on 2017/8/18.
 */

public class KD_Graphic extends AppCompatActivity {
    private Button KP,KD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        KP = (Button) findViewById(R.id.kp);
        KD = (Button) findViewById(R.id.kd);

        //更換頁面到Enter_Three
        KP.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {

                jumpKD_Five();

            }
        });

        //更換頁面到Enter_Three
        KD.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {

                jumpKP_Five();

            }
        });
    }
    public void jumpKD_Five(){

        Intent Jump = new Intent(KD_Graphic.this,KD_Five.class);
        startActivity(Jump);

    }

    public void jumpKP_Five(){

        Intent Jump = new Intent(KD_Graphic.this,KP_Five.class);
        startActivity(Jump);

    }


}
