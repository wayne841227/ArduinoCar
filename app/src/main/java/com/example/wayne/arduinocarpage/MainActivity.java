package com.example.wayne.arduinocarpage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.graphics.Typeface;
import android.app.Activity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import com.example.wayne.arduinocarpage.R;
import android.content.Intent;

import java.util.Random;

public class MainActivity extends Activity implements Runnable{

    private Button KP,KD;
    private SurfaceView surface;
    private SurfaceHolder holder;
    private boolean locker=true;
    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        KP = (Button) findViewById(R.id.kp);
        KD = (Button) findViewById(R.id.kd);
        surface = (SurfaceView) findViewById(R.id.surfaceView);

        holder = surface.getHolder();
        thread = new Thread(this);
        thread.start();

        //更換頁面到Enter_Three
        KP.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {

                jumpKP_Five();
                locker = false;
            }
        });

        //更換頁面到Enter_Three
        KD.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {

                jumpKD_Five();
                locker = false;
            }
        });
    }
    public void jumpKD_Five(){

        Intent Jump = new Intent(MainActivity.this,KD_Five.class);
        startActivity(Jump);
        MainActivity.this.finish();

    }

    public void jumpKP_Five(){

        Intent Jump = new Intent(MainActivity.this,KP_Five.class);
        startActivity(Jump);
        MainActivity.this.finish();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(locker){
            //checks if the lockCanvas() method will be success,and if not, will check this statement again
            if(!holder.getSurface().isValid()){
                continue;
            }
            /** Start editing pixels in this surface.*/
            Canvas canvas = holder.lockCanvas();

            //ALL PAINT-JOB MAKE IN draw(canvas); method.
            draw(canvas);

            // End of painting to canvas. system will paint with this canvas,to the surface.
            holder.unlockCanvasAndPost(canvas);
        }
    }
    /**This method deals with paint-works. Also will paint something in background*/

    Random r = new Random();

    private void draw(Canvas canvas) {
//        Paint gradPaint = new Paint();
//        gradPaint.setShader(new LinearGradient(0,0,0,getHeight(),Color.WHITE,Color.WHITE,Shader.TileMode.CLAMP));
//        canvas.drawPaint(gradPaint);

        canvas.drawColor(Color.WHITE);

        double kp = 0.0 + (0.4 - 0) * r.nextDouble();
        double kd = 1 + (28) * r.nextDouble();
        double angle = 1 + (30) * r.nextDouble();

        //kp長條圖
        Paint p = new Paint();
        //kd長條圖
        Paint d = new Paint();
        //角度圖
        Paint a = new Paint();

        p.setColor(Color.RED);
        p.setTextSize(50);
        canvas.drawText("Kp：", 35, 215, p);

        d.setColor(Color.RED);
        d.setTextSize(50);
        canvas.drawText("Kd：", 35, 415, d);

        //kp,kp清空顏色
        p.setColor(Color.WHITE);
        p.setStyle(Paint.Style.FILL);
        canvas.drawRect(150, 150, 900, 250, p);
        d.setColor(Color.WHITE);
        d.setStyle(Paint.Style.FILL);
        canvas.drawRect(150, 350, 900, 450, d);

        //kp顯示範圍著色
        p.setColor(Color.RED);
        p.setStyle(Paint.Style.FILL);
        if(kp>0 && kp<=0.2){
            canvas.drawRect(150, 150, 400, 250, p);
        }else if(kp>0.2 && kp <=0.4){
            canvas.drawRect(400, 150, 650, 250, p);
        }else{
            canvas.drawRect(650, 150, 900, 250, p);
        }

        //kd顯示範圍著色
        d.setColor(Color.RED);
        d.setStyle(Paint.Style.FILL);
        if(kd>0 && kd<=18){
            canvas.drawRect(150, 350, 400, 450, d);
        }else if(kd>18 && kd <=28){
            canvas.drawRect(400, 350, 650, 450, d);
        }else{
            canvas.drawRect(650, 350, 900, 450, d);
        }

        //kp長條圖框架
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(5);
        p.setColor(Color.BLACK);
        canvas.drawRect(150, 150, 400, 250, p);
        canvas.drawRect(400, 150, 650, 250, p);
        canvas.drawRect(650, 150, 900, 250, p);

        //kd長條圖框架
        d.setStyle(Paint.Style.STROKE);
        d.setColor(Color.BLACK);
        d.setStrokeWidth(5);
        canvas.drawRect(150, 350, 400, 450, d);
        canvas.drawRect(400, 350, 650, 450, d);
        canvas.drawRect(650, 350, 900, 450, d);

        //設定範圍矩形
        RectF rec_range = new RectF(1150, 150, 1750, 750);

        //角度取絕對值
        if(angle < 0){
            angle = 0 - angle;
        }

        //清空角度顯示顏色
        a.setStyle(Paint.Style.FILL);
        a.setColor(Color.WHITE);
        canvas.drawArc(rec_range, 0, -180, true, a);

        //角度顯示範圍著色
        a.setStyle(Paint.Style.FILL);
        a.setColor(Color.RED);
        if(angle >= 0 && angle < 8){
            canvas.drawArc(rec_range, -135, -45, true, a);
        }else if(angle >= 8 && angle < 15){
            canvas.drawArc(rec_range, -90, -45, true, a);
        }else if(angle >= 15 && angle < 23){
            canvas.drawArc(rec_range, -45, -45, true, a);
        }else if(angle >= 23 && angle < 30){
            canvas.drawArc(rec_range, 0, -45, true, a);
        }else{}

        //角度圖框架
        a.setColor(Color.BLACK);
        a.setTextSize(50);
        canvas.drawText("0°", 1050, 465, a);
        canvas.drawText("8°", 1175, 225, a);
        canvas.drawText("15°", 1425, 125, a);
        canvas.drawText("23°", 1675, 225, a);
        canvas.drawText("30°", 1800, 465, a);

        a.setAntiAlias(true);
        a.setStrokeWidth(5);
        a.setStyle(Paint.Style.STROKE);
        a.setColor(Color.BLACK);
        canvas.drawArc(rec_range, 0, -45, false, a);
        canvas.drawArc(rec_range, -45, -45, false, a);
        canvas.drawArc(rec_range, -90, -45, false, a);
        canvas.drawArc(rec_range, -135, -45, false, a);

        canvas.rotate(45,1450,450);
        canvas.drawLine(1450, 450, 1150, 450, a);
        canvas.rotate(45,1450,450);
        canvas.drawLine(1450, 450, 1150, 450, a);
        canvas.rotate(45,1450,450);
        canvas.drawLine(1450, 450, 1150, 450, a);
        canvas.rotate(-135,1450,450);
        canvas.drawLine(1450, 450, 1775, 450, a);
        canvas.drawLine(1450, 450, 1125, 450, a);
    }


}
