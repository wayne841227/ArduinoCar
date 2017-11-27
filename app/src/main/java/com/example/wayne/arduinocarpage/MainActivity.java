package com.example.wayne.arduinocarpage;

import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.RequiresApi;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

public class MainActivity extends Activity implements Runnable{

    private Button KP,KD,OPEN,CLOSE,TOP,DOWN,LEFT,RIGHT;
    private SurfaceView surface;
    private SurfaceHolder holder;
    private boolean locker=true;
    private Thread thread;
    private TextView text;
    static String data = "00000000";

    static BluetoothAdapter mBluetoothAdpter;
    static BluetoothSocket mmSocket;
    static BluetoothDevice mmDevice;
    static OutputStream mmOutputStream;
    static InputStream mmInputStream;
    static boolean isConnected = false;
    Thread workerThead;
    byte[] readerThread;
    int readBufferPositioin;
    int counter;
    volatile boolean stopWorker;
    Canvas canvas;
    GlobalVariable gv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gv = (GlobalVariable)getApplicationContext();
        setContentView(R.layout.activity_main);

        KP = (Button) findViewById(R.id.kp);
        KD = (Button) findViewById(R.id.kd);
        OPEN = (Button) findViewById(R.id.bluetooth_open);
        CLOSE = (Button) findViewById(R.id.bluetooth_close);
        TOP = (Button) findViewById(R.id.Up);
        LEFT = (Button) findViewById(R.id.Left);
        RIGHT = (Button) findViewById(R.id.Right);
        DOWN = (Button) findViewById(R.id.Down);

        text = (TextView) findViewById(R.id.textView);

        surface = (SurfaceView) findViewById(R.id.surfaceView);

        holder = surface.getHolder();
        thread = new Thread(this);

