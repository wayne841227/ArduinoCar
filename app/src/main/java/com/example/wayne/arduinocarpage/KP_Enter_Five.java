package com.example.wayne.arduinocarpage;

/**
 * Created by nancy on 2017/8/18.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class KP_Enter_Five extends AppCompatActivity {

    private Button Check,Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kp_enterfive);

        Check = (Button) findViewById(R.id.check);
        Back = (Button) findViewById(R.id.back);

        //更換頁面到KP_Graphic
        Check.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKP_Graphic();
            }
        });

        //更換頁面到KP_Five
        Back.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKP_Five();
            }
        });
    }
    public void jumpKP_Graphic() {

        Intent Jump = new Intent(KP_Enter_Five.this, KP_Three.class);
        startActivity(Jump);
    }

    public void jumpKP_Five() {

        Intent Jump = new Intent(KP_Enter_Five.this, KP_Five.class);
        startActivity(Jump);
    }
}

