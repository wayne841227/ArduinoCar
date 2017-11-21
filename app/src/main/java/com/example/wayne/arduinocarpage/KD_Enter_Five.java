package com.example.wayne.arduinocarpage;

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

public class KD_Enter_Five extends AppCompatActivity implements TextWatcher {

    private Button Check,Back;
    private TextView NS;
    private EditText PS;
    float [] kd_5_weight = {(float)0,(float)0,(float)0,(float)0,(float)0};

    //float kd_5_angle_max;
    //float kd_5_angle_min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kd_enterfive);

        Check = (Button) findViewById(R.id.check);
        Back = (Button) findViewById(R.id.back);
        TextView Weight = (TextView) findViewById(R.id.weight);
        TextView Angle = (TextView) findViewById(R.id.angle);

        PS = (EditText)findViewById(R.id.PS);
        NS = (TextView)findViewById(R.id.NS);


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

                //EditText edt6 = (EditText) findViewById(R.id.edit6);
                //EditText edt7 = (EditText) findViewById(R.id.edit7);

                //判斷輸入值是否為空
                if("".equals(edt1.getText().toString().trim()) || "".equals(edt2.getText().toString().trim()) ||
                        "".equals(edt3.getText().toString().trim()) || "".equals(edt4.getText().toString().trim()) ||
                        "".equals(edt5.getText().toString().trim())){

                    //產生視窗物件
                    new AlertDialog.Builder(KD_Enter_Five.this)
                            .setTitle("警告視窗")//標題
                            .setMessage("輸入格式有誤")//顯示的文字
                            .setPositiveButton("關閉視窗",new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            }).show();//呈現對話視窗

                }else{

                    kd_5_weight[0] = Float.valueOf(edt1.getText().toString());
                    kd_5_weight[1] = Float.valueOf(edt2.getText().toString());
                    kd_5_weight[2] = Float.valueOf(edt3.getText().toString());
                    kd_5_weight[3] = Float.valueOf(edt4.getText().toString());
                    kd_5_weight[4] = Float.valueOf(edt5.getText().toString());

                    //kd_5_angle_min = Float.valueOf(edt6.getText().toString());
                    //kd_5_angle_max = Float.valueOf(edt7.getText().toString());

                    //存入全域變數的class
                    GlobalVariable gv = (GlobalVariable)getApplicationContext();
                    //gv.setKd_5_weight(kd_5_weight);
                    //gv.setKd_5_angle(kd_5_angle_min,kd_5_angle_max);
                    gv.setIsSetting(25);
                    jumpKD_Five();
                }
            }
        });

        //更換頁面到KD_Five
        Back.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKD_Five();
            }
        });

        PS.addTextChangedListener(this);
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
    }


    public boolean onKeyDown(int keyCode,KeyEvent event){

        if(keyCode== KeyEvent.KEYCODE_BACK && event.getRepeatCount()==0){   //確定按下退出鍵and防止重複按下退出鍵

            dialog();

        }

        return false;

    }

    private void dialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(KD_Enter_Five.this); //創建訊息方塊

        builder.setMessage("確定要離開？");

        builder.setTitle("離開");

        builder.setPositiveButton("確認", new DialogInterface.OnClickListener()  {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss(); //dismiss為關閉dialog,Activity還會保留dialog的狀態

                KD_Enter_Five.this.finish();//關閉activity

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

    public void jumpKD_Five() {

        Intent Jump = new Intent(KD_Enter_Five.this, KD_Five.class);
        startActivity(Jump);
        KD_Enter_Five.this.finish();
    }
}
