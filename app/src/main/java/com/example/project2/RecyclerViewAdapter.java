package com.example.project2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Map<String, ?>> md; //lists all movies
    private List<Map<String, ?>> md_filtered; //list of filtered movies
    private OnItemClickListener onListItemClickListener = null;  //call back to the activity
    public RecyclerViewAdapter(List<Map<String, ?>> list) //constructor
    {
        md = md_filtered = list;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView movieName;
        public TextView movieYear;
        public ImageView photoMovie;
        public TextView movieDirector;
        public TextView runTime;
        public RatingBar ratings;
        public TextView ratingsnum;

        public ViewHolder(View view) {
            super(view);

            movieName = view.findViewById(R.id.title);
            movieYear = view.findViewById(R.id.year);
            photoMovie = view.findViewById(R.id.large_image);
            movieDirector = view.findViewById(R.id.director);
            runTime = view.findViewById(R.id.runtime);
            ratings = view.findViewById(R.id.movie_rating);
            ratingsnum = view.findViewById(R.id.numericalrating);


        }
    }


    public Map getItem(int i){
        return md_filtered.get(i);
    }
    public void setOnListItemClickListener(OnItemClickListener listener){
        onListItemClickListener=listener;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_list_layout, parent, false);
        final ViewHolder view_holder = new ViewHolder(v);
        v.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(onListItemClickListener!=null){
                    onListItemClickListener.onItemClick(v, view_holder.getAdapterPosition());
                }
            }
        });
        v.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(onListItemClickListener!=null)
                    onListItemClickListener.onItemLongClick(v,view_holder.getAdapterPosition());
                return true;
            }
        });
        return view_holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.movieName.setText(md_filtered.get(position).get("name").toString());
        holder.movieYear.setText(md_filtered.get(position).get("year").toString());
        holder.photoMovie.setImageResource(Integer.parseInt(md_filtered.get(position).get("image").toString()));
        holder.movieDirector.setText(md_filtered.get(position).get("director").toString());
        holder.runTime.setText(md_filtered.get(position).get("length").toString());
        holder.ratings.setRating(Float.parseFloat(md_filtered.get(position).get("rating").toString()));
        holder.ratingsnum.setText(md_filtered.get(position).get("rating").toString());


    }

    @Override
    public int getItemCount() {
        return md_filtered.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}