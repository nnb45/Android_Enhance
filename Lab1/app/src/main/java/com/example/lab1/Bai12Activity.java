package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Bai12Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai12);

        Button btnStart = findViewById(R.id.btnStart);
        Button btnStop = findViewById(R.id.btnStop);
        Intent intent = new Intent(Bai12Activity.this, Bai12Service.class);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // tao Intent
                Intent intent = new Intent(Bai12Activity.this, Bai12Service.class);
                // tao Bundle
                Bundle bundle = new Bundle();
                // khai bao gia tri va gan vao Bundle
                bundle.putInt("StudentID", 1);
                bundle.putString("StudentName", "Bảo Ngọc");
                bundle.putString("Class", "CP17308");
                // gan Bundle vao Intent
                intent.putExtra("student", bundle);
                startService();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService();
            }
        });
    }

    public void startService(){
        Intent intent = new Intent(Bai12Activity.this, Bai12Service.class);
        startService(intent);
    }

    public void stopService(){
        Intent intent = new Intent(Bai12Activity.this, Bai12Service.class);
        stopService(intent);
    }
}