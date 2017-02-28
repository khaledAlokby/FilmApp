package com.khaled.filmapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    Movie[] TopMovies_Array;
    Context CalledContext;
    View view1;
    ViewHolder viewHolder1;

     RecyclerViewAdapter(Context CalledContext, Movie[] TopMovies_Array){

        this.TopMovies_Array = TopMovies_Array;
        this.CalledContext = CalledContext;
    }

     static class ViewHolder extends RecyclerView.ViewHolder{

         TextView MovieTitle_TextView;
         TextView MovieRating_TextView;
         TextView MoveCategories_TextView;
         TextView MovieYear_TextView;
         ImageView MoviePoster_ImageView;

         ViewHolder(View v){

             super(v);
             MovieTitle_TextView = (TextView)v.findViewById(R.id.MovieTitle_TextView);
             MovieRating_TextView = (TextView)v.findViewById(R.id.MovieRating_TextView);
             MoveCategories_TextView = (TextView)v.findViewById(R.id.MoveCategories_TextView);
             MovieYear_TextView = (TextView)v.findViewById(R.id.MovieYear_TextView);
             MoviePoster_ImageView = (ImageView) v.findViewById(R.id.MoviePoster_ImageView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        view1 = LayoutInflater.from(CalledContext).inflate(R.layout.list_item_movie,parent,false);

        viewHolder1 = new ViewHolder(view1);

        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){

        holder.MovieTitle_TextView.setText(TopMovies_Array[position].original_title);
        holder.MovieRating_TextView.setText(TopMovies_Array[position].vote_average);
        holder.MoveCategories_TextView.setText(TopMovies_Array[position].original_title);
        holder.MovieYear_TextView.setText(TopMovies_Array[position].release_date);
        Picasso.with(CalledContext).load("http://image.tmdb.org/t/p/w185//"+TopMovies_Array[position].poster_path+"?api_key=b3b1492d3e91e9f9403a2989f3031b0c").into(holder.MoviePoster_ImageView);
    }

    @Override
    public int getItemCount(){

        return TopMovies_Array.length;
    }
}
