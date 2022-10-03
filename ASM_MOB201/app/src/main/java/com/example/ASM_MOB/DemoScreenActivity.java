package com.example.ASM_MOB;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class DemoScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_screen);

        ImageView ivLogo = findViewById(R.id.ivLogo);

        Glide.with(this).load(R.mipmap.loading).into(ivLogo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(DemoScreenActivity.this, LoginActivity.class));
            }
        },1500);
    }
}