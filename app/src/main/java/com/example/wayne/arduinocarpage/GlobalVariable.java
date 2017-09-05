package com.example.wayne.arduinocarpage;

import android.app.Application;

/**
 * Created by wayne on 2017/9/4.
 */

public class GlobalVariable extends Application {

    private float[] kd_3_weight;
    private float[] kd_5_weight;
    private float[] kd_7_weight;

    private float[] kp_3_weight;
    private float[] kp_5_weight;
    private float[] kp_7_weight;


    public void setkd_3_weight(float[] kd_3_weight){
        this.kd_3_weight = kd_3_weight;
    }
    public float[] getkd_3_weight() {
        return kd_3_weight;
    }

    public void setkd_5_weight(float[] kd_5_weight){
        this.kd_5_weight = kd_5_weight;
    }
    public float[] getkd_5_weight() {
        return kd_5_weight;
    }

    public void setkd_7_weight(float[] kd_7_weight){
        this.kd_7_weight = kd_7_weight;
    }
    public float[] getkd_7_weight() {
        return kd_7_weight;
    }



    public void setkp_3_weight(float[] kp_3_weight){
        this.kp_3_weight = kp_3_weight;
    }
    public float[] getkp_3_weight() {
        return kp_3_weight;
    }

    public void setkp_5_weight(float[] kp_5_weight){
        this.kp_5_weight = kp_5_weight;
    }
    public float[] getkp_5_weight() {
        return kp_5_weight;
    }

    public void setkp_7_weight(float[] kp_7_weight){
        this.kp_7_weight = kp_7_weight;
    }
    public float[] getkp_7_weight() {
        return kp_7_weight;
    }

}
