package com.example.alarmmanager1;

import androidx.appcompat.app.AppCompatActivity;
//import android.support.v7.app.AppCompatActivity;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private NotificationManager mNotificationManager;
    private static final int NOTIFICATION_ID = 0;
    private static final String PRIMARY_CHANNEL_ID =
            "primary_notification_channel";
private NotificationManager getmNotificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNotificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);

        ToggleButton alarmToggle = findViewById(R.id.alarmToggle);

        Intent notifyIntent = new Intent(this, AlarmReceiver.class);
        boolean alarmUp = (PendingIntent.getBroadcast(this, NOTIFICATION_ID,
                notifyIntent, PendingIntent.FLAG_NO_CREATE) != null);
        alarmToggle.setChecked(alarmUp);

        final PendingIntent notifyPendingIntent = PendingIntent.getBroadcast
                (this, NOTIFICATION_ID, notifyIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);

        final AlarmManager alarmManager = (AlarmManager) getSystemService
                (ALARM_SERVICE);

        alarmToggle.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton,
                                                 boolean isChecked) {
                        String toastMessage;
                        if (isChecked) {

                            long   repeatInterval = AlarmManager.INTERVAL_FIFTEEN_MINUTES;

                            long triggerTime = SystemClock.elapsedRealtime()
                                    + repeatInterval;

                            // If the Toggle is turned on, set the repeating alarm with
                            // a 15 minute interval.
                            if (alarmManager != null) {
                                alarmManager.setInexactRepeating
                                        (AlarmManager.ELAPSED_REALTIME_WAKEUP,
                                                triggerTime, repeatInterval,
                                                notifyPendingIntent);
                            }
                            // Set the toast message for the "on" case.
                            toastMessage = getString(R.string.alarm_on_toast);

                        } else {
                            // Cancel notification if the alarm is turned off.
                            mNotificationManager.cancelAll();

                            if (alarmManager != null) {
                                alarmManager.cancel(notifyPendingIntent);
                            }
                            // Set the toast message for the "off" case.
                            toastMessage = getString(R.string.alarm_off_toast);

                        }

                        // Show a toast to say the alarm is turned on or off.
                        Toast.makeText(MainActivity.this, toastMessage,
                                Toast.LENGTH_SHORT).show();
                    }
                });

    }

    public void createNotificationChannel() {
        mNotificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.O) {

            // Create the NotificationChannel with all the parameters.
            NotificationChannel notificationChannel = new NotificationChannel
                    (PRIMARY_CHANNEL_ID,
                            "Stand up notification",
                            NotificationManager.IMPORTANCE_HIGH);

            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription
                    ("Notifies every 15 minutes to stand up and walk");
            mNotificationManager.createNotificationChannel(notificationChannel);


        }


    }

}