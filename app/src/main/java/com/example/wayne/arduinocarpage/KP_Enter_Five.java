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

public class KP_Enter_Five extends AppCompatActivity {

    private Button Check,Back;
    float [] kp_5_weight = {(float)0,(float)0,(float)0,(float)0,(float)0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kp_enterfive);

        Check = (Button) findViewById(R.id.check);
        Back = (Button) findViewById(R.id.back);
        TextView Weight = (TextView) findViewById(R.id.weight);
        TextView Angle = (TextView) findViewById(R.id.angle);

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

                //判斷輸入值是否為空
                if("".equals(edt1.getText().toString().trim()) || "".equals(edt2.getText().toString().trim()) ||
                        "".equals(edt3.getText().toString().trim()) || "".equals(edt4.getText().toString().trim()) ||
                        "".equals(edt5.getText().toString().trim())){

                    //產生視窗物件
                    new AlertDialog.Builder(KP_Enter_Five.this)
                            .setTitle("警告視窗")//標題
                            .setMessage("輸入格式有誤")//顯示的文字
                            .setPositiveButton("關閉視窗",new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            }).show();//呈現對話視窗

                }else{

                    kp_5_weight[0] = Float.valueOf(edt1.getText().toString());
                    kp_5_weight[1] = Float.valueOf(edt2.getText().toString());
                    kp_5_weight[2] = Float.valueOf(edt3.getText().toString());
                    kp_5_weight[3] = Float.valueOf(edt4.getText().toString());
                    kp_5_weight[4] = Float.valueOf(edt5.getText().toString());

                    //存入全域變數的class
                    GlobalVariable gv = (GlobalVariable)getApplicationContext();
                    gv.setkp_5_weight(kp_5_weight);

                    jumpKP_Five();
                }


            }
        });

        //更換頁面到KP_Five
        Back.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKP_Five();
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

        AlertDialog.Builder builder = new AlertDialog.Builder(KP_Enter_Five.this); //創建訊息方塊

        builder.setMessage("確定要離開？");

        builder.setTitle("離開");

        builder.setPositiveButton("確認", new DialogInterface.OnClickListener()  {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss(); //dismiss為關閉dialog,Activity還會保留dialog的狀態

                KP_Enter_Five.this.finish();//關閉activity

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

    public void jumpKP_Five() {

        Intent Jump = new Intent(KP_Enter_Five.this, KP_Five.class);
        startActivity(Jump);
        KP_Enter_Five.this.finish();
    }
}

