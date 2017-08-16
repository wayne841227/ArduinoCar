package com.example.wayne.arduinocarpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Enter_Five extends AppCompatActivity {

    private Button Check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_five);

        Check = (Button) findViewById(R.id.check);

        //更換頁面到Activity_Five
        Check.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpActivity_Five();
            }
        });
    }
    public void jumpActivity_Five() {

        Intent Jump = new Intent(Enter_Five.this, Activity_Five.class);
        startActivity(Jump);
    }
}
