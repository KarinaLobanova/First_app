package com.example.first_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    int bRange, uRange, mid;
    TextView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        bRange = intent.getIntExtra("bRange", 0);
        uRange = intent.getIntExtra("uRange", 0);

        question = findViewById(R.id.question);
        mid = (bRange + uRange) / 2;
        askQuestion();
    }

    public void askQuestion(){
        question.setText("Ваше число больше чем " + Integer.toString(mid) + " ?");
    }

    public void answYes(View view){
        if (uRange - mid != 1) {
            bRange = mid;
            mid = (bRange + uRange) / 2;
            askQuestion();
        }else {
            question.setText("Загаданное вами число: " + Integer.toString(uRange));
        }
    }

    public void answNo(View view){
        if (mid - bRange != 1) {
            uRange = mid;
            mid = (int) Math.floor((bRange + uRange) / 2);
            askQuestion();
        }else {
            question.setText("Загаданное вами число: " + Integer.toString(uRange));
        }
    }
}
