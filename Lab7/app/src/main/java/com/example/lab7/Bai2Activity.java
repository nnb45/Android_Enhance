package com.example.lab7;

import static com.example.lab7.R.id.btnCase;
import static com.example.lab7.R.id.imgPC;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;

public class Bai2Activity extends AppCompatActivity {
    ImageView imgPC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        Button btnPC = findViewById(R.id.btnPC);
        Button btnCase = findViewById(R.id.btnCase);
        Button btnGear = findViewById(R.id.btnGear);

        imgPC = findViewById(R.id.imgPC);
        imgPC.setImageResource(R.drawable.pc);

        btnPC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showImage("PC");
            }
        });

        btnCase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImage("CasePC");
            }
        });

        btnGear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImage("Gear");
            }
        });
    }
    private void showImage(String image) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(imgPC, "translationX", 0f, 500f);
        anim.setDuration(2000);
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(imgPC, "alpha", 1f, 0f);
        anim1.setDuration(2000);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(imgPC, "translationX", -500f, 0f);
        anim2.setDuration(2000);
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(imgPC, "alpha", 0f, 1f);
        anim3.setDuration(2000);
        AnimatorSet ans = new AnimatorSet();
        ans.play(anim2).with(anim3).after(anim).after(anim1);
        ans.start();
        final String imgName = image;
        anim1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                if(imgName == "CasePC"){
                    imgPC.setImageResource(R.drawable.casepc);
                }
                if(imgName == "Gear"){
                    imgPC.setImageResource(R.drawable.gear);
                }
            }
            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
            }
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }
        });
    }
}