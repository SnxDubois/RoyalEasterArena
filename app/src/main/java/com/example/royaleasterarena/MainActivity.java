package com.example.royaleasterarena;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        final List<Warrior> warriorList = new ArrayList<>();
        ListView listViewWarrior = findViewById(R.id.lvWarrior);
        final WarriorAdapter adapter = new WarriorAdapter(MainActivity.this, warriorList);
        listViewWarrior.setAdapter(adapter);


            Easter.extractWarrior(MainActivity.this, new Easter.WarriorListener() {
                @Override
                public void onWarriors(List<Warrior> warriors) {
                    warriorList.addAll(warriors);
                    adapter.notifyDataSetChanged();
                }
            });

        listViewWarrior.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Warrior warrior1 = warriorList.get(position);
                Intent intent = new Intent(MainActivity.this, SecondWarrior.class);
                intent.putExtra("firstWarrior", warrior1);
                startActivity(intent);

            }
        });
    }
}
