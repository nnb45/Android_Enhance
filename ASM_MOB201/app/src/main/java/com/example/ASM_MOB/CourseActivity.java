package com.example.ASM_MOB;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class CourseActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        CardView cvRegister = findViewById(R.id.cvRegister);
        CardView cvRegistered = findViewById(R.id.cvRegistered);

        cvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CourseActivity.this, RegisterActivity.class);
                Bundle bundle = new Bundle();
                bundle.putBoolean("isAll", true);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        cvRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CourseActivity.this, RegisterActivity.class);
                Bundle bundle = new Bundle();
                bundle.putBoolean("isAll", false);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        }

}
