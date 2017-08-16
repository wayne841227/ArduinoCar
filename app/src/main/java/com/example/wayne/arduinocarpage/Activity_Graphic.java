package com.example.wayne.arduinocarpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Activity_Graphic extends AppCompatActivity implements View.OnClickListener {

    private Button check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        check = (Button) findViewById(R.id.check);
        check.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if (v == check)
            startActivity(new Intent(this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
        else
            startActivity(new Intent(this, Activity_Graphic.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
    }
}
