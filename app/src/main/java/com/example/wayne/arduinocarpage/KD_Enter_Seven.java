package com.example.wayne.arduinocarpage;

/**
 * Created by nancy on 2017/8/18.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class KD_Enter_Seven extends AppCompatActivity {

    private Button Check,Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kd_enterseven);

        Check = (Button) findViewById(R.id.check);
        Back = (Button) findViewById(R.id.back);

        //更換頁面到KD_Graphic
        Check.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKD_Graphic();
            }
        });

        //更換頁面到KD_Seven
        Back.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKD_Seven();
            }
        });
    }
    public void jumpKD_Graphic() {

        Intent Jump = new Intent(KD_Enter_Seven.this, KD_Seven.class);
        startActivity(Jump);
        KD_Enter_Seven.this.finish();
    }

    public void jumpKD_Seven() {

        Intent Jump = new Intent(KD_Enter_Seven.this, KD_Seven.class);
        startActivity(Jump);
        KD_Enter_Seven.this.finish();
    }
}

