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


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        Paint p = new Paint();
        Paint m = new Paint();

        p.setColor(Color.RED);
        p.setTextSize(45);
        canvas.drawText("Kp：", 50, 200, p);

        m.setColor(Color.RED);
        m.setTextSize(45);
        canvas.drawText("Kd：", 50, 400, m);

        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(5);
        p.setColor(Color.BLACK);
        canvas.drawRect(150, 150, 400, 250, p);
        canvas.drawRect(400, 150, 650, 250, p);
        canvas.drawRect(650, 150, 900, 250, p);

        m.setStyle(Paint.Style.STROKE);
        m.setColor(Color.BLACK);
        m.setStrokeWidth(5);
        canvas.drawRect(150, 350, 400, 450, m);
        canvas.drawRect(400, 350, 650, 450, m);
        canvas.drawRect(650, 350, 900, 450, m);

        if(kp>0 && kp<=0.2){
            p.setColor(Color.RED);
            p.setStyle(Paint.Style.FILL);
            canvas.drawRect(153, 153, 397, 247, p);
        }else if(kp>0.2 && kp <=0.4){
            p.setColor(Color.RED);
            p.setStyle(Paint.Style.FILL);
            canvas.drawRect(403, 153, 647, 247, p);
        }else{
            p.setColor(Color.RED);
            p.setStyle(Paint.Style.FILL);
            canvas.drawRect(653, 153, 897, 247, p);
        }

        if(kd>0 && kd<=18){
            m.setColor(Color.RED);
            m.setStyle(Paint.Style.FILL);
            canvas.drawRect(153, 353, 397, 447, m);
        }else if(kd>18 && kd <=28){
            m.setColor(Color.RED);
            m.setStyle(Paint.Style.FILL);
            canvas.drawRect(403, 353, 647, 447, m);
        }else{
            m.setColor(Color.RED);
            m.setStyle(Paint.Style.FILL);
            canvas.drawRect(653, 353, 897, 447, m);
        }

    }
}