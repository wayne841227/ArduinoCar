package com.example.wayne.arduinocarpage;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

/**
 * Created by nancy on 2017/8/18.
 */

public class KP_Seven extends AppCompatActivity implements SurfaceHolder.Callback{

    private Button Check,Back,Five,Three,pass;
    private SurfaceView surface;

    float [] kp_7_weight;
    public float kp_7_angle_min;
    public float kp_7_angle_max;
    float [] kp_7_angle = {(float)0,(float)0,(float)0,(float)0,(float)0,(float)0,(float)0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kp_seven);
        getWindow().setWindowAnimations(0);

        final GlobalVariable gv = (GlobalVariable)getApplicationContext();
        kp_7_weight = gv.getKp_7_weight();
        kp_7_angle_min = gv.getKp_7_angle_min();
        kp_7_angle_max = gv.getKp_7_angle_max();

        calAngle(kp_7_angle_min,kp_7_angle_max);


        surface = (SurfaceView)findViewById(R.id.kp7_Surface);
        surface.getHolder().addCallback(this);

        Three = (Button)findViewById(R.id.button3);
        Five = (Button)findViewById(R.id.button5);
        Check = (Button) findViewById(R.id.check);
        Back = (Button) findViewById(R.id.back);
        pass = (Button)findViewById(R.id.pass);


