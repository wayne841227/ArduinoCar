package com.example.wayne.arduinocarpage;

/**
 * Created by nancy on 2017/8/18.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class KD_Enter_Three extends AppCompatActivity {

    private Button Check,Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kd_enterthree);

        Check = (Button) findViewById(R.id.check);
        Back = (Button) findViewById(R.id.back);

        //更換頁面到KD_Graphic
        Check.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKD_Graphic();
            }
        });

        //更換頁面到KD_Three
        Back.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKD_Three();
            }
        });
    }
    public void jumpKD_Graphic() {

        Intent Jump = new Intent(KD_Enter_Three.this, KD_Three.class);
        startActivity(Jump);
        KD_Enter_Three.this.finish();
    }

    public void jumpKD_Three() {

        Intent Jump = new Intent(KD_Enter_Three.this, KD_Three.class);
        startActivity(Jump);
        KD_Enter_Three.this.finish();
    }
}
