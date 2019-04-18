package com.example.royaleasterarena;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class WarriorAdapter extends ArrayAdapter<Warrior> {

    public WarriorAdapter(Context context, List<Warrior> warrior) {
        super(context, 0, warrior);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        Warrior warrior = getItem(position);

        if (null == convertView) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.warrior_view, parent, false);
        }

        ImageView warriorImage = convertView.findViewById(R.id.ivWarrior);
        TextView warriorName = convertView.findViewById(R.id.tvName);
        TextView warriorSpecies = convertView.findViewById(R.id.tvSpecies);
        TextView warriorGender = convertView.findViewById(R.id.tvGender);
        TextView warriorOrigin = convertView.findViewById(R.id.tvOrigin);
        TextView warriorPv = convertView.findViewById(R.id.tvPv);
        TextView warriorAttack = convertView.findViewById(R.id.tvAttack);

        Glide.with(convertView).load(warrior.getImage()).into(warriorImage);
        warriorName.setText(warrior.getName());
        warriorSpecies.setText("Species : " + warrior.getSpecies());
        warriorGender.setText("Gender : " + warrior.getGender());
        warriorOrigin.setText("Origin : " + warrior.getOrigin());
        warriorPv.setText("Health : " + warrior.getPv());
        warriorAttack.setText("Attack : " + warrior.getAttack());

        return convertView;

    }
}