package com.example.wayne.arduinocarpage;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.Set;
import java.util.UUID;


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

    OutputStream mmOutputStream;
    InputStream mmInputStream;
    private BluetoothSocket mmSocket = null;
    private BluetoothDevice mmDevice = null;

    private String kp3String = "";
    private String kd3String = "";
    private String kp5String = "";
    private String kd5String = "";
    private String kp7String = "";
    private String kd7String = "";

    DecimalFormat mDecimalFormat = new DecimalFormat("#.##");



    public void setmmSocket(BluetoothSocket Socket){
        mmSocket = Socket;
    }

    public BluetoothSocket getmmSocket(){
        return mmSocket;
    }

    public boolean isSocket(){
        return mmSocket != null;
    }

    void sendData() throws IOException {
        //String msg = edit.getText().toString();
        //msg += "|";
        //mmOutputStream.write(msg.getBytes());
        //text.setText("Data Sent");
    }


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

    public String getKp3String(){

        StringBuffer buf = new StringBuffer();
        buf.append("p/3/");
        for(int i=0; i<3; i++){
            buf.append(kp_3_weight[i]);
            buf.append("/");
        }

        buf.append(kp_3_angle_min);
        buf.append("/");
        buf.append(kp_3_angle_min + (kp_3_angle_max - kp_3_angle_min)/2 );
        buf.append("/");
        buf.append(kp_3_angle_max);
        buf.append("/");

        kp3String = buf.toString();
        kp3String = String.format("%.2f", kp3String);


        return kp3String;
    }

    public String getKd3String(){

        StringBuffer buf = new StringBuffer();
        buf.append("d/3/");
        for(int i=0; i<3; i++){
            buf.append(kd_3_weight[i]);
            buf.append("/");
        }

        buf.append(kd_3_angle_min);
        buf.append("/");
        buf.append(kd_3_angle_min + (kd_3_angle_max - kd_3_angle_min)/2 );
        buf.append("/");
        buf.append(kd_3_angle_max);

        kd3String = buf.toString();
        kd3String = String.format("%.2f", kd3String);


        return kd3String;
    }

    public String getKp5String(){
        StringBuffer buf = new StringBuffer();
        buf.append("p/5/");
        for(int i=0; i<5; i++){
            buf.append(kp_5_weight[i]);
            buf.append("/");
        }

        buf.append(kp_5_angle_min);
        buf.append("/");
        buf.append(kp_5_angle_min + ((kp_5_angle_max - kp_5_angle_min)/4) );
        buf.append("/");
        buf.append(kp_5_angle_min + ((2*(kp_5_angle_max - kp_5_angle_min))/4));
        buf.append("/");
        buf.append(kp_5_angle_min + ((3*(kp_5_angle_max - kp_5_angle_min))/4));
        buf.append("/");
        buf.append(kp_5_angle_max);

        kp5String = buf.toString();
        kp5String = String.format("%.2f", kp5String);


        return kp5String;
    }

    public String getKd5String(){
        StringBuffer buf = new StringBuffer();
        buf.append("d/5/");
        for(int i=0; i<5; i++){
            buf.append(kd_5_weight[i]);
            buf.append("/");
        }

        buf.append(kd_5_angle_min);
        buf.append("/");
        buf.append(kd_5_angle_min + ((kd_5_angle_max - kd_5_angle_min)/4) );
        buf.append("/");
        buf.append(kd_5_angle_min + ((2*(kd_5_angle_max - kd_5_angle_min))/4));
        buf.append("/");
        buf.append(kd_5_angle_min + ((3*(kd_5_angle_max - kd_5_angle_min))/4));
        buf.append("/");
        buf.append(kd_5_angle_max);

        kd5String = buf.toString();
        kd5String = String.format("%.2f", kd5String);

        return kd5String;
    }

    public String getKp7String(){
        StringBuffer buf = new StringBuffer();
        buf.append("p/7/");
        for(int i=0; i<7; i++){
            buf.append(kp_7_weight[i]);
            buf.append("/");
        }

        buf.append(kp_7_angle_min);
        buf.append("/");
        buf.append(kp_7_angle_min + ((kp_7_angle_max - kp_7_angle_min)/6) );
        buf.append("/");
        buf.append(kp_7_angle_min + ((2*(kp_7_angle_max - kp_7_angle_min))/6));
        buf.append("/");
        buf.append(kp_7_angle_min + ((3*(kp_7_angle_max - kp_7_angle_min))/6));
        buf.append("/");
        buf.append(kp_7_angle_min + ((4*(kp_7_angle_max - kp_7_angle_min))/6));
        buf.append("/");
        buf.append(kp_7_angle_min + ((5*(kp_7_angle_max - kp_7_angle_min))/6));
        buf.append("/");
        buf.append(kp_7_angle_max);

        kp7String = buf.toString();
        kp7String = String.format("%.2f", kp7String);

        return kp7String;
    }

    public String getKd7String(){
        StringBuffer buf = new StringBuffer();
        buf.append("d/7/");
        for(int i=0; i<7; i++){
            buf.append(kd_7_weight[i]);
            buf.append("/");
        }

        buf.append(kd_7_angle_min);
        buf.append("/");
        buf.append(kd_7_angle_min + ((kd_7_angle_max - kd_7_angle_min)/6) );
        buf.append("/");
        buf.append(kd_7_angle_min + ((2*(kd_7_angle_max - kd_7_angle_min))/6));
        buf.append("/");
        buf.append(kd_7_angle_min + ((3*(kd_7_angle_max - kd_7_angle_min))/6));
        buf.append("/");
        buf.append(kd_7_angle_min + ((4*(kd_7_angle_max - kd_7_angle_min))/6));
        buf.append("/");
        buf.append(kd_7_angle_min + ((5*(kd_7_angle_max - kd_7_angle_min))/6));
        buf.append("/");
        buf.append(kd_7_angle_max);

        kd7String = buf.toString();
        kd7String = String.format("%.2f", kd7String);

        return kd7String;
    }



}
