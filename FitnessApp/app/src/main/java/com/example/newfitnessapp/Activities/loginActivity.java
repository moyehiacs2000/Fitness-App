package com.example.newfitnessapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.newfitnessapp.R;

public class loginActivity extends AppCompatActivity {
    private Button Regiterbtn,Loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Regiterbtn=findViewById(R.id.button_register);
        Loginbtn=findViewById(R.id.button_login);
        Regiterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginActivity.this,RegisterActivity.class));
            }
        });
        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginActivity.this,MainActivity.class));

            }
        });
    }
}