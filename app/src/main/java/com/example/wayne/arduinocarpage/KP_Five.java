package com.example.wayne.arduinocarpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class KP_Five extends AppCompatActivity {

    private Button Check,Back,Three,Seven;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kp_five);

        Three = (Button)findViewById(R.id.button3);
        Seven = (Button)findViewById(R.id.button7);
        Check = (Button) findViewById(R.id.check);
        Back = (Button) findViewById(R.id.back);


        //更換頁面到KP_Three
        Three.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKP_Three();
            }
        });
        //更換頁面到KP_Seven
        Seven.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v){
                jumpKP_Seven();
            }
        });

        //更換頁面到KP_Enter_Five
        Check.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKP_Enter_Five();
            }
        });

        //更換頁面到MainActivity
        Back.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpMain();
            }
        });


    }

    public void jumpKP_Three(){

        Intent Jump = new Intent(KP_Five.this,KP_Three.class);
        startActivity(Jump);

    }

    public void jumpKP_Seven() {

        Intent Jump = new Intent(KP_Five.this, KP_Seven.class);
        startActivity(Jump);
    }

    public void jumpKP_Enter_Five() {

        Intent Jump = new Intent(KP_Five.this, KP_Enter_Five.class);
        startActivity(Jump);
    }

    public void jumpMain() {

        Intent Jump = new Intent(KP_Five.this, MainActivity.class);
        startActivity(Jump);
    }
}
