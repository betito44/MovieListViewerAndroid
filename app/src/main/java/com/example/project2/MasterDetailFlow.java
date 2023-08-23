package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;

import android.view.View;
import android.widget.LinearLayout;

import java.util.Map;

public class MasterDetailFlow extends AppCompatActivity {

    private boolean twoPane;


    private RecyclerView recycler_view;
    private movieData md=new movieData();
    private final RecyclerViewAdapter myRecyclerAdapter= new
            RecyclerViewAdapter(md.getMoviesList());

    private final RecyclerViewAdapter2 myRecyclerAdapter2= new
            RecyclerViewAdapter2(md.getMoviesList());

    private final RecyclerViewAdapter3 myRecyclerAdapter3= new
            RecyclerViewAdapter3(md.getMoviesList());




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_detail);
        if(savedInstanceState==null) // check if this the first time the application is being created
        {
        }
    }


    @Override
    protected void onStart() {

        super.onStart();

        MasterDetailFlow contextSaver = this;
        recycler_view = (RecyclerView) findViewById(R.id.list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        recycler_view.setLayoutManager(layoutManager);
        myRecyclerAdapter.setOnListItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                if (twoPane) {

                    Map hashMap = myRecyclerAdapter2.getItem(position);
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    movieFragment movieDetailFragment = movieFragment.newInstance((int)hashMap.get("image"),
                            hashMap.get("name").toString(), hashMap.get("year").toString(),
                            Float.parseFloat(hashMap.get("rating").toString()), hashMap.get("description").toString(), hashMap.get("stars").toString(),
                            hashMap.get("director").toString(), hashMap.get("length").toString());
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.info2,movieDetailFragment)
                            .commit();

                    Map hashMap2 = myRecyclerAdapter3.getItem(position);
                    FragmentManager fragmentManager2 = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();

                    movieFragment2 movieDetailFragment2 = movieFragment2.newInstance((int)hashMap2.get("image"));
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.info,movieDetailFragment2)
                            .commit();



                }
                else {


                        Map hashMap = myRecyclerAdapter2.getItem(position);
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                        movieFragment movieDetailFragment = movieFragment.newInstance((int)hashMap.get("image"),
                                hashMap.get("name").toString(), hashMap.get("year").toString(),
                                Float.parseFloat(hashMap.get("rating").toString()), hashMap.get("description").toString(), hashMap.get("stars").toString(),
                                hashMap.get("director").toString(), hashMap.get("length").toString());

                        recycler_view = (RecyclerView) findViewById(R.id.list);
                        recycler_view.setVisibility(View.INVISIBLE);


                        LinearLayout constraintView = (LinearLayout) findViewById(R.id.pager);
                        constraintView.setVisibility(View.VISIBLE);

                        getSupportFragmentManager().beginTransaction()
                            .replace(R.id.pager,movieDetailFragment)
                            .commit();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            recycler_view.setVisibility(View.VISIBLE);
                            constraintView.setVisibility(View.INVISIBLE);

                        }
                    }, 5000);


                }

            }

            @Override
            public void onItemLongClick(View v, int position) {


                if (twoPane) {


                    Map hashMap = myRecyclerAdapter2.getItem(position);
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    movieFragment movieDetailFragment = movieFragment.newInstance((int)hashMap.get("image"),
                            hashMap.get("name").toString(), hashMap.get("year").toString(),
                            Float.parseFloat(hashMap.get("rating").toString()), hashMap.get("description").toString(), hashMap.get("stars").toString(),
                            hashMap.get("director").toString(), hashMap.get("length").toString());
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.info2,movieDetailFragment)
                            .commit();

                    //portion commented out because i thought it was cool having different movie posters up
                    /*
                                        Map hashMap2 = myRecyclerAdapter3.getItem(position);
                    FragmentManager fragmentManager2 = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();

                    movieFragment2 movieDetailFragment2 = movieFragment2.newInstance((int)hashMap2.get("image"));
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.info,movieDetailFragment2)
                            .commit();

                     */

                } else {



                    Map hashMap = myRecyclerAdapter2.getItem(position);
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    movieFragment movieDetailFragment = movieFragment.newInstance((int)hashMap.get("image"),
                            hashMap.get("name").toString(), hashMap.get("year").toString(),
                            Float.parseFloat(hashMap.get("rating").toString()), hashMap.get("description").toString(), hashMap.get("stars").toString(),
                            hashMap.get("director").toString(), hashMap.get("length").toString());

                    recycler_view = (RecyclerView) findViewById(R.id.list);
                    recycler_view.setVisibility(View.INVISIBLE);


                    LinearLayout constraintView = (LinearLayout) findViewById(R.id.pager);
                    constraintView.setVisibility(View.VISIBLE);

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.pager,movieDetailFragment)
                            .commit();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            recycler_view.setVisibility(View.VISIBLE);
                            constraintView.setVisibility(View.INVISIBLE);

                        }
                    }, 5000);


                }

            }
        });


        recycler_view.setAdapter(myRecyclerAdapter);
        recycler_view.setItemAnimator(new DefaultItemAnimator());

        twoPane = false;
        if (findViewById(R.id.info) != null) {
            twoPane = true;
        }
    }




}