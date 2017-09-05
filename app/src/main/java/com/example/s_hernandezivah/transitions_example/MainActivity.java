package com.example.s_hernandezivah.transitions_example;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    View circle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btn = (Button) findViewById(R.id.btn);
        circle = findViewById(R.id.circle);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,NextActivity.class);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this,
                new Pair<>(circle, ViewCompat.getTransitionName(circle))).toBundle());
    }
}
