package com.example.wayne.arduinocarpage;

import android.os.Bundle;
import android.graphics.Typeface;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import com.example.wayne.arduinocarpage.R;
import android.content.Intent;

public class MainActivity extends Activity {

    private Button Formula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Formula = (Button) findViewById(R.id.formula);

        //更換頁面到Enter_Three
        Formula.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpActivity_Five();
            }
        });
    }
    public void jumpActivity_Five(){

        Intent Jump = new Intent(MainActivity.this,Activity_Five.class);
        startActivity(Jump);

    }
}