        TOP.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v,MotionEvent event){
            // TODO Auto-generated method stub
                if(event.getAction()== MotionEvent.ACTION_DOWN){  //按下的時候
                    try {
                        TOP.setBackground(getResources().getDrawable(R.drawable.ul));
                        sendData("F");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {  //起來的時候
                    try {
                        TOP.setBackground(getResources().getDrawable(R.drawable.upp));
                        sendData("S");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }
        });

        DOWN.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v,MotionEvent event){
                // TODO Auto-generated method stub
                if(event.getAction()== MotionEvent.ACTION_DOWN){  //按下的時候
                    try {
                        DOWN.setBackground(getResources().getDrawable(R.drawable.dl));
                        sendData("B");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {  //起來的時候
                    try {
                        DOWN.setBackground(getResources().getDrawable(R.drawable.d));
                        sendData("S");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }
        });
        LEFT.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v,MotionEvent event){
                // TODO Auto-generated method stub
                if(event.getAction()== MotionEvent.ACTION_DOWN){  //按下的時候
                    try {
                        LEFT.setBackground(getResources().getDrawable(R.drawable.ll));
                        sendData("L");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {  //起來的時候
                    try {
                        LEFT.setBackground(getResources().getDrawable(R.drawable.r));
                        sendData("S");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }
        });
        RIGHT.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v,MotionEvent event){
                // TODO Auto-generated method stub
                if(event.getAction()== MotionEvent.ACTION_DOWN){  //按下的時候
                    try {
                        RIGHT.setBackground(getResources().getDrawable(R.drawable.rl));
                        sendData("R");

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {  //起來的時候
                    try {
                        RIGHT.setBackground(getResources().getDrawable(R.drawable.l));
                        sendData("S");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }
        });

        //更換頁面到Enter_Three
        KP.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKP_Three();
                locker = false;

            }
        });

        //更換頁面到Enter_Three
        KD.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                jumpKD_Three();
                locker = false;
            }
        });

        OPEN.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v,MotionEvent event){
                // TODO Auto-generated method stub
                if(event.getAction()== MotionEvent.ACTION_DOWN){  //按下的時候
                    OPEN.setBackgroundColor(Color.parseColor("#FF0000"));
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {  //起來的時候
                    OPEN.setBackgroundColor(Color.parseColor("#76EE00"));
                    try{
                        if(!isConnected) {
                            findBT();
                            openBT();
                        }else{
                            Toast.makeText(getApplicationContext(),"connected",Toast.LENGTH_SHORT).show();
                        }
                    }catch(IOException ex){

                    }
                }
                return true;
            }
        });

        CLOSE.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v,MotionEvent event){
                // TODO Auto-generated method stub
                if(event.getAction()== MotionEvent.ACTION_DOWN){  //按下的時候
                    CLOSE.setBackgroundColor(Color.parseColor("#FF0000"));
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {  //起來的時候
                    CLOSE.setBackgroundColor(Color.parseColor("#76EE00"));
                    try{
                        closeBT();
                    }catch(IOException ex){}
                }
                return true;
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        //Toast.makeText(this,"onResume",Toast.LENGTH_LONG).show();
        locker=true;
        //Toast.makeText(this,mmSocket!=null?"re:connect:" + mmSocket.isConnected():"re:unconnect",Toast.LENGTH_SHORT).show();
        if(!thread.isAlive()) {
            thread = new Thread(this);
            thread.start();
        }
        if(gv.getIsSetting() > 0){
            try {
                sendData("5");
                sendData(gv.getCheckString());
                if((gv.getIsSetting()/10) == 2){
                    KD.setText(gv.getModed());
                }else{
                    KP.setText(gv.getModep());
                }
                gv.setIsSetting(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            closeBT();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        locker = false;
    }

    void findBT() throws IOException{
        mBluetoothAdpter = BluetoothAdapter.getDefaultAdapter();

        if(mBluetoothAdpter == null){
            //Log.d("r","no open bluetooth");
            text.setText("no open bluetooth");
        }

        if(!mBluetoothAdpter.isEnabled()){
            Intent enableBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBluetooth,0);
        }
        Set<BluetoothDevice> pairdDevice = mBluetoothAdpter.getBondedDevices();
        if(pairdDevice.size() > 0){
            for( BluetoothDevice device :pairdDevice){
                text.setText(device.getName());
                Toast.makeText(this,"Find" + device.getName(),Toast.LENGTH_SHORT).show();
                //Log.d("device",String.valueOf(device.getName()));
                mmDevice = device;
                break;
            }
        }
    }

    void openBT() throws IOException {
        UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
        if(mmDevice!=null){
            mmSocket = mmDevice.createInsecureRfcommSocketToServiceRecord(uuid);
            //gv.setmmSocket(mmSocket);
            mmSocket.connect();

            if(mmSocket.isConnected()) {
                mmOutputStream = mmSocket.getOutputStream();
                mmInputStream = mmSocket.getInputStream();
                isConnected = true;
                sendData("5");
                beginListenForData();
                Toast.makeText(this, "connected", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "No connect", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"No Find device",Toast.LENGTH_SHORT).show();
            mmDevice = null;
        }
    }

    void beginListenForData() {
//        final Handler handler = new Handler();
//        final byte delimiter = 10;

        stopWorker = false;
        readBufferPositioin = 0;
        readerThread = new byte[1024];
        workerThead = new Thread(new Runnable(){
            public void run() {
                while(!Thread.currentThread().isInterrupted() && !stopWorker) {
                    try {
                        int byteAvailable = mmInputStream.available();
                        if(byteAvailable > 0) {
                            //Log.d("res", String.valueOf(byteAvailable));
                            //Log.d("resukt", "have  data");

                            byte[] packetBytes = new byte[byteAvailable];
                            mmInputStream.read(packetBytes);
                            //Log.d("resukt", "have  data " + (packetBytes));
                            for (int i = 0; i < byteAvailable; i++) {
                                byte b = packetBytes[i];
                                if (b == '/') {
                                    readerThread[readBufferPositioin++] = b;
                                    byte[] encodedBytes = new byte[readBufferPositioin];
                                    System.arraycopy(readerThread, 0, encodedBytes, 0, encodedBytes.length);
                                    data = new String(encodedBytes, "US-ASCII");
                                    readBufferPositioin = 0;
                                }
                                else {
                                    readerThread[readBufferPositioin++] = b;
                                }
                            }
                        }
                    }
                    catch (IOException ex) {
                        stopWorker = true;
                    }
                }
            }
        });

        workerThead.start();
    }

    void closeBT() throws IOException {
        if(isConnected) {
            stopWorker = true;
            isConnected = false;
            mmOutputStream.close();
            mmInputStream.close();
            mmSocket.close();
            data = "00000000";
            Toast.makeText(this, "close", Toast.LENGTH_SHORT).show();
            text.setText("Bluetooth Closed");
        }else{
            Toast.makeText(this, "No  any connect can close", Toast.LENGTH_SHORT).show();
        }
    }

    void sendData(String msg) throws IOException {
        if(isConnected) {
            mmOutputStream.write(msg.getBytes());
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            //text.setText("Data Sent");
        }else{
            Toast.makeText(this, "No send", Toast.LENGTH_SHORT).show();
        }
    }



    public boolean onKeyDown(int keyCode,KeyEvent event){

        if(keyCode== KeyEvent.KEYCODE_BACK && event.getRepeatCount()==0){   //確定按下退出鍵and防止重複按下退出鍵

            dialog();

        }

        return false;

    }

    private void dialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this); //創建訊息方塊

        builder.setMessage("確定要離開？");

        builder.setTitle("離開");

        builder.setPositiveButton("確認", new DialogInterface.OnClickListener()  {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss(); //dismiss為關閉dialog,Activity還會保留dialog的狀態
                locker = false;
                MainActivity.this.finish();//關閉activity

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

    public void jumpKD_Three(){

        Intent Jump = new Intent(MainActivity.this,KD_Three.class);
        startActivity(Jump);
        //MainActivity.this.finish();

    }

    public void jumpKP_Three(){

        Intent Jump = new Intent(MainActivity.this,KP_Three.class);
        startActivity(Jump);
        //MainActivity.this.finish();
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
                canvas = holder.lockCanvas();

                //ALL PAINT-JOB MAKE IN draw(canvas); method.
                draw(canvas);
                //Log.d("X12",data);

                // End of painting to canvas. system will paint with this canvas,to the surface.
                holder.unlockCanvasAndPost(canvas);
            }
        }

    /**This method deals with paint-works. Also will paint something in background*/

    //Random r = new Random();

    private void draw(Canvas canvas) {

        canvas.drawColor(Color.WHITE);

        double angle=0;

        //kp長條圖
        Paint p = new Paint();
        //kd長條圖
        Paint d = new Paint();
        //角度圖
        Paint a = new Paint();

        p.setColor(Color.RED);
        p.setTextSize(70);
        canvas.drawText("Kd", 35, 415, p);
        //canvas.drawText(String.valueOf(px) , 35, 415, d);
        p.setColor(Color.BLACK);
        p.setTextSize(50);
        canvas.drawText("0", 140, 130, p);
        canvas.drawText("0.2", 380, 130, p);
        canvas.drawText("0.4", 630, 130, p);

        d.setColor(Color.RED);
        d.setTextSize(70);
        canvas.drawText("Kp", 35, 215, d);
        d.setColor(Color.BLACK);
        d.setTextSize(50);
        canvas.drawText("0", 140, 330, d);
        canvas.drawText("18", 380, 330, d);
        canvas.drawText("28", 630, 330, d);

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

        if(data.charAt(2) == 's'){
            canvas.drawRect(150, 150, 400, 250, p);
        }else if(data.charAt(2) == 'm'){
            canvas.drawRect(400, 150, 650, 250, p);
        }else if(data.charAt(2) == 'l'){
            canvas.drawRect(650, 150, 900, 250, p);
        }else{}

        //kd顯示範圍著色
        d.setColor(Color.RED);
        d.setStyle(Paint.Style.FILL);
        if(data.charAt(0) == 's'){
            canvas.drawRect(150, 350, 400, 450, d);
        }else if(data.charAt(0) == 'm'){
            canvas.drawRect(400, 350, 650, 450, d);
        }else if(data.charAt(0) == 'l'){
            canvas.drawRect(650, 350, 900, 450, d);
        }else{}

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

//        //角度取絕對值
//        if(angle < 0){
//            angle = 0 - angle;
//        }

        //清空角度顯示顏色
        a.setStyle(Paint.Style.FILL);
        a.setColor(Color.WHITE);
        canvas.drawArc(rec_range, 0, -180, true, a);

        //角度顯示範圍著色
        a.setStyle(Paint.Style.FILL);
        a.setColor(Color.RED);
        if((data.charAt(4) == 's')){
            canvas.drawArc(rec_range, -135, -45, true, a);
        }else if((data.charAt(4) == 'q')){
            canvas.drawArc(rec_range, -90, -45, true, a);
        }else if((data.charAt(4) == 'm')){
            canvas.drawArc(rec_range, -45, -45, true, a);
        }else if((data.charAt(4) == 'l')){
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
