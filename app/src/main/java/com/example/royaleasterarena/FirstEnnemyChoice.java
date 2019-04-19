package com.example.royaleasterarena;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        //final List<EggModel> eggList = intent.getParcelableArrayListExtra("eggList");

        final List<Warrior> warriorList = new ArrayList<>();
        ListView listViewWarrior = findViewById(R.id.lvUserWarriors);
        final WarriorAdapter adapter = new WarriorAdapter(FirstEnnemyChoice.this, warriorList);
        listViewWarrior.setAdapter(adapter);
        warriorList.add(warrior1);
        warriorList.add(warrior2);

        final List<Warrior> warriorListEnnemi = new ArrayList<>();
        ListView listViewWarriorennemi = findViewById(R.id.lvUserEnnemy);
        final WarriorAdapter adapterEnnemi = new WarriorAdapter(FirstEnnemyChoice.this, warriorListEnnemi);
        listViewWarriorennemi.setAdapter(adapterEnnemi);


        EasterEnnemy.extractWarriorEnnemy(FirstEnnemyChoice.this, new EasterEnnemy.WarriorEnnemyListener() {
            @Override
            public void onWarriorsEnnemy(List<Warrior> warriors) {
                warriorListEnnemi.addAll(warriors);
                adapterEnnemi.notifyDataSetChanged();
            }
        });
        listViewWarriorennemi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent intent = new Intent(FirstEnnemyChoice.this, FighterChoice.class);
                    intent.putExtra("firstWarrior", warrior1);
                    intent.putExtra("secondWarrior", warrior2);
                    Warrior ennemyWarrior1 = warriorListEnnemi.get(0);
                    Warrior ennemyWarrior2 = warriorListEnnemi.get(1);
                    intent.putExtra("firstEnnemiWarrior", ennemyWarrior1);
                    intent.putExtra("secondEnnemiWarrior", ennemyWarrior2);
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(FirstEnnemyChoice.this, FighterChoice.class);
                    intent.putExtra("firstWarrior", warrior1);
                    intent.putExtra("secondWarrior", warrior2);
                    Warrior ennemyWarrior1 = warriorListEnnemi.get(1);
                    Warrior ennemyWarrior2 = warriorListEnnemi.get(0);
                    intent.putExtra("firstEnnemiWarrior", ennemyWarrior1);
                    intent.putExtra("secondEnnemiWarrior", ennemyWarrior2);
                    startActivity(intent);
                }



            }
        });

    }
}
