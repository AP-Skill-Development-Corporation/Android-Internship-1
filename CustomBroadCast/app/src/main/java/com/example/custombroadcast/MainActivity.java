package com.example.custombroadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String custom="com.example.custombroadcast";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocalBroadcastManager.getInstance(this).registerReceiver(
                new MyReceiver(),
                new IntentFilter(custom));
    }

    public void getcustom(View view)
    {
        Intent i=new Intent(custom);

        LocalBroadcastManager.getInstance(this)
                .sendBroadcast(i);




    }
}
