package com.example.myapplication;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class FrameAnimationActivity extends AppCompatActivity {

    private AnimationDrawable animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);
        ImageView imageView = findViewById(R.id.imageView);
        Button btnStart = findViewById(R.id.btn_start_frame);
        Button btnStop = findViewById(R.id.btn_stop_frame);
        Button btnBack = findViewById(R.id.btn_back);
        imageView.setBackgroundResource(R.drawable.animation_rabbit);
        animation = (AnimationDrawable) imageView.getBackground();
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.element_fade_in);
        imageView.startAnimation(fadeIn);
        Animation buttonFadeIn = AnimationUtils.loadAnimation(this, R.anim.button_fade_in);
        btnStart.startAnimation(buttonFadeIn);
        btnStop.startAnimation(buttonFadeIn);
        btnBack.startAnimation(buttonFadeIn);
        btnStart.setOnClickListener(v -> {
            if (!animation.isRunning()) {
                animation.start();
            }
        });
        btnStop.setOnClickListener(v -> {
            if (animation.isRunning()) {
                animation.stop();
            }
        });
        btnBack.setOnClickListener(v -> { finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });
    }
}