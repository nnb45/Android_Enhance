package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Bai3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);

        ImageView clock = findViewById(R.id.clock);
        clock.setImageResource(R.drawable.clock);

        ImageView hours = findViewById(R.id.hours);
        hours.setImageResource(R.drawable.hourhand);

        ImageView minutes = findViewById(R.id.minutes);
        minutes.setImageResource(R.drawable.minutehand);

        ImageView seconds = findViewById(R.id.seconds);
        seconds.setImageResource(R.drawable.secondhand);

        Button btnRun = findViewById(R.id.btnRun);
        btnRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                run();
            }
        });
    }
    public void run(){
        // anh xa
        ImageView clock = findViewById(R.id.clock);
        clock.setImageResource(R.drawable.clock);
        ImageView hours = findViewById(R.id.hours);
        hours.setImageResource(R.drawable.hourhand);
        ImageView minutes = findViewById(R.id.minutes);
        minutes.setImageResource(R.drawable.minutehand);
        ImageView seconds = findViewById(R.id.seconds);
        seconds.setImageResource(R.drawable.secondhand);

        // ham run
        Animation hour = AnimationUtils.loadAnimation(Bai3Activity.this, R.anim.hour);
        Animation minute = AnimationUtils.loadAnimation(Bai3Activity.this, R.anim.minutes);
        Animation second = AnimationUtils.loadAnimation(Bai3Activity.this, R.anim.seconds);

        hours.startAnimation(hour);
        minutes.startAnimation(minute);
        seconds.startAnimation(second);
    }
}