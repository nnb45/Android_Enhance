package com.example.ASM_MOB;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.ASM_MOB.adapter.DangKiMonHocAdapter;
import com.example.ASM_MOB.dao.DangKyMonHocDAO;
import com.example.ASM_MOB.model.MonHoc;
import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearCourse,linearMap, linearNews, linearSocial;
    DangKiMonHocAdapter dangKiMonHocAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //anh xa
        linearCourse = findViewById(R.id.linearCourse);
        linearMap = findViewById(R.id.linearMap);
        linearNews = findViewById(R.id.linearNews);
        linearSocial = findViewById(R.id.linearSocial);

//        //img for recyclerview
//        ArrayList<RegisterActivity> registerActivities = new ArrayList<>();
//        dangKiMonHocAdapter = new DangKiMonHocAdapter(this);

        // event click Course
        linearCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CourseActivity.class));
            }
        });

        // event click Maps
        linearMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
            }
        });

        // event click News
        linearNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NewsActivity.class));
            }
        });

        // event click Social
        linearSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SocialActivity.class));
            }
        });


    }


}