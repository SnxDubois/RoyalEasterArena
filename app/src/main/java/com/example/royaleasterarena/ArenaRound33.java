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

public class ArenaRound33 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arena_round33);

        final Intent intent = getIntent();
        final Warrior warrior2 = intent.getParcelableExtra("Warrior2");
        final Warrior ennemyWarrior2 = intent.getParcelableExtra("EnnemyWarrior2");

        final List<Warrior> warriorUser33 = new ArrayList<>();
        ListView listViewWarriorUser33 = findViewById(R.id.lvPlayer33);
        final WarriorAdapter adapterUser33 = new WarriorAdapter(ArenaRound33.this, warriorUser33);
        listViewWarriorUser33.setAdapter(adapterUser33);
        warriorUser33.add(warrior2);

        final List<Warrior> warriorEnnemy33 = new ArrayList<>();
        ListView listViewWarriorEnnemy33 = findViewById(R.id.lvEnnemy33);
        final WarriorAdapter adapterEnnemy33 = new WarriorAdapter(ArenaRound33.this, warriorEnnemy33);
        listViewWarriorEnnemy33.setAdapter(adapterEnnemy33);
        warriorEnnemy33.add(ennemyWarrior2);

        Button hit = findViewById(R.id.btHit33);
        hit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ennemyWarrior2.setPv(ennemyWarrior2.getPv() - warrior2.getAttack());
                if ((ennemyWarrior2.getPv()>0) && (warrior2.getPv()>0)) {
                    warrior2.setPv(warrior2.getPv() - ennemyWarrior2.getAttack());
                    Intent intent = new Intent(ArenaRound33.this, ArenaRound33.class);
                    intent.putExtra("Warrior2", warrior2);
                    intent.putExtra("EnnemyWarrior2", ennemyWarrior2);
                    startActivity(intent);
                }
                if (ennemyWarrior2.getPv() <= 0) {
                    Intent intent1 = new Intent(ArenaRound33.this, Winner.class);
                    Toast.makeText(ArenaRound33.this, "Vous avez gagné!", Toast.LENGTH_LONG).show();
                    startActivity(intent1);
                }
                if (warrior2.getPv() <= 0) {
                    Intent intent2 = new Intent(ArenaRound33.this, Loser.class);
                    Toast.makeText(ArenaRound33.this, "Vous avez perdu!", Toast.LENGTH_LONG).show();
                    startActivity(intent2);
                }
            }
        });
    }

}
