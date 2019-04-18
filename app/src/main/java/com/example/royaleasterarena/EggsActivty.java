package com.example.royaleasterarena;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EggsActivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eggs_activty);

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

        listViewEggs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EggModel egg1 = eggModelList.get(0);
                EggModel egg2 = eggModelList.get(1);
                EggModel egg3 = eggModelList.get(2);

                /*Intent intent = new Intent(EggsActivty.this, SecondWarrior.class);
                intent.putExtra("firstEgg", egg1);
                intent.putExtra("secondEgg", egg2);
                intent.putExtra("thirdEgg", egg3);
                startActivity(intent);*/

            }
        });

    }
}
