package com.khaled.filmapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.RelativeLayout;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Movie[] TopMovies_Array;
    String TopMoviesURl = "http://api.themoviedb.org/3/discover/movie?\n" +
            "api_key=b3b1492d3e91e9f9403a2989f3031b0c&primary_release_year=2017&sort_by=popularity.desc";
    Context MyContext;
    RecyclerView recyclerView;
    RelativeLayout relativeLayout;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;
    private SharedPreferences pref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyContext = getApplicationContext();
        relativeLayout = (RelativeLayout) findViewById(R.id.relativelayout1);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);
        recylerViewLayoutManager = new LinearLayoutManager(MyContext);
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        pref = getSharedPreferences("Notes", Context.MODE_PRIVATE);
        new LoadTopMoviesArray().execute(TopMoviesURl);
    }



    private class LoadTopMoviesArray extends AsyncTask<String, String, String> {



        @Override
        protected String doInBackground(String... params) {
            String json = HTTPHandler.getUrl(params[0]);
            String moviesJson = "";
            Gson gson = new Gson();
            try {
                JSONObject o = new JSONObject(json);
                JSONArray results = o.getJSONArray("results");
                Log.d("Quiz", moviesJson = results.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            TopMovies_Array = gson.fromJson(moviesJson, Movie[].class);


            for (Movie m : TopMovies_Array){
                Log.d("movie", m.toString());
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            recyclerViewAdapter = new RecyclerViewAdapter(MyContext, TopMovies_Array);

            recyclerView.setAdapter(recyclerViewAdapter);
        }



    }
}

