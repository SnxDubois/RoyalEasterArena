package com.example.royaleasterarena;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FirstEnnemyChoice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_ennemy_choice);

        Intent intent = getIntent();
        final Warrior warrior1 = intent.getParcelableExtra("firstWarrior");
        final Warrior warrior2 = intent.getParcelableExtra("secondWarrior");
        final EggModel egg1 = intent.getParcelableExtra("firstEgg");
        final EggModel egg2 = intent.getParcelableExtra("secondEgg");
        final EggModel egg3 = intent.getParcelableExtra("thirdEgg");

        final List<Warrior> warriorList = new ArrayList<>();
        ListView listViewWarrior = findViewById(R.id.lvUserWarriors);
        final WarriorAdapter adapter = new WarriorAdapter(FirstEnnemyChoice.this, warriorList);
        listViewWarrior.setAdapter(adapter);

        final List<Warrior> warriorListEnnemi = new ArrayList<>();
        ListView listViewWarriorennemi = findViewById(R.id.lvUserEnnemy);
        final WarriorAdapter adapterEnnemi = new WarriorAdapter(FirstEnnemyChoice.this, warriorListEnnemi);
        listViewWarriorennemi.setAdapter(adapterEnnemi);


        Easter.extractWarrior(FirstEnnemyChoice.this, new Easter.WarriorListener() {
            @Override
            public void onWarriors(List<Warrior> warriors) {
                warriorListEnnemi.addAll(warriors);
                adapterEnnemi.notifyDataSetChanged();
            }
        });

        warriorList.add(warrior1);
        warriorList.add(warrior2);


    }
}
