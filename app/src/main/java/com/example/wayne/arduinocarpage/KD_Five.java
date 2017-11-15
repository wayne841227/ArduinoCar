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
import android.widget.Toast;

import java.util.Locale;

public class KD_Five extends AppCompatActivity implements SurfaceHolder.Callback{

    private Button Check,Back,Three,Seven,pass;
    private SurfaceView surface;

    float [] kd_5_weight;
    //public float kd_5_angle_min;
    //public float kd_5_angle_max;
    //float [] kd_5_angle = {(float)0,(float)0,(float)0,(float)0,(float)0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kd_five);
        getWindow().setWindowAnimations(0);

        final GlobalVariable gv = (GlobalVariable)getApplicationContext();
        kd_5_weight = gv.getKd_5_weight();
        //kd_5_angle_min = gv.getKd_5_angle_min();
        //kd_5_angle_max = gv.getKd_5_angle_max();

        //calAngle(kd_5_angle_min,kd_5_angle_max);

        surface = (SurfaceView)findViewById(R.id.kd5_Surface);
        surface.getHolder().addCallback(this);

        Three = (Button)findViewById(R.id.button3);
        Seven = (Button)findViewById(R.id.button7);
        Check = (Button) findViewById(R.id.check);
        Back = (Button) findViewById(R.id.back);
        pass = (Button)findViewById(R.id.pass);


        //更換頁面到KD_Three
        Three.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKD_Three();
            }
        });
        //更換頁面到KD_Seven
        Seven.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v){
                jumpKD_Seven();
            }
        });

        //更換頁面到KD_Enter_Five
        Check.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKD_Enter_Five();
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
                if(gv.getIsSetting() == 25) {
                    gv.setCheckString(gv.getKd5String());
                    gv.setMode("KD 5");
                    jumpMain();
                }else{
                    Toast.makeText(getApplicationContext(), "未變更", Toast.LENGTH_SHORT).show();
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

        AlertDialog.Builder builder = new AlertDialog.Builder(KD_Five.this); //創建訊息方塊

        builder.setMessage("確定要離開？");

        builder.setTitle("離開");

        builder.setPositiveButton("確認", new DialogInterface.OnClickListener()  {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss(); //dismiss為關閉dialog,Activity還會保留dialog的狀態

                KD_Five.this.finish();//關閉activity

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

        if(kd_5_weight != null){
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
        canvas.drawCircle(700, 100, 10, g);
        canvas.drawCircle(1100, 100, 10, g);

        canvas.drawCircle(500, 400, 10, g);
        canvas.drawCircle(900, 400, 10, g);
        canvas.drawCircle(1300, 400, 10, g);


        draw_g.setColor(Color.GREEN);
        float[] g_pts={250,400,500,400,
                500,400,700,100,
                700,100,900,400,
                900,400,1100,100,
                1100,100,1300,400,
                1300,400,1550,400};
        draw_g.setStrokeWidth((float) 8.0);
        canvas.drawLines(g_pts, draw_g);

        canvas.drawCircle(500, 100, 10, b);
        canvas.drawCircle(900, 100, 10, b);
        canvas.drawCircle(1300, 100, 10, b);

        canvas.drawCircle(700, 400, 10, b);
        canvas.drawCircle(1100, 400, 10, b);

        draw_b.setColor(Color.BLUE);
        float[] b_pts={250,100,500,100,
                500,100,700,400,
                700,400,900,100,
                900,100,1100,400,
                1100,400,1300,100,
                1300,100,1550,100};
        draw_b.setStrokeWidth((float) 8.0);
        canvas.drawLines(b_pts, draw_b);

        //顯示數字
        t.setColor(Color.BLACK);
        t.setTextSize(50);

        canvas.drawText("NB", 500-25, 80, t);
        canvas.drawText("NS", 700-25, 80, t);
        canvas.drawText("ZO", 900-25, 80, t);
        canvas.drawText("PS", 1100-25, 80, t);
        canvas.drawText("PB", 1300-25, 80, t);

//        canvas.drawText(String.format(Locale.getDefault(),"%.2f", kd_5_weight[0]), 500-25, 80, t);
//        canvas.drawText(String.format(Locale.getDefault(),"%.2f", kd_5_weight[1]), 700-25, 80, t);
//        canvas.drawText(String.format(Locale.getDefault(),"%.2f", kd_5_weight[2]), 900-25, 80, t);
//        canvas.drawText(String.format(Locale.getDefault(),"%.2f", kd_5_weight[3]), 1100-25, 80, t);
//        canvas.drawText(String.format(Locale.getDefault(),"%.2f", kd_5_weight[4]), 1300-25, 80, t);

        canvas.drawText("-30", 500-25, 450+50, t);
        canvas.drawText(String.format(Locale.getDefault(),"%.2f", kd_5_weight[3]*(-1)), 700-25, 450+50, t);
        canvas.drawText("0", 900-25, 450+50, t);
        canvas.drawText(String.format(Locale.getDefault(),"%.2f", kd_5_weight[3]), 1100-25, 450+50, t);
        canvas.drawText("30", 1300-25, 450+50, t);

//        canvas.drawText(String.format(Locale.getDefault(),"%.2f", kd_5_angle[0]), 500-25, 400+50, t);
//        canvas.drawText(String.format(Locale.getDefault(),"%.2f", kd_5_angle[1]), 700-25, 400+50, t);
//        canvas.drawText(String.format(Locale.getDefault(),"%.2f", kd_5_angle[2]), 900-25, 400+50, t);
//        canvas.drawText(String.format(Locale.getDefault(),"%.2f", kd_5_angle[3]), 1100-25, 400+50, t);
//        canvas.drawText(String.format(Locale.getDefault(),"%.2f", kd_5_angle[4]), 1300-25, 400+50, t);


    }

//    private void calAngle(float kd_5_angle_min,float kd_5_angle_max){
//
//        float w = kd_5_angle_max - kd_5_angle_min;
//        kd_5_angle[0] = kd_5_angle_min;
//        kd_5_angle[1] = kd_5_angle_min + ((w)/4);
//        kd_5_angle[2] = kd_5_angle_min + ((2*w)/4);
//        kd_5_angle[3] = kd_5_angle_min + ((3*w)/4);
//        kd_5_angle[4] = kd_5_angle_max;
//    }

    public void jumpKD_Three(){

        Intent Jump = new Intent(KD_Five.this,KD_Three.class);
        startActivity(Jump);
        KD_Five.this.finish();
    }

    public void jumpKD_Seven() {

        Intent Jump = new Intent(KD_Five.this, KD_Seven.class);
        startActivity(Jump);
        KD_Five.this.finish();
    }

    public void jumpKD_Enter_Five() {

        Intent Jump = new Intent(KD_Five.this, KD_Enter_Five.class);
        startActivity(Jump);
        KD_Five.this.finish();
    }

    public void jumpMain() {

//        Intent Jump = new Intent(KD_Five.this, MainActivity.class);
//        startActivity(Jump);
        KD_Five.this.finish();
    }
}
