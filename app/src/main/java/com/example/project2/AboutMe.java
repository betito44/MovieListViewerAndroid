package com.example.project2;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class AboutMe extends AppCompatActivity {

    private Fragment1 fragment1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_me_layout);
        fragment1 = new Fragment1();
    }


    @Override
    protected void onStart() {
        super.onStart();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fragment1);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        fragmentTransaction.commit();
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
