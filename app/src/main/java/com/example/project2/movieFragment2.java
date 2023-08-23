package com.example.project2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class movieFragment2 extends Fragment {

    public static movieFragment2 newInstance(int i)
    {
        movieFragment2 movieFragment2 = new movieFragment2();
        Bundle args = new Bundle();
        args.putInt("Id", i);
        movieFragment2.setArguments(args);
        return movieFragment2;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        Bundle args = getArguments();
        // Inflate the layout for the fragment
        final View v = inflater.inflate(R.layout.movie_poster, container, false);
        ImageView imageView = v.findViewById(R.id.movie_posterbig);
        imageView.setImageResource(args.getInt("Id"));


        return v;
    }

}