        //更換頁面到KP_Three
        Three.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v){
                jumpKP_Three();
            }
        });

        //更換頁面到KP_Five
        Five.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKP_Five();
            }
        });

        //更換頁面到KP_Enter_Seven
        Check.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKP_Enter_Three();
            }
        });

        //更換頁面到MainActivity
        Back.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpMain();
            }
        });

        pass.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                if(gv.getIsSetting() != 0) {
                    gv.setCheckString(gv.getKp7String());
                    gv.setMode("KP 7");
                    jumpMain();
                }
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

        AlertDialog.Builder builder = new AlertDialog.Builder(KP_Seven.this); //創建訊息方塊

        builder.setMessage("確定要離開？");

        builder.setTitle("離開");

        builder.setPositiveButton("確認", new DialogInterface.OnClickListener()  {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss(); //dismiss為關閉dialog,Activity還會保留dialog的狀態

                KP_Seven.this.finish();//關閉activity

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


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Drawing(holder);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int frmt, int w, int h) {
        Drawing(holder);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {}

    private void Drawing(SurfaceHolder holder) {

        Canvas canvas = holder.lockCanvas();
        if(kp_7_weight != null){
            if (canvas == null) {
            } else {
                draw(canvas);
                holder.unlockCanvasAndPost(canvas);
            }
        }else{
            if (canvas == null) {
            } else {
                drawBlank(canvas);
                holder.unlockCanvasAndPost(canvas);
            }
        }
    }

    private void drawBlank(final Canvas canvas){
        canvas.drawColor(Color.WHITE);
    }

    private void draw(final Canvas canvas) {
        canvas.drawColor(Color.WHITE);

        Paint g = new Paint();
        Paint b = new Paint();
        Paint draw_g = new Paint();
        Paint draw_b = new Paint();
        Paint t = new Paint();

        g.setColor(Color.GREEN);
        b.setColor(Color.BLUE);

        //畫點
        canvas.drawCircle(300, 100, 10, g);
        canvas.drawCircle(700, 100, 10, g);
        canvas.drawCircle(1100, 100, 10, g);
        canvas.drawCircle(1500, 100, 10, g);

        canvas.drawCircle(500, 400, 10, g);
        canvas.drawCircle(900, 400, 10, g);
        canvas.drawCircle(1300, 400, 10, g);


        draw_g.setColor(Color.GREEN);
        float[] g_pts={250,100,300,100,
                300,100,500,400,
                500,400,700,100,
                700,100,900,400,
                900,400,1100,100,
                1100,100,1300,400,
                1300,400,1500,100,
                1500,100,1550,100};
        draw_g.setStrokeWidth((float) 8.0);
        canvas.drawLines(g_pts, draw_g);



        canvas.drawCircle(500, 100, 10, b);
        canvas.drawCircle(900, 100, 10, b);
        canvas.drawCircle(1300, 100, 10, b);

        canvas.drawCircle(300, 400, 10, b);
        canvas.drawCircle(700, 400, 10, b);
        canvas.drawCircle(1100, 400, 10, b);
        canvas.drawCircle(1500, 400, 10, b);

        draw_b.setColor(Color.BLUE);
        float[] b_pts={250,400,300,400,
                300,400,500,100,
                500,100,700,400,
                700,400,900,100,
                900,100,1100,400,
                1100,400,1300,100,
                1300,100,1500,400,
                1500,400,1550,400};
        draw_b.setStrokeWidth((float) 8.0);
        canvas.drawLines(b_pts, draw_b);

        //顯示數字
        t.setColor(Color.BLACK);
        t.setTextSize(50);
        canvas.drawText(String.format(Locale.getDefault(),"%.2f", kp_7_weight[0]), 300-25, 80, t);
        canvas.drawText(String.format(Locale.getDefault(),"%.2f", kp_7_weight[1]), 500-25, 80, t);
        canvas.drawText(String.format(Locale.getDefault(),"%.2f", kp_7_weight[2]), 700-25, 80, t);
        canvas.drawText(String.format(Locale.getDefault(),"%.2f", kp_7_weight[3]), 900-25, 80, t);
        canvas.drawText(String.format(Locale.getDefault(),"%.2f", kp_7_weight[4]), 1100-25, 80, t);
        canvas.drawText(String.format(Locale.getDefault(),"%.2f", kp_7_weight[5]), 1300-25, 80, t);
        canvas.drawText(String.format(Locale.getDefault(),"%.2f", kp_7_weight[6]), 1500-25, 80, t);

        canvas.drawText(String.format(Locale.getDefault(),"%.2f", kp_7_angle[0]), 300-25, 400+50, t);
        canvas.drawText(String.format(Locale.getDefault(),"%.2f", kp_7_angle[1]), 500-25, 400+50, t);
        canvas.drawText(String.format(Locale.getDefault(),"%.2f", kp_7_angle[2]), 700-25, 400+50, t);
        canvas.drawText(String.format(Locale.getDefault(),"%.2f", kp_7_angle[3]), 900-25, 400+50, t);
        canvas.drawText(String.format(Locale.getDefault(),"%.2f", kp_7_angle[4]), 1100-25, 400+50, t);
        canvas.drawText(String.format(Locale.getDefault(),"%.2f", kp_7_angle[5]), 1300-25, 400+50, t);
        canvas.drawText(String.format(Locale.getDefault(),"%.2f", kp_7_angle[6]), 1500-25, 400+50, t);


    }

    private void calAngle(float kp_7_angle_min,float kp_7_angle_max){

        float w = kp_7_angle_max - kp_7_angle_min;
        kp_7_angle[0] = kp_7_angle_min;
        kp_7_angle[1] = kp_7_angle_min + ((w)/6);
        kp_7_angle[2] = kp_7_angle_min + ((2*w)/6);
        kp_7_angle[3] = kp_7_angle_min + ((3*w)/6);
        kp_7_angle[4] = kp_7_angle_min + ((4*w)/6);
        kp_7_angle[5] = kp_7_angle_min + ((5*w)/6);
        kp_7_angle[6] = kp_7_angle_max;
    }

    public void jumpKP_Three() {

        Intent Jump = new Intent(KP_Seven.this, KP_Three.class);
        startActivity(Jump);
        KP_Seven.this.finish();
    }

    public void jumpKP_Five(){

        Intent Jump = new Intent(KP_Seven.this,KP_Five.class);
        startActivity(Jump);
        KP_Seven.this.finish();

    }

    public void jumpKP_Enter_Three() {

        Intent Jump = new Intent(KP_Seven.this, KP_Enter_Seven.class);
        startActivity(Jump);
        KP_Seven.this.finish();
    }

    public void jumpMain() {

//        Intent Jump = new Intent(KP_Seven.this, MainActivity.class);
//        startActivity(Jump);
        KP_Seven.this.finish();
    }
}
