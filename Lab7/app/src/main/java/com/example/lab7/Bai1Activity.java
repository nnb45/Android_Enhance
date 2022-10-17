package com.example.lab7;


import androidx.appcompat.app.AppCompatActivity;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Bai1Activity extends AppCompatActivity {
    ImageView imgAni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);

        Button btnZoom = findViewById(R.id.btnZoom);
        Button btnRota = findViewById(R.id.btnRota);
        Button btnMoving = findViewById(R.id.btnMoving);
        imgAni = findViewById(R.id.imgAni);
        imgAni.setImageResource(R.drawable.pc);

        btnZoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zoomImage();
            }
        });

        btnMoving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movingImage();
            }
        });
        btnRota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotateImage();
            }
        });
    }
    public void zoomImage(){
        Animation animation = AnimationUtils.loadAnimation(Bai1Activity.this, R.anim.zoom);
        imgAni.startAnimation(animation);
    }
    public void movingImage(){
        Animation animation = AnimationUtils.loadAnimation(Bai1Activity.this, R.anim.moving);
        imgAni.startAnimation(animation);
    }
    public void rotateImage(){
        int dest = 360;
        if(imgAni.getRotation() == 360){
            System.out.println(imgAni.getAlpha());
            dest = 0;
        }
        ObjectAnimator animator = ObjectAnimator.ofFloat(imgAni, "rotation", dest);
        animator.setDuration(2000);
        animator.start();
    }
}