package com.example.musictask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView logo=(ImageView)findViewById(R.id.logo);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mysplashanimation);
        logo.startAnimation(myanim);
        final Intent i=new Intent(splash.this,MainActivity.class);
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };timer.start();
    }

}

