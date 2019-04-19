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

public class Arena extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arena);

        final Intent intent = getIntent();
        final Warrior warrior1 = intent.getParcelableExtra("firstWarrior");
        final Warrior warrior2 = intent.getParcelableExtra("Warrior2");
        final Warrior ennemyWarrior1 = intent.getParcelableExtra("firstEnnemyWarrior");
        final Warrior ennemyWarrior2 = intent.getParcelableExtra("EnnemyWarrior2");

        final List<Warrior> warriorUser = new ArrayList<>();
        ListView listViewWarriorUser = findViewById(R.id.lvPlayer);
        final WarriorAdapter adapterUser = new WarriorAdapter(Arena.this, warriorUser);
        listViewWarriorUser.setAdapter(adapterUser);
        warriorUser.add(warrior1);

        final List<Warrior> warriorEnnemy = new ArrayList<>();
        ListView listViewWarriorEnnemy = findViewById(R.id.lvEnnemy);
        final WarriorAdapter adapterEnnemy = new WarriorAdapter(Arena.this, warriorEnnemy);
        listViewWarriorEnnemy.setAdapter(adapterEnnemy);
        warriorEnnemy.add(ennemyWarrior1);

        Button hit = findViewById(R.id.btHit);
        hit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ennemyWarrior1.setPv(ennemyWarrior1.getPv() - warrior1.getAttack());
                if ((ennemyWarrior1.getPv()>0) && (warrior1.getPv()>0)) {
                    warrior1.setPv(warrior1.getPv() - ennemyWarrior1.getAttack());
                    Intent intent = new Intent(Arena.this, Arena.class);
                    intent.putExtra("firstWarrior", warrior1);
                    intent.putExtra("Warrior2", warrior2);
                    intent.putExtra("firstEnnemyWarrior", ennemyWarrior1);
                    intent.putExtra("EnnemyWarrior2", ennemyWarrior2);
                    startActivity(intent);
                }
                if (ennemyWarrior1.getPv() <= 0) {
                    Intent intent = new Intent(Arena.this, ArenaRound2.class);
                    intent.putExtra("firstWarrior", warrior1);
                    intent.putExtra("Warrior2", warrior2);
                    intent.putExtra("EnnemyWarrior2", ennemyWarrior2);
                    Toast.makeText(Arena.this, "Vous avez gagné!", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
                if (warrior1.getPv() <= 0) {
                    Intent intent = new Intent(Arena.this, ArenaRound2Perdu.class);
                    intent.putExtra("Warrior2", warrior2);
                    intent.putExtra("firstEnnemyWarrior", ennemyWarrior1);
                    intent.putExtra("EnnemyWarrior2", ennemyWarrior2);
                    Toast.makeText(Arena.this, "Vous avez perdu!", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
            }
        });

    }
}
