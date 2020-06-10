package com.example.cherry.examplework;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class ThirdWork extends Worker {

    NotificationManager manager;

    public ThirdWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);

        manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

    }

    @NonNull
    @Override
    public Result doWork() {
        createNotification();
        sendNotification();
        return Result.success();
    }

    private void sendNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext()
                ,"Cherry");
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(getApplicationContext(),0,i,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentTitle("Notify");
        builder.setContentText("This is my notification.");
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setContentIntent(pi);
        manager.notify(0,builder.build());
    }

    private void createNotification() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("Cherry","APSSDC",
                    NotificationManager.IMPORTANCE_HIGH);
            channel.enableLights(true);
            channel.enableVibration(true);
            channel.setLightColor(Color.GREEN);
            manager.createNotificationChannel(channel);
        }
    }
}
