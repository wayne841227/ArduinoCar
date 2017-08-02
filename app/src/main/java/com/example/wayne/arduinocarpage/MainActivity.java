package com.example.wayne.arduinocarpage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(MainActivity.this));

    }

}

class DrawView extends View {
    public DrawView(Context context) {
        super(context);
    }
    double kp = 0.1;
    double kd = 1;
    double angle = -23;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

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