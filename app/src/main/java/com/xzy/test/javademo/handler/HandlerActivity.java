package com.xzy.test.javademo.handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.xzy.test.javademo.R;

/**
 * handler 的基本用法：
 * 1.从子线程发消息到主线程处理
 * 2.从主线程发消息到子线程处理
 * 3.在子线程中创建handler时，需要手动获取到looper，获取到looper有两种方式：
 * 3.1手动调用Looper.prepare()方法
 * 3.2使用HandlerThread类的对象handlerThread.getLooper()
 *
 * @author xzy
 */
public class HandlerActivity extends AppCompatActivity {

    private Handler handler01;
    private Handler handler02;
    private Handler handler03;

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //主线程中google工程师默认设置了looper，不需要手动设置Looper.prepare();
        handler01 = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 1) {
                    Log.d("xzy01", String.valueOf(msg.arg1));
                }
                Log.d("xzy01", Thread.currentThread().getName());
                //主线程是不允许退出的
                //handler01.getLooper().quitSafely();
            }
        };

        // 子线程中创建handler
        //方式1.创建handler之前手动调用Looper.prepare()获取到looper
        new Thread(new Runnable() {
            @Override
            public void run() {
                //子线程给主线程发消息（主流）
                Message msg = new Message();
                msg.arg1 = 1;
                msg.what = 1;
                handler01.sendMessage(msg);

                // 在非主线程实例化Handler需要手动调用 Looper.prepare();
                //是为了在prepare方法中给Looper内持有的ThreadLocal变量sThreadLocal设置惟一的looper
                Looper.prepare();
                handler02 = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        if (msg.what == 2) {
                            Log.d("xzy02", String.valueOf(msg.arg1));
                        }
                        Log.d("xzy02", Thread.currentThread().getName());
                        handler02.getLooper().quitSafely();
                    }
                };
                //模拟在子线程toast或者dialog
                Toast.makeText(HandlerActivity.this, "haha1", Toast.LENGTH_SHORT).show();

                handler02.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(HandlerActivity.this, "haha00000000000000000", Toast.LENGTH_SHORT).show();
                    }
                });

                //启动循环
                Looper.loop();
                //模拟在子线程toast或者dialog，需要调用 Looper.prepare();
//                new Handler(Looper.getMainLooper()).post(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(HandlerActivity.this, "haha", Toast.LENGTH_SHORT).show();
//                    }
//                });
            }
        }).start();

        try {
            //主线程给子线程发送消息，比较少见
            Thread.sleep(2000);
            Message msg2 = new Message();
            msg2.arg1 = 2;
            msg2.what = 2;
            handler02.sendMessage(msg2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //方式2.使用HandlerThread类获取到looper
        //传入线程名字
        final HandlerThread handlerThread = new HandlerThread("thread-xzy");
        //必须要启动
        handlerThread.start();
        handler03 = new Handler(handlerThread.getLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if (msg.what == 3) {
                    Log.d("xzy03", String.valueOf(msg.arg1));
                }
                Log.d("xzy03", Thread.currentThread().getName());
                handler03.getLooper().quitSafely();
                handlerThread.quit();
            }
        };

        //主线程给子线程发送消息
        Message msg3 = new Message();
        msg3.arg1 = 3;
        msg3.what = 3;
        handler03.sendMessage(msg3);
    }
}