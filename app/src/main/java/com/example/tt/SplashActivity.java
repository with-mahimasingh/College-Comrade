package com.example.tt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private  static int SPLASH_SCREEN=4000;
    ImageView logo;
    TextView heading, subtitle;
    Animation topAnimation, bottomAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logo= findViewById(R.id.logo);
        heading= findViewById(R.id.heading);
        subtitle= findViewById(R.id.subtitle);

        topAnimation= AnimationUtils.loadAnimation(SplashActivity.this,R.anim.top_animation);
        bottomAnimation= AnimationUtils.loadAnimation(SplashActivity.this,R.anim.bottom_animation);

        logo.setAnimation(topAnimation);
        heading.setAnimation(bottomAnimation);
        subtitle.setAnimation(bottomAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }
}