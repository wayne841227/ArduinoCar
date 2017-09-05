package com.example.wayne.arduinocarpage;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

/**
 * Created by nancy on 2017/8/18.
 */


public class KD_Seven extends Activity implements SurfaceHolder.Callback{

    private Button Check,Back,Five,Three;
    private SurfaceView surface;

    float [] kd_7_weight;
    float [] kd_7_angle = {(float)18,(float)20,(float)23,(float)25,(float)29,(float)31,(float)35};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kd_seven);
        getWindow().setWindowAnimations(0);

        GlobalVariable gv = (GlobalVariable)getApplicationContext();
        kd_7_weight = gv.getkd_7_weight();

        surface = (SurfaceView)findViewById(R.id.kd7_Surface);
        surface.getHolder().addCallback(this);

        Three = (Button)findViewById(R.id.button3);
        Five = (Button)findViewById(R.id.button5);
        Check = (Button) findViewById(R.id.check);
        Back = (Button) findViewById(R.id.back);

        //更換頁面到KD_Three
        Three.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v){
                jumpKD_Three();
            }
        });

        //更換頁面到KD_Five
        Five.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKD_Five();
            }
        });

        //更換頁面到KD_Enter_Seven
        Check.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKD_Enter_Three();
            }
        });

        //更換頁面到MainActivity
        Back.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpMain();
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

        AlertDialog.Builder builder = new AlertDialog.Builder(KD_Seven.this); //創建訊息方塊

        builder.setMessage("確定要離開？");

        builder.setTitle("離開");

        builder.setPositiveButton("確認", new DialogInterface.OnClickListener()  {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss(); //dismiss為關閉dialog,Activity還會保留dialog的狀態

                KD_Seven.this.finish();//關閉activity

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
        if(kd_7_weight != null){
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
        canvas.drawText(String.valueOf(kd_7_weight[0]), 300-25, 80, t);
        canvas.drawText(String.valueOf(kd_7_weight[1]), 500-25, 80, t);
        canvas.drawText(String.valueOf(kd_7_weight[2]), 700-25, 80, t);
        canvas.drawText(String.valueOf(kd_7_weight[3]), 900-25, 80, t);
        canvas.drawText(String.valueOf(kd_7_weight[4]), 1100-25, 80, t);
        canvas.drawText(String.valueOf(kd_7_weight[5]), 1300-25, 80, t);
        canvas.drawText(String.valueOf(kd_7_weight[6]), 1500-25, 80, t);

        canvas.drawText(String.valueOf(kd_7_angle[0]), 300-25, 400+50, t);
        canvas.drawText(String.valueOf(kd_7_angle[1]), 500-25, 400+50, t);
        canvas.drawText(String.valueOf(kd_7_angle[2]), 700-25, 400+50, t);
        canvas.drawText(String.valueOf(kd_7_angle[3]), 900-25, 400+50, t);
        canvas.drawText(String.valueOf(kd_7_angle[4]), 1100-25, 400+50, t);
        canvas.drawText(String.valueOf(kd_7_angle[5]), 1300-25, 400+50, t);
        canvas.drawText(String.valueOf(kd_7_angle[6]), 1500-25, 400+50, t);


    }

    public void jumpKD_Three() {

        Intent Jump = new Intent(KD_Seven.this, KD_Three.class);
        startActivity(Jump);
        KD_Seven.this.finish();
    }

    public void jumpKD_Five(){

        Intent Jump = new Intent(KD_Seven.this,KD_Five.class);
        startActivity(Jump);
        KD_Seven.this.finish();
    }

    public void jumpKD_Enter_Three() {

        Intent Jump = new Intent(KD_Seven.this, KD_Enter_Seven.class);
        startActivity(Jump);
        KD_Seven.this.finish();
    }

    public void jumpMain() {

        Intent Jump = new Intent(KD_Seven.this, MainActivity.class);
        startActivity(Jump);
        KD_Seven.this.finish();
    }
}
