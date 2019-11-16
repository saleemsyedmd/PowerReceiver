package com.example.notifyme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {
    private Button button_notify;
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";
    private NotificationManager mNotifyManager;
    private static final int NOTIFICATION_ID = 0;
    private Button button_cancel;
    private Button button_update;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createNotificationChannel();
        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID);
        getNotificationBuilder();
        button_notify = findViewById(R.id.notify);
        button_notify.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                sendNotification();
            }

        });

        button_update = findViewById(R.id.update);
        button_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNotification();
                Bitmap androidImage = BitmapFactory
                        .decodeResource(getResources(),R.drawable.ic_stat_name);

                NotificationCompat.Builder notifyBuilder = getNotificationBuilder();

                notifyBuilder.setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(androidImage)
                        .setBigContentTitle("Notification Updated!"));

                mNotifyManager.notify(NOTIFICATION_ID, notifyBuilder.build());



                //Update the notification
            }
        });


        button_cancel = findViewById(R.id.cancel);
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelNotification();
                mNotifyManager.cancel(NOTIFICATION_ID);




                //Cancel the notification
            }
        });
        
    }



    private NotificationCompat.Builder getNotificationBuilder() {
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent notificationPendingIntent;

       // getActivity((PendingIntent notificationPendingIntent = getActivity(this,NOTIFICATION_ID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT) );
             //   setContentIntent(notificationPendingIntent);
                     //   .setAutoCancel(true);
                
        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID);
        notifyBuilder.setContentTitle(" you have been notified")
                .setContentText("This is your notification text.")
                .setSmallIcon(R.drawable.ic_android);
        return notifyBuilder;
    }

    private void setContentIntent(PendingIntent notificationPendingIntent) {
        
        setContentIntent(notificationPendingIntent);
                //.setAutoCancel(true);
         
    }

    public void createNotificationChannel()
    {
        mNotifyManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
         if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.O) {
             NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID,
                 "Mascot Notification", NotificationManager
                 .IMPORTANCE_HIGH);
        // Create a NotificationChannel
             notificationChannel.enableLights(true);
             notificationChannel.setLightColor(Color.RED);
             notificationChannel.enableVibration(true);
             notificationChannel.setDescription("Notification from Mascot");
             mNotifyManager.createNotificationChannel(notificationChannel);


    }

    }


    public void sendNotification() {NotificationCompat.Builder notifyBuilder = getNotificationBuilder().setPriority(NotificationCompat.PRIORITY_HIGH);
        mNotifyManager.notify(NOTIFICATION_ID, notifyBuilder.setDefaults(NotificationCompat.DEFAULT_ALL).build());

    }

    public void updateNotification() {}
    public void cancelNotification() {}

    }

