package com.grajos.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    Handler h = new Handler();
    Animation logoAnim;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        h.postDelayed(() -> {
            Intent i = new Intent(SplashScreen.this, MainActivity.class);

            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair<View,String>(image, "logo_image");

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashScreen.this,pairs);
            startActivity(i, options.toBundle());
            finish();
        }, 4000);

        //animation
        logoAnim = AnimationUtils.loadAnimation(this,R.anim.logo_animation);
        //hooks
        image = findViewById(R.id.omologo);

        image.setAnimation(logoAnim);


    }
}