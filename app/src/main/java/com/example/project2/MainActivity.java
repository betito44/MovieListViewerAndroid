package com.example.project2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    public ActionBarDrawerToggle actionBarDrawerToggle;
    private movieData movieData = new movieData();

    private List<Map<String,?>> moviesList;;
    private AboutMe.Fragment1 fragment1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        navigationView=(NavigationView)findViewById(R.id.navigation_view);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        navigationView.setNavigationItemSelectedListener(this);
        fragment1 = new AboutMe.Fragment1();

        // handle the toggle between the action bar and the navigation drawer
        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(this,
                drawerLayout,toolbar,
                R.string.openD,R.string.closeD){
            @Override
            public void onDrawerClosed(View drawerView){
                super.onDrawerClosed(drawerView);
                Toast toast=Toast.makeText(MainActivity.this,"NavigationDrawer Closed",Toast.LENGTH_SHORT);
                toast.show();
            }
            @Override
            public void onDrawerOpened(View drawerView){
                super.onDrawerOpened(drawerView);
                Toast toast=Toast.makeText(MainActivity.this,"NavigationDrawer Opened",Toast.LENGTH_SHORT);
                toast.show();
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id)
        {
            case R.id.item1:
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container,fragment1);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
                fragmentTransaction.commit();

                break;
            case R.id.item2:

                startActivity(new Intent(this,ViewPagerActivity.class));
                break;
            case R.id.item3:

                startActivity(new Intent(this,MasterDetailFlow.class));

                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    public static class Fragment1 extends Fragment {
        private View v;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            v= inflater.inflate(R.layout.about_me_frag, container, false);
            ImageView profilePic = (ImageView)  v.findViewById(R.id.profile_pic);
            profilePic.setImageResource(R.drawable.baseball_foreground);
            TextView school = (TextView) v.findViewById(R.id.school);
            school.setText("Syracuse University");
            TextView info = (TextView)  v.findViewById(R.id.aboutme);
            info.setText("Hello. My name is Humberto Dominguez. I am the creator of this app, and my favorite sport to play is Baseball. Hence the baseball profile pic. " +
                    "In this project we are showing a list of movies through fragments. Enjoy the app demo :)");

            return v;
        }


    }



}