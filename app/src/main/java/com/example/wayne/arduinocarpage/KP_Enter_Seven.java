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
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class KP_Enter_Seven extends AppCompatActivity implements TextWatcher {

    private Button Check,Back;
    private EditText PS , PM;
    private TextView NS , NM;
    float [] kp_7_weight = {(float)0,(float)0,(float)0,(float)0,(float)0,(float)0,(float)0};

    //float kp_7_angle_max;
    //float kp_7_angle_min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kp_enterseven);

        Check = (Button) findViewById(R.id.check);
        Back = (Button) findViewById(R.id.back);
        TextView Weight = (TextView) findViewById(R.id.weight);
        TextView Angle = (TextView) findViewById(R.id.angle);
        PS = (EditText)findViewById(R.id.PS);
        PM = (EditText)findViewById(R.id.PM);
        NS = (TextView)findViewById(R.id.NS);
        NM = (TextView)findViewById(R.id.NM);

        Weight.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/SentyTang.ttf"));
        Angle.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/SentyTang.ttf"));

        //更換頁面到KP_Graphic
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
                        "".equals(edt7.getText().toString().trim()) ){

                    //產生視窗物件
                    new AlertDialog.Builder(KP_Enter_Seven.this)
                            .setTitle("警告視窗")//標題
                            .setMessage("輸入格式有誤")//顯示的文字
                            .setPositiveButton("關閉視窗",new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            }).show();//呈現對話視窗

                }else{

                    kp_7_weight[0] = Float.valueOf(edt1.getText().toString());
                    kp_7_weight[1] = Float.valueOf(edt2.getText().toString());
                    kp_7_weight[2] = Float.valueOf(edt3.getText().toString());
                    kp_7_weight[3] = Float.valueOf(edt4.getText().toString());
                    kp_7_weight[4] = Float.valueOf(edt5.getText().toString());
                    kp_7_weight[5] = Float.valueOf(edt6.getText().toString());
                    kp_7_weight[6] = Float.valueOf(edt7.getText().toString());

                    //kp_7_angle_min = Float.valueOf(edt8.getText().toString());
                    //kp_7_angle_max = Float.valueOf(edt9.getText().toString());

                    //存入全域變數的class
                    GlobalVariable gv = (GlobalVariable)getApplicationContext();
                    gv.setKp_7_weight(kp_7_weight);
                    //gv.setKp_7_angle(kp_7_angle_min,kp_7_angle_max);
                    gv.setIsSetting(17);
                    jumpKP_Seven();
                }
            }
        });

        //更換頁面到KP_Seven
        Back.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKP_Seven();
            }
        });

        PS.addTextChangedListener(this);
        PM.addTextChangedListener(this);
    }

    @Override
    public void afterTextChanged(Editable s) {
        // TODO Auto-generated method stub

    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,int after) {
        // TODO Auto-generated method stub

    }
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        // TODO Auto-generated method stub
        NS.setText("-" + PS.getText());
        NM.setText("-" + PM.getText());
    }


    public boolean onKeyDown(int keyCode,KeyEvent event){

        if(keyCode== KeyEvent.KEYCODE_BACK && event.getRepeatCount()==0){   //確定按下退出鍵and防止重複按下退出鍵

            dialog();

        }

        return false;

    }

    private void dialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(KP_Enter_Seven.this); //創建訊息方塊

        builder.setMessage("確定要離開？");

        builder.setTitle("離開");

        builder.setPositiveButton("確認", new DialogInterface.OnClickListener()  {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss(); //dismiss為關閉dialog,Activity還會保留dialog的狀態

                KP_Enter_Seven.this.finish();//關閉activity

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

    public void jumpKP_Seven() {

        Intent Jump = new Intent(KP_Enter_Seven.this, KP_Seven.class);
        startActivity(Jump);
        KP_Enter_Seven.this.finish();
    }
}


