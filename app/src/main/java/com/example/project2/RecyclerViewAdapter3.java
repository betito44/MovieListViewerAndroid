package com.example.project2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project2.OnItemClickListener;
import com.example.project2.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RecyclerViewAdapter3 extends RecyclerView.Adapter<com.example.project2.RecyclerViewAdapter2.ViewHolder> {

    private List<Map<String, ?>> md; //lists all movies
    private List<Map<String, ?>> md_filtered; //list of filtered movies
    private OnItemClickListener onListItemClickListener = null;  //call back to the activity

    public RecyclerViewAdapter3(List<Map<String, ?>> list) //constructor
    {
        md = md_filtered = list;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView photoMovie;


        public ViewHolder(View view) {
            super(view);


            photoMovie = view.findViewById(R.id.movie_posterbig);


        }
    }


    public Map getItem(int i) {
        return md_filtered.get(i);
    }

    public void setOnListItemClickListener(OnItemClickListener listener) {
        onListItemClickListener = listener;
    }

    @Override
    public com.example.project2.RecyclerViewAdapter2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_poster, parent, false);
        final com.example.project2.RecyclerViewAdapter2.ViewHolder view_holder = new com.example.project2.RecyclerViewAdapter2.ViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onListItemClickListener != null) {
                    onListItemClickListener.onItemClick(v, view_holder.getAdapterPosition());
                }
            }
        });
        v.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onListItemClickListener != null)
                    onListItemClickListener.onItemLongClick(v, view_holder.getAdapterPosition());
                return true;
            }
        });
        return view_holder;
    }

    @Override
    public void onBindViewHolder(com.example.project2.RecyclerViewAdapter2.ViewHolder holder, int position) {
        holder.photoMovie.setImageResource(Integer.parseInt(md_filtered.get(position).get("image").toString()));

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

