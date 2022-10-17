package com.example.lab7;

import static com.example.lab7.R.id.btnRota;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnBai1 = findViewById(R.id.btnBai1);
        Button btnBai2 = findViewById(R.id.btnBai2);
        Button btnBai3 = findViewById(R.id.btnBai3);

        btnBai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bai1();
            }
        });

        btnBai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bai2();
            }
        });
        btnBai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bai3();
            }
        });
    }
    public void bai1(){
        Intent intent = new Intent(MainActivity.this, Bai1Activity.class);
        startActivity(intent);
    }
    public void bai2(){
        Intent intent = new Intent(MainActivity.this, Bai2Activity.class);
        startActivity(intent);
    }
    public void bai3(){
        Intent intent = new Intent(MainActivity.this, Bai3Activity.class);
        startActivity(intent);
    }
}