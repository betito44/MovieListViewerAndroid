package com.example.project2;

import android.view.View;

// interface act as contract between the activity and the adapter

public interface OnItemClickListener {
    void onItemClick(View v, int position);
    void onItemLongClick(View v, int position);
}
