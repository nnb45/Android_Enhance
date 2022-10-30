package com.example.lab1;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

public class Bai12Service extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    // khoi tao service
    @Override
    public void onCreate() {
        super.onCreate();
//        Toast.makeText(getApplicationContext(), "Service is created!", Toast.LENGTH_SHORT).show();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getApplicationContext(), "Service is starting!", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service is stopped!", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Toast.makeText(getApplicationContext(), "Service is starting!", Toast.LENGTH_SHORT).show();
        // lay bunlde tu Intent
        Bundle bundle = intent.getBundleExtra("student");
        // lay gia tri tu Bundle
        int StudentID = bundle.getInt("StudentID");
        String StudentName = bundle.getString("StudentName");
        String Class = bundle.getString("Class");

        String content = "Insert student successfully! \n Student Info:\n Student: "+StudentID+" "+ StudentName;
        content +="\n Class: "+Class;
        Toast.makeText(this, content, Toast.LENGTH_LONG).show();
    }


}