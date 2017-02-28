package com.khaled.filmapp;

import java.util.Arrays;


public class Movie {

    String poster_path;
    boolean adult;
    String overview;
    String release_date;
    String[] genre_ids;
    String id;
    String original_title;
    String original_language;
    String title;
    String backdrop_path;
    String popularity;
    String vote_count;
    boolean video;
    String vote_average;

    public Movie(String poster_path, boolean adult, String overview, String release_date, String[] genre_ids, String id, String original_title, String original_language, String title, String backdrop_path, String popularity, String vote_count, boolean video, String vote_average) {
        this.poster_path = poster_path;
        this.adult = adult;
        this.overview = overview;
        this.release_date = release_date;
        this.genre_ids = genre_ids;
        this.id = id;
        this.original_title = original_title;
        this.original_language = original_language;
        this.title = title;
        this.backdrop_path = backdrop_path;
        this.popularity = popularity;
        this.vote_count = vote_count;
        this.video = video;
        this.vote_average = vote_average;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "poster_path='" + poster_path + '\'' +
                ", adult='" + adult + '\'' +
                ", overview='" + overview + '\'' +
                ", release_date='" + release_date + '\'' +
                ", genre_ids=" + Arrays.toString(genre_ids) +
                ", id='" + id + '\'' +
                ", original_title='" + original_title + '\'' +
                ", original_language='" + original_language + '\'' +
                ", title='" + title + '\'' +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", popularity='" + popularity + '\'' +
                ", vote_count='" + vote_count + '\'' +
                ", video='" + video + '\'' +
                ", vote_average='" + vote_average + '\'' +
                '}';
    }
}
