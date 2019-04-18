package com.example.royaleasterarena;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Egg {
    public static void extractEgg (Context context, final Egg.EggListener listener) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = "http://easteregg.wildcodeschool.fr/api/eggs/random";

        for (int i = 0; i < 3; i++) {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            List<EggModel> eggs = new ArrayList<>();
                            try {

                                //JSONObject character = response.getJSONObject(i);

                                String imageEgg = response.getString("image");
                                String nameEgg = response.getString("name");
                                String caliber = response.getString("caliber");
                                String rarity = response.getString("rarity");
                                /*String skills = response.getString("skills");

                                int attackValue = Character.getNumericValue(skills.charAt(skills.length() - 1));*/

                                EggModel egg = new EggModel(imageEgg, nameEgg, caliber, rarity, 25);
                                eggs.add(egg);


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            listener.onEggs(eggs);
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

    public interface EggListener {
        void onEggs (List<EggModel> eggs);
    }
}
