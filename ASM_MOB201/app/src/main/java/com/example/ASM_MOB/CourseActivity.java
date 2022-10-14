package com.example.ASM_MOB;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CourseActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        Button btnRegister = findViewById(R.id.btnRegister);
        Button btnRegistered = findViewById(R.id.btnRegistered);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CourseActivity.this, RegisterAvtivity.class));
            }
        });
    }
}