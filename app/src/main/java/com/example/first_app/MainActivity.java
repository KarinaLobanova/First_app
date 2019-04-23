package com.example.first_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText bRange, uRange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bRange = findViewById(R.id.bRange);
        uRange = findViewById(R.id.uRange);
    }

    public void startGame(View view){
        if (bRange.getText().length() != 0 && uRange.getText().length() != 0) {
            int botom = Integer.parseInt(bRange.getText().toString());
            int up = Integer.parseInt(uRange.getText().toString());
            Intent intent = new Intent(this,GameActivity.class);
            intent.putExtra("bRange", botom);
            intent.putExtra("uRange", up);
            startActivity(intent);
        }
    }
}
