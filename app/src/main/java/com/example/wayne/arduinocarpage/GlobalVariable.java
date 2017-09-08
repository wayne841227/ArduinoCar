package com.example.wayne.arduinocarpage;

import android.app.Application;

/**
 * Created by wayne on 2017/9/4.
 */

public class GlobalVariable extends Application {

    private float[] kd_3_weight;
    private float kd_3_angle_min;
    private float kd_3_angle_max;

    private float[] kd_5_weight;
    private float kd_5_angle_min;
    private float kd_5_angle_max;

    private float[] kd_7_weight;
    private float kd_7_angle_min;
    private float kd_7_angle_max;

    private float[] kp_3_weight;
    private float kp_3_angle_min;
    private float kp_3_angle_max;

    private float[] kp_5_weight;
    private float kp_5_angle_min;
    private float kp_5_angle_max;

    private float[] kp_7_weight;
    private float kp_7_angle_min;
    private float kp_7_angle_max;


    public void setKd_3_weight(float[] kd_3_weight){
        this.kd_3_weight = kd_3_weight;
    }
    public float[] getKd_3_weight() {
        return kd_3_weight;
    }
    public void setKd_3_angle(float kd_3_angle_min , float kd_3_angle_max){
        this.kd_3_angle_min = kd_3_angle_min;
        this.kd_3_angle_max = kd_3_angle_max;
    }
    public float getKd_3_angle_min() {
        return kd_3_angle_min;
    }
    public float getKd_3_angle_max() {
        return kd_3_angle_max;
    }


    public void setKd_5_weight(float[] kd_5_weight){
        this.kd_5_weight = kd_5_weight;
    }
    public float[] getKd_5_weight() {
        return kd_5_weight;
    }
    public void setKd_5_angle(float kd_5_angle_min , float kd_5_angle_max){
        this.kd_5_angle_min = kd_5_angle_min;
        this.kd_5_angle_max = kd_5_angle_max;
    }
    public float getKd_5_angle_min() {
        return kd_5_angle_min;
    }
    public float getKd_5_angle_max() {
        return kd_5_angle_max;
    }

    public void setKd_7_weight(float[] kd_7_weight){
        this.kd_7_weight = kd_7_weight;
    }
    public float[] getKd_7_weight() {
        return kd_7_weight;
    }
    public void setKd_7_angle(float kd_7_angle_min , float kd_7_angle_max){
        this.kd_7_angle_min = kd_7_angle_min;
        this.kd_7_angle_max = kd_7_angle_max;
    }
    public float getKd_7_angle_min() {
        return kd_7_angle_min;
    }
    public float getKd_7_angle_max() {
        return kd_7_angle_max;
    }



    public void setKp_3_weight(float[] kp_3_weight){
        this.kp_3_weight = kp_3_weight;
    }
    public float[] getKp_3_weight() {
        return kp_3_weight;
    }

    public void setKp_3_angle(float kp_3_angle_min , float kp_3_angle_max){
        this.kp_3_angle_min = kp_3_angle_min;
        this.kp_3_angle_max = kp_3_angle_max;
    }
    public float getKp_3_angle_min() {
        return kp_3_angle_min;
    }
    public float getKp_3_angle_max() {
        return kp_3_angle_max;
    }

    public void setKp_5_weight(float[] kp_5_weight){
        this.kp_5_weight = kp_5_weight;
    }
    public float[] getKp_5_weight() {
        return kp_5_weight;
    }
    public void setKp_5_angle(float kp_5_angle_min , float kp_5_angle_max){
        this.kp_5_angle_min = kp_5_angle_min;
        this.kp_5_angle_max = kp_5_angle_max;
    }
    public float getKp_5_angle_min() {
        return kp_5_angle_min;
    }
    public float getKp_5_angle_max() {
        return kp_5_angle_max;
    }

    public void setKp_7_weight(float[] kp_7_weight){
        this.kp_7_weight = kp_7_weight;
    }
    public float[] getKp_7_weight() {
        return kp_7_weight;
    }
    public void setKp_7_angle(float kp_7_angle_min , float kp_7_angle_max){
        this.kp_7_angle_min = kp_7_angle_min;
        this.kp_7_angle_max = kp_7_angle_max;
    }
    public float getKp_7_angle_min() {
        return kp_7_angle_min;
    }
    public float getKp_7_angle_max() {
        return kp_7_angle_max;
    }

}
