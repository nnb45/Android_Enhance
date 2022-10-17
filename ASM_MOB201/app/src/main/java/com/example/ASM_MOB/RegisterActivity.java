package com.example.ASM_MOB;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class RegisterActivity extends AppCompatActivity {
    RecyclerView recyclerRegisterCourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activity);

        recyclerRegisterCourse = findViewById(R.id.recyclerRegisterCourse);


    }
}