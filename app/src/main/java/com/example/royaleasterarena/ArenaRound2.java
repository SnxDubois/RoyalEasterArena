package com.example.royaleasterarena;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ArenaRound2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arena_round2);

        final Intent intent = getIntent();
        final Warrior warrior1 = intent.getParcelableExtra("firstWarrior");
        final Warrior warrior2 = intent.getParcelableExtra("Warrior2");
        final Warrior ennemyWarrior2 = intent.getParcelableExtra("EnnemyWarrior2");

        final List<Warrior> warriorUser = new ArrayList<>();
        ListView listViewWarriorUser = findViewById(R.id.lvPlayer);
        final WarriorAdapter adapterUser = new WarriorAdapter(ArenaRound2.this, warriorUser);
        listViewWarriorUser.setAdapter(adapterUser);
        warriorUser.add(warrior1);

        final List<Warrior> warriorEnnemy = new ArrayList<>();
        ListView listViewWarriorEnnemy = findViewById(R.id.lvEnnemy);
        final WarriorAdapter adapterEnnemy = new WarriorAdapter(ArenaRound2.this, warriorEnnemy);
        listViewWarriorEnnemy.setAdapter(adapterEnnemy);
        warriorEnnemy.add(ennemyWarrior2);

        Button hit = findViewById(R.id.btHit);
        hit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ennemyWarrior2.setPv(ennemyWarrior2.getPv() - warrior1.getAttack());
                if ((ennemyWarrior2.getPv()>0) && (warrior1.getPv()>0)) {
                    warrior1.setPv(warrior1.getPv() - ennemyWarrior2.getAttack());
                    Intent intent = new Intent(ArenaRound2.this, ArenaRound2.class);
                    intent.putExtra("firstWarrior", warrior1);
                    intent.putExtra("Warrior2", warrior2);
                    intent.putExtra("EnnemyWarrior2", ennemyWarrior2);
                    startActivity(intent);
                }
                if (ennemyWarrior2.getPv() <= 0) {
                    Intent intent = new Intent(ArenaRound2.this, Winner.class);
                    Toast.makeText(ArenaRound2.this, "Vous avez gagné!", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
                if (warrior1.getPv() <= 0) {
                    Intent intent = new Intent(ArenaRound2.this, ArenaRound33.class);
                    intent.putExtra("Warrior2", warrior2);
                    intent.putExtra("EnnemyWarrior2", ennemyWarrior2);
                    Toast.makeText(ArenaRound2.this, "Vous avez perdu!", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
            }
        });

    }
}
