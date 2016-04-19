package com.example.m14x.volleyrecyclerview_itunes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.m14x.volleyrecyclerview_itunes.Model.CustomAdapter;
import com.example.m14x.volleyrecyclerview_itunes.Model.Pojo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Pojo> content = new ArrayList<Pojo>();
    private final String CONTENT_URL = "http://itunes.apple.com/search?term=rock";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);
        getData();

    }

    private void getData() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://itunes.apple.com/search?term=rock";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {



                try {
                    JSONArray jsonArray = response.getJSONArray("results");

                    for(int i = 0; i < jsonArray.length(); i++){
                        Pojo pojo = new Pojo();
                        JSONObject object = jsonArray.getJSONObject(i);
                        pojo.setArtistName(object.optString("artistName","Unknown"));
                        pojo.setTrackName(object.optString("trackName","Unknown"));
                        pojo.setCollectionName(object.optString("collectionName","Unknown"));
                        content.add(pojo);
                        fillList();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonObjectRequest);
    }
    private void fillList() {
        CustomAdapter adapter = new CustomAdapter(getApplicationContext(),content);
        recyclerView.setAdapter(adapter);
    }
}
