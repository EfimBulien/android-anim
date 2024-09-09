package com.example.myapplication;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class TweenAnimationActivity extends AppCompatActivity {

    private Animation animation;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);
        imageView = findViewById(R.id.imageView);
        Button btnStart = findViewById(R.id.btn_start_tween);
        Button btnStop = findViewById(R.id.btn_stop_tween);
        Button btnBack = findViewById(R.id.btn_back);
        animation = AnimationUtils.loadAnimation(this, R.anim.common_animation);
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.element_fade_in);
        imageView.startAnimation(fadeIn);
        Animation buttonFadeIn = AnimationUtils.loadAnimation(this, R.anim.button_fade_in);
        btnStart.startAnimation(buttonFadeIn);
        btnStop.startAnimation(buttonFadeIn);
        btnBack.startAnimation(buttonFadeIn);
        btnStart.setOnClickListener(v -> imageView.startAnimation(animation));
        btnStop.setOnClickListener(v -> imageView.clearAnimation());
        btnBack.setOnClickListener(v -> {
            finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });
    }
}