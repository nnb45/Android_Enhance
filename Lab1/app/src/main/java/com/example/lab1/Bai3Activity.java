package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class Bai3Activity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);

        // gui data
        editText = findViewById(R.id.edtText);
        Bundle bundle = new Bundle();
        bundle.putString("edt",editText.getText().toString());
        Intent intent = new Intent(this, Bai3Service.class);
        intent.putExtra("b", bundle);
    }
}