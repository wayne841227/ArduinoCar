package com.example.wayne.arduinocarpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class KD_Enter_Five extends AppCompatActivity {

    private Button Check,Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kd_enterfive);

        Check = (Button) findViewById(R.id.check);
        Back = (Button) findViewById(R.id.back);

        //更換頁面到KD_Graphic
        Check.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKD_Graphic();
            }
        });

        //更換頁面到KD_Five
        Back.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKD_Five();
            }
        });
    }
    public void jumpKD_Graphic() {

        Intent Jump = new Intent(KD_Enter_Five.this, KD_Five.class);
        startActivity(Jump);
    }

    public void jumpKD_Five() {

        Intent Jump = new Intent(KD_Enter_Five.this, KD_Five.class);
        startActivity(Jump);
    }
}
