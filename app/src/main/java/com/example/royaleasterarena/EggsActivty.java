package com.example.royaleasterarena;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EggsActivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eggs_activty);

        Intent intent = getIntent();
        final Warrior warrior1 = intent.getParcelableExtra("firstWarrior");
        final Warrior warrior2 = intent.getParcelableExtra("secondWarrior");

        final List<EggModel> eggModelList = new ArrayList<>();
        ListView listViewEggs = findViewById(R.id.lvEggs);
        final EggAdapter adapter = new EggAdapter(EggsActivty.this, eggModelList);
        listViewEggs.setAdapter(adapter);


        Egg.extractEgg(EggsActivty.this, new Egg.EggListener() {
            @Override
            public void onEggs (List<EggModel> eggs) {
                eggModelList.addAll(eggs);
                adapter.notifyDataSetChanged();
            }
        });

        Button button = findViewById(R.id.btAgree);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EggModel egg1 = eggModelList.get(0);
                EggModel egg2 = eggModelList.get(1);
                EggModel egg3 = eggModelList.get(2);
                final List<EggModel> eggList = new ArrayList<>();
                eggList.add(egg1);
                eggList.add(egg2);
                eggList.add(egg3);

                Intent intent = new Intent(EggsActivty.this, FirstEnnemyChoice.class);
                intent.putExtra("firstWarrior", warrior1);
                intent.putExtra("secondWarrior", warrior2);
                //intent.putParcelableArrayListExtra("eggList", (ArrayList<? extends Parcelable>) eggList);
                startActivity(intent);

            }
        });

    }
}
