package com.example.newfitnessapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.newfitnessapp.R;

public class Splash extends AppCompatActivity {
    TextView TV_Moyehiacs,TV_Gym,Quote;
    Animation frombottom,fromrighttoleft,fromlefttoright;
    View Line;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TV_Moyehiacs=findViewById(R.id.AppName);
        TV_Gym=findViewById(R.id.tv_Gym);
        Quote=findViewById(R.id.Quote);
        Line=findViewById(R.id.line);
        frombottom= AnimationUtils.loadAnimation(this,R.anim.frombottom);
        fromlefttoright=AnimationUtils.loadAnimation(this,R.anim.fromlefttoright);
        fromrighttoleft=AnimationUtils.loadAnimation(this,R.anim.fromrighttoleft);
        TV_Moyehiacs.setAnimation(fromrighttoleft);
        TV_Gym.setAnimation(fromlefttoright);
        Quote.setAnimation(frombottom);
        Line.animate().scaleX(1).setDuration(2000).start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash.this,loginActivity.class));
                finish();
            }
        },4000);
    }
}