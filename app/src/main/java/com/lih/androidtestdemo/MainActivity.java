package com.lih.androidtestdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        new Thread( new Runnable( ) {
            @Override
            public void run() {
                //耗时任务，比如加载网络数据
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // 这里可以睡几秒钟，如果要放广告的话
                        // sleep(3000);
                        Intent intent = MainActivity.newInstance(MainActivity.this);
                        startActivity(intent);
//                        MainActivity.this.finish();
                    }
                });
            }
        } ).start();
    }

    private static Intent newInstance(MainActivity mainActivity) {
        return null;
    }


}
