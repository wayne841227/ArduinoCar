package com.example.wayne.arduinocarpage;

/**
 * Created by nancy on 2017/8/18.
 */

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class KD_Enter_Three extends AppCompatActivity {

    private Button Check,Back;
    float [] kd_3_weight = {(float)0,(float)0,(float)0};
    boolean isopen_kd3enter = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kd_enterthree);

        Check = (Button) findViewById(R.id.check);
        Back = (Button) findViewById(R.id.back);
        TextView Weight = (TextView) findViewById(R.id.weight);
        TextView Angle = (TextView) findViewById(R.id.angle);

        Weight.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/SentyTang.ttf"));
        Angle.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/SentyTang.ttf"));


        //更換頁面到KD_Graphic
        Check.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                //jumpKD_Graphic();

                EditText edt1 = (EditText) findViewById(R.id.edit1);

                if(edt1.getText() != null) {
                    kd_3_weight[0] = Float.valueOf(edt1.getText().toString());
                }
                EditText edt2 = (EditText) findViewById(R.id.edit2);

                if(edt2.getText() != null) {
                    kd_3_weight[1] = Float.valueOf(edt2.getText().toString());
                }
                EditText edt3 = (EditText) findViewById(R.id.edit3);

                if(edt3.getText() != null) {
                    kd_3_weight[2] = Float.valueOf(edt3.getText().toString());
                }


                jumpKD_Three();

            }
        });

        //更換頁面到KD_Three
        Back.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKD_Three();
            }
        });
    }


    public boolean onKeyDown(int keyCode,KeyEvent event){

        if(keyCode== KeyEvent.KEYCODE_BACK && event.getRepeatCount()==0){   //確定按下退出鍵and防止重複按下退出鍵

            dialog();

        }

        return false;

    }

    private void dialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(KD_Enter_Three.this); //創建訊息方塊

        builder.setMessage("確定要離開？");

        builder.setTitle("離開");

        builder.setPositiveButton("確認", new DialogInterface.OnClickListener()  {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss(); //dismiss為關閉dialog,Activity還會保留dialog的狀態

                KD_Enter_Three.this.finish();//關閉activity

            }

        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener()  {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();

            }

        });

        builder.create().show();

    }

    public void jumpKD_Graphic() {

        Intent Jump = new Intent(KD_Enter_Three.this, KD_Three.class);
        startActivity(Jump);
        KD_Enter_Three.this.finish();
    }

    public void jumpKD_Three() {

        Bundle bundle = new Bundle();
        bundle.putFloatArray("kd_3_weight",kd_3_weight);
        Intent Jump = new Intent(KD_Enter_Three.this, KD_Three.class);
        Jump.putExtras(bundle);
        startActivity(Jump);
        KD_Enter_Three.this.finish();

    }
}
