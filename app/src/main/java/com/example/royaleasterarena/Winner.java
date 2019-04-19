package com.example.royaleasterarena;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.textclassifier.TextClassification;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.Response;

import org.json.JSONObject;

import static android.support.constraint.Constraints.TAG;

public class Winner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activitwinner);

        Button btWin = findViewById(R.id.btReturn);
        btWin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Winner.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button btEaster = findViewById(R.id.btEaster);
        btEaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Winner.this, EasterEgg.class);
                startActivity(intent);

            }
        });
    }
}
