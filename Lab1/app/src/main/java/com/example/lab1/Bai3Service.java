package com.example.lab1;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Bai3Service extends IntentService {
    int count = 0;
    public Bai3Service() {
        super("Bai3Service");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Bundle bundle = new Intent().getBundleExtra("b");
        String string = bundle.getString("edt");
        char[] chars = string.toCharArray(); // chuoi --> mang ki tu
        for (int i = 0; i < chars.length; i ++){
            if(chars[i] == 'A'){
                count++;
            }
        }
        Toast.makeText(this, "Amount of A character is: " +count, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Amount of A character is: " +count, Toast.LENGTH_SHORT).show();
    }
}