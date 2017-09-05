package com.example.wayne.arduinocarpage;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

/**
 * Created by nancy on 2017/8/18.
 */

public class KP_Three extends AppCompatActivity implements SurfaceHolder.Callback{

    private Button Check,Back,Five,Seven;
    private SurfaceView surface;

    float [] kp_3_weight;
    float [] kp_3_angle = {(float)19,(float)21,(float)22};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kp_three);
        getWindow().setWindowAnimations(0);

        GlobalVariable gv = (GlobalVariable)getApplicationContext();
        kp_3_weight = gv.getkp_3_weight();

        surface = (SurfaceView)findViewById(R.id.kp3_Surface);
        surface.getHolder().addCallback(this);

        Five = (Button)findViewById(R.id.button5);
        Seven = (Button)findViewById(R.id.button7);
        Check = (Button) findViewById(R.id.check);
        Back = (Button) findViewById(R.id.back);


        //更換頁面到KD_Five
        Five.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKP_Five();
            }
        });
        //更換頁面到KD_Seven
        Seven.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v){
                jumpKP_Seven();
            }
        });

        //更換頁面到KD_Enter_Three
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

        if(kp_3_weight != null){
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

        canvas.drawCircle(900, 400, 10, g);


        draw_g.setColor(Color.GREEN);
        float[] g_pts={250,100,700,100,
                700,100,900,400,
                900,400,1100,100,
                1100,100,1550,100};
        draw_g.setStrokeWidth((float) 8.0);
        canvas.drawLines(g_pts, draw_g);

        canvas.drawCircle(900, 100, 10, b);

        canvas.drawCircle(700, 400, 10, b);
        canvas.drawCircle(1100, 400, 10, b);

        draw_b.setColor(Color.BLUE);
        float[] b_pts={250,400,700,400,
                700,400,900,100,
                900,100,1100,400,
                1100,400,1550,400};
        draw_b.setStrokeWidth((float) 8.0);
        canvas.drawLines(b_pts, draw_b);

        //顯示數字
        t.setColor(Color.BLACK);
        t.setTextSize(50);
        canvas.drawText(String.valueOf(kp_3_weight[0]), 700-25, 80, t);
        canvas.drawText(String.valueOf(kp_3_weight[1]), 900-25, 80, t);
        canvas.drawText(String.valueOf(kp_3_weight[2]), 1100-25, 80, t);

        canvas.drawText(String.valueOf(kp_3_angle[0]), 700-25, 400+50, t);
        canvas.drawText(String.valueOf(kp_3_angle[1]), 900-25, 400+50, t);
        canvas.drawText(String.valueOf(kp_3_angle[2]), 1100-25, 400+50, t);


    }

    public void jumpKP_Five(){

        Intent Jump = new Intent(KP_Three.this,KP_Five.class);
        startActivity(Jump);
        KP_Three.this.finish();
    }

    public void jumpKP_Seven() {

        Intent Jump = new Intent(KP_Three.this, KP_Seven.class);
        startActivity(Jump);
        KP_Three.this.finish();
    }

    public void jumpKP_Enter_Three() {

        Intent Jump = new Intent(KP_Three.this, KP_Enter_Three.class);
        startActivity(Jump);
        KP_Three.this.finish();
    }

    public void jumpMain() {

        Intent Jump = new Intent(KP_Three.this, MainActivity.class);
        startActivity(Jump);
        KP_Three.this.finish();
    }
}
