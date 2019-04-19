package com.example.royaleasterarena;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FighterChoice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fighter_choice);

        Intent intent = getIntent();
        final Warrior warrior1 = intent.getParcelableExtra("firstWarrior");
        final Warrior warrior2 = intent.getParcelableExtra("secondWarrior");
        final Warrior ennemyWarrior1 = intent.getParcelableExtra("firstEnnemiWarrior");
        final Warrior ennemyWarrior2 = intent.getParcelableExtra("secondEnnemiWarrior");

        final List<Warrior> warriorListCombattant = new ArrayList<>();
        ListView listViewWarriorCombattant = findViewById(R.id.lvFighterChoice);
        final WarriorAdapter adapterCombattant = new WarriorAdapter(FighterChoice.this, warriorListCombattant);
        listViewWarriorCombattant.setAdapter(adapterCombattant);
        warriorListCombattant.add(warrior1);
        warriorListCombattant.add(warrior2);

        final List<Warrior> warriorListEnnemy = new ArrayList<>();
        ListView listViewEnnemy = findViewById(R.id.lvChoiceEnnemy);
        final WarriorAdapter adapterEnnemy = new WarriorAdapter(FighterChoice.this, warriorListEnnemy);
        listViewEnnemy.setAdapter(adapterEnnemy);
        warriorListEnnemy.add(ennemyWarrior1);

        listViewWarriorCombattant.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent intent = new Intent(FighterChoice.this, Arena.class);
                    Warrior warrior1 = warriorListCombattant.get(0);
                    Warrior warrior2 = warriorListCombattant.get(1);
                    intent.putExtra("firstWarrior", warrior1);
                    intent.putExtra("Warrior2", warrior2);
                    intent.putExtra("firstEnnemyWarrior", ennemyWarrior1);
                    intent.putExtra("EnnemyWarrior2", ennemyWarrior2);
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(FighterChoice.this, Arena.class);
                    Warrior warrior1 = warriorListCombattant.get(1);
                    Warrior warrior2 = warriorListCombattant.get(0);
                    intent.putExtra("firstWarrior", warrior1);
                    intent.putExtra("Warrior2", warrior2);
                    intent.putExtra("firstEnnemyWarrior", ennemyWarrior1);
                    intent.putExtra("EnnemyWarrior2", ennemyWarrior2);
                    startActivity(intent);
                }
            }
        });

    }
}
