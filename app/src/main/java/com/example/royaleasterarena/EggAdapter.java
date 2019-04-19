package com.example.royaleasterarena;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class EggAdapter extends ArrayAdapter<EggModel> {

public EggAdapter(Context context, List<EggModel> egg){
        super(context,0,egg);
        }

public android.view.View getView(int position, View convertView, ViewGroup parent) {

        EggModel eggModel=getItem(position);

        if(null==convertView) {
        convertView= LayoutInflater.from(getContext())
                .inflate(R.layout.egg_view,parent,false);
        }

        ImageView eggImage=convertView.findViewById(R.id.ivEgg);
        TextView eggName =convertView.findViewById(R.id.tvNameEgg);
        TextView caliber=convertView.findViewById(R.id.tvCaliber);
        TextView rarity=convertView.findViewById(R.id.tvRarity);
        TextView pvEgg=convertView.findViewById(R.id.tvPvEgg);

        Glide.with(convertView).load(eggModel.getImageEgg()).into(eggImage);
        eggName.setText(eggModel.getNameEgg());
        caliber.setText("Caliber : "+eggModel.getCaliber());
        rarity.setText("Rarity : "+eggModel.getRarity());
        pvEgg.setText("Healing power : "+eggModel.getPvEgg());

        return convertView;

        }

}
