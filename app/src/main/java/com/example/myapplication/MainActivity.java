package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFrame = findViewById(R.id.btn_frame_animation);
        Button btnTween = findViewById(R.id.btn_tween_animation);

        btnFrame.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FrameAnimationActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });

        btnTween.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TweenAnimationActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
    }
}