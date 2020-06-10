package com.example.systembroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class GopalReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        switch (intent.getAction())
        {
            case Intent.ACTION_POWER_CONNECTED:
            {
                Toast.makeText(context, "power connected", Toast.LENGTH_SHORT).show();
                break;
            }
            case Intent.ACTION_POWER_DISCONNECTED:
            {
                Toast.makeText(context, "power dis connected", Toast.LENGTH_SHORT).show();
                break;
            }
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
            {
                Toast.makeText(context, "AIR PLANE MODE CHANGED", Toast.LENGTH_SHORT).show();
                break;
            }

        }

    }
}
