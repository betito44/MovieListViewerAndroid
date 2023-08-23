package com.example.project2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class MovieParser extends Fragment {

    public static final String ARG_TITLE = "title";
    public static final String ARG_YEAR = "year";
    public static final String ARG_POSTER = "poster";
    public static final String ARG_STARS = "stars";
    public static final String ARG_DIRECTOR = "director";
    public static final String ARG_RUNTIME = "length";
    public static final String ARG_RATING = "rating";






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.movie_fragment, container, false);
        Bundle args = getArguments();
        ((TextView) rootView.findViewById(R.id.title)).setText(args.getString(ARG_TITLE));
        ((TextView) rootView.findViewById(R.id.year)).setText(args.getString(ARG_YEAR));
        ((ImageView) rootView.findViewById(R.id.large_image)).setImageResource(args.getInt(ARG_POSTER));
        ((TextView) rootView.findViewById(R.id.description)).setText(args.getString("mdesc"));
        ((TextView) rootView.findViewById(R.id.stars)).setText(args.getString(ARG_STARS));
        ((TextView) rootView.findViewById(R.id.director)).setText(args.getString(ARG_DIRECTOR));
        ((TextView) rootView.findViewById(R.id.runtime)).setText(args.getString(ARG_RUNTIME));
        ((RatingBar) rootView.findViewById(R.id.movie_rating)).setRating(args.getFloat(ARG_RATING));



        return rootView;
    }

}
