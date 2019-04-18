package com.example.royaleasterarena;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SecondWarrior extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_warrior);

        Intent firstWarrior = getIntent();
        firstWarrior.getParcelableExtra("firstWarrior");

        final List<Warrior> warriorList = new ArrayList<>();
        ListView listViewWarrior = findViewById(R.id.lvSecondWarrior);
        final WarriorAdapter adapter = new WarriorAdapter(SecondWarrior.this, warriorList);
        listViewWarrior.setAdapter(adapter);


        Easter.extractWarrior(SecondWarrior.this, new Easter.WarriorListener() {
            @Override
            public void onWarriors(List<Warrior> warriors) {
                warriorList.addAll(warriors);
                adapter.notifyDataSetChanged();
            }
        });

        listViewWarrior.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Warrior warrior2 = warriorList.get(position);
                Intent intent = new Intent(SecondWarrior.this, EggsActivty.class);
                intent.putExtra("secondWarrior", warrior2);
                startActivity(intent);

            }
        });
    }
}
