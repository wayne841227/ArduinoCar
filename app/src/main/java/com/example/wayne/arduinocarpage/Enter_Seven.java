package com.example.wayne.arduinocarpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Enter_Seven extends AppCompatActivity {

    private Button Check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_seven);

        Check = (Button) findViewById(R.id.check);

        //更換頁面到Activity_Seven
        Check.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpActivity_Seven();
            }
        });
    }
    public void jumpActivity_Seven() {

        Intent Jump = new Intent(Enter_Seven.this, Activity_Seven.class);
        startActivity(Jump);
    }
}
