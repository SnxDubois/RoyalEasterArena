package com.example.royaleasterarena;

import android.content.Context;
import android.location.Location;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Easter {

    public static void extractWarrior(Context context, final WarriorListener listener) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = "http://easteregg.wildcodeschool.fr/api/characters/random";

        for(int i = 0; i<3; i++) {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            List<Warrior> warriors = new ArrayList<>();
                            try {

                                //JSONObject character = response.getJSONObject(i);

                                String image = response.getString("image");
                                String name = response.getString("name");
                                String species = response.getString("species");
                                String gender = response.getString("gender");
                                String origin = response.getString("origin");
                                JSONArray skills = response.getJSONArray("skills");

                                int attackCompteur = 0;
                                for (int j = 0; j < skills.length(); j++) {

                                    String attackSkill = skills.getString(j);
                                    int attackValue = Character.getNumericValue(attackSkill.charAt(attackSkill.length() - 1));
                                    attackCompteur = attackCompteur + attackValue;
                                }

                                int attack = attackCompteur;
                                Warrior warrior = new Warrior(image, name, species, gender, origin, 25, attack);
                                warriors.add(warrior);


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            listener.onWarriors(warriors);

                        }
                    },
                    new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // Afficher l'erreur
                            Log.d("VOLLEY_ERROR", "onErrorResponse: " + error.getMessage());
                        }
                    }
            );

            requestQueue.add(jsonObjectRequest);
        }
    }
    public interface WarriorListener {
        void onWarriors (List<Warrior> warriors);
    }
}
