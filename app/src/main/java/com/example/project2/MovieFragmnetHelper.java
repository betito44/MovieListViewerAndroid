package com.example.project2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;
import java.util.Map;

public class MovieFragmnetHelper extends FragmentStateAdapter {


    List<Map<String, ?>> list_movie;

    //constructor for the class
    public MovieFragmnetHelper(FragmentActivity fa,
                                      List<Map<String, ?>> list_m ) {

        super(fa);
        this.list_movie=list_m;
    }



    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = new MovieParser();
        Bundle args = new Bundle();
        args.putString(MovieParser.ARG_TITLE, list_movie.get(position).get("name").toString());
        args.putString(MovieParser.ARG_YEAR, list_movie.get(position).get("year").toString());
        args.putInt(MovieParser.ARG_POSTER,Integer.parseInt(list_movie.get(position).get("image").toString()));
        args.putString("mdesc",list_movie.get(position).get("description").toString());
        args.putString(MovieParser.ARG_STARS,list_movie.get(position).get("stars").toString());
        args.putString(MovieParser.ARG_DIRECTOR,list_movie.get(position).get("director").toString());
        args.putString(MovieParser.ARG_RUNTIME,list_movie.get(position).get("length").toString());
        args.putFloat(MovieParser.ARG_RATING,Float.parseFloat(list_movie.get(position).get("rating").toString()));

        fragment.setArguments(args);
        return fragment;    }

    @Override
    public int getItemCount() {
        return list_movie.size();
    }
}
