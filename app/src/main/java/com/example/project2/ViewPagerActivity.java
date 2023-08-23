package com.example.project2;

import android.os.Bundle;
import android.widget.FrameLayout;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;
import java.util.Map;

public class ViewPagerActivity extends AppCompatActivity {


    ViewPager2 mViewPager;
    FrameLayout frameLayout;
    private List<Map<String, ?>> md_list;
    private movieData md = new movieData();
    MovieFragmnetHelper movieFragmnetHelper;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container_task2);

        //stores movie lists data
        md_list = md.getMoviesList();


        movieFragmnetHelper =new MovieFragmnetHelper(this,md_list);
        mViewPager = (ViewPager2) findViewById(R.id.pager);
        mViewPager.setAdapter(movieFragmnetHelper);




        TabLayout tabLayout=(TabLayout)findViewById(R.id.tabs);
        new TabLayoutMediator(tabLayout, mViewPager,
                (tab, position) -> tab.setText(md_list.get(position).get("name").toString())
        ).attach();

    }
}
