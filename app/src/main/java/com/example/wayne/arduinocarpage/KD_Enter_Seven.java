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
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class KD_Enter_Seven extends AppCompatActivity {

    private Button Check,Back;
    float [] kd_7_weight = {(float)0,(float)0,(float)0,(float)0,(float)0,(float)0,(float)0};

    float kd_7_angle_max;
    float kd_7_angle_min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kd_enterseven);

        Check = (Button) findViewById(R.id.check);
        Back = (Button) findViewById(R.id.back);
        TextView Weight = (TextView) findViewById(R.id.weight);
        TextView Angle = (TextView) findViewById(R.id.angle);

        Weight.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/SentyTang.ttf"));
        Angle.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/SentyTang.ttf"));


        //更換頁面到KD_Graphic
        Check.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                EditText edt1 = (EditText) findViewById(R.id.edit1);
                EditText edt2 = (EditText) findViewById(R.id.edit2);
                EditText edt3 = (EditText) findViewById(R.id.edit3);
                EditText edt4 = (EditText) findViewById(R.id.edit4);
                EditText edt5 = (EditText) findViewById(R.id.edit5);
                EditText edt6 = (EditText) findViewById(R.id.edit6);
                EditText edt7 = (EditText) findViewById(R.id.edit7);

                EditText edt8 = (EditText) findViewById(R.id.edit8);
                EditText edt9 = (EditText) findViewById(R.id.edit9);

                //判斷輸入值是否為空
                if("".equals(edt1.getText().toString().trim()) || "".equals(edt2.getText().toString().trim()) ||
                        "".equals(edt3.getText().toString().trim()) || "".equals(edt4.getText().toString().trim()) ||
                        "".equals(edt5.getText().toString().trim()) || "".equals(edt6.getText().toString().trim()) ||
                        "".equals(edt7.getText().toString().trim()) || "".equals(edt8.getText().toString().trim()) ||
                        "".equals(edt9.getText().toString().trim())){

                    //產生視窗物件
                    new AlertDialog.Builder(KD_Enter_Seven.this)
                            .setTitle("警告視窗")//標題
                            .setMessage("輸入格式有誤")//顯示的文字
                            .setPositiveButton("關閉視窗",new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            }).show();//呈現對話視窗

                }else{

                    kd_7_weight[0] = Float.valueOf(edt1.getText().toString());
                    kd_7_weight[1] = Float.valueOf(edt2.getText().toString());
                    kd_7_weight[2] = Float.valueOf(edt3.getText().toString());
                    kd_7_weight[3] = Float.valueOf(edt4.getText().toString());
                    kd_7_weight[4] = Float.valueOf(edt5.getText().toString());
                    kd_7_weight[5] = Float.valueOf(edt6.getText().toString());
                    kd_7_weight[6] = Float.valueOf(edt7.getText().toString());

                    kd_7_angle_min = Float.valueOf(edt8.getText().toString());
                    kd_7_angle_max = Float.valueOf(edt9.getText().toString());

                    //存入全域變數的class
                    GlobalVariable gv = (GlobalVariable)getApplicationContext();
                    gv.setKd_7_weight(kd_7_weight);
                    gv.setKd_7_angle(kd_7_angle_min,kd_7_angle_max);

                    jumpKD_Seven();
                }
            }
        });

        //更換頁面到KD_Seven
        Back.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKD_Seven();
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

        AlertDialog.Builder builder = new AlertDialog.Builder(KD_Enter_Seven.this); //創建訊息方塊

        builder.setMessage("確定要離開？");

        builder.setTitle("離開");

        builder.setPositiveButton("確認", new DialogInterface.OnClickListener()  {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss(); //dismiss為關閉dialog,Activity還會保留dialog的狀態

                KD_Enter_Seven.this.finish();//關閉activity

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

    public void jumpKD_Seven() {

        Intent Jump = new Intent(KD_Enter_Seven.this, KD_Seven.class);
        startActivity(Jump);
        KD_Enter_Seven.this.finish();
    }
}

