package com.example.project2;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class movieFragment extends Fragment {

    public static movieFragment newInstance(int i, String t, String y, float r, String d, String s, String dir, String run)
    {
        movieFragment movieFragment = new movieFragment();
        Bundle args = new Bundle();
        args.putInt("Id", i);
        args.putString("title", t);
        args.putString("year", y);
        args.putFloat("rating", r);
        args.putString("description", d);
        args.putString("stars", s);
        args.putString("director", dir);
        args.putString("length", run);
        movieFragment.setArguments(args);
        return movieFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        Bundle args = getArguments();
        // Inflate the layout for the fragment
        final View v = inflater.inflate(R.layout.movie_fragment, container, false);
        ImageView imageView = v.findViewById(R.id.large_image);
        imageView.setImageResource(args.getInt("Id"));
        TextView yearText = v.findViewById(R.id.year);
        yearText.setText(args.getString("year"));
        TextView descriptionText = v.findViewById(R.id.title);
        descriptionText.setText(args.getString("title"));
        RatingBar ratingBar = v.findViewById(R.id.movie_rating);
        ratingBar.setRating(args.getFloat("rating"));
        TextView descriptionTxt = v.findViewById(R.id.description);
        descriptionTxt.setText(args.getString("description"));
        TextView stars = v.findViewById(R.id.stars);
        stars.setText(args.getString("stars"));
        TextView director = v.findViewById(R.id.director);
        director.setText(args.getString("director"));
        TextView run = v.findViewById(R.id.runtime);
        run.setText(args.getString("length"));
        return v;
    }

}
