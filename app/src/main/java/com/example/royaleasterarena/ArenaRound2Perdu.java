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

public class ArenaRound2Perdu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arena_round2_perdu);

        final Intent intent = getIntent();
        final Warrior warrior2 = intent.getParcelableExtra("Warrior2");
        final Warrior ennemyWarrior1 = intent.getParcelableExtra("firstEnnemyWarrior");
        final Warrior ennemyWarrior2 = intent.getParcelableExtra("EnnemyWarrior2");

        final List<Warrior> warriorUser = new ArrayList<>();
        ListView listViewWarriorUser = findViewById(R.id.lvPlayer);
        final WarriorAdapter adapterUser = new WarriorAdapter(ArenaRound2Perdu.this, warriorUser);
        listViewWarriorUser.setAdapter(adapterUser);
        warriorUser.add(warrior2);

        final List<Warrior> warriorEnnemy = new ArrayList<>();
        ListView listViewWarriorEnnemy = findViewById(R.id.lvEnnemy);
        final WarriorAdapter adapterEnnemy = new WarriorAdapter(ArenaRound2Perdu.this, warriorEnnemy);
        listViewWarriorEnnemy.setAdapter(adapterEnnemy);
        warriorEnnemy.add(ennemyWarrior1);

        Button hit = findViewById(R.id.btHit);
        hit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ennemyWarrior1.setPv(ennemyWarrior1.getPv() - warrior2.getAttack());
                if ((ennemyWarrior1.getPv()>0) && (warrior2.getPv()>0)) {
                    warrior2.setPv(warrior2.getPv() - ennemyWarrior1.getAttack());
                    Intent intent = new Intent(ArenaRound2Perdu.this, ArenaRound2Perdu.class);
                    intent.putExtra("Warrior2", warrior2);
                    intent.putExtra("firstEnnemyWarrior", ennemyWarrior1);
                    intent.putExtra("EnnemyWarrior2", ennemyWarrior2);
                    startActivity(intent);
                }
                if (ennemyWarrior1.getPv() <= 0) {
                    Intent intent1 = new Intent(ArenaRound2Perdu.this, ArenaRound33.class);
                    intent.putExtra("Warrior2", warrior2);
                    intent.putExtra("EnnemyWarrior2", ennemyWarrior2);
                    Toast.makeText(ArenaRound2Perdu.this, "Vous avez gagné!", Toast.LENGTH_LONG).show();
                    startActivity(intent1);
                }
                if (warrior2.getPv() <= 0) {
                    Intent intent2 = new Intent(ArenaRound2Perdu.this, Loser.class);
                    Toast.makeText(ArenaRound2Perdu.this, "Vous avez perdu!", Toast.LENGTH_LONG).show();
                    startActivity(intent2);
                }
            }
        });

    }
}
