package com.xzy.ui.javademo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case 1:
                    Toast.makeText(MainActivity.this, "1111", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
    private Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            Message msg = new Message();
            msg.what =1;
            msg.arg1 = 2;
            handler.sendMessage(msg);

            Handler handler1 = new Handler(Looper.getMainLooper());
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thread.start();
    }
}
