package com.example.newfitnessapp.Activities.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chabbal.slidingdotsplash.SlidingSplashView;
import com.example.newfitnessapp.Adapters.ChallengesAdapter;
import com.example.newfitnessapp.Models.Challenges_Model;
import com.example.newfitnessapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    List<Challenges_Model> dataItems;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        ViewPager viewPager_Challenges=view.findViewById(R.id.VP_Challenges);
        dataItems=new ArrayList<>();
        Challenges_Model item1=new Challenges_Model(
        "https://images.unsplash.com/photo-1610554843876-9be9b896b2d2?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NDF8fGd5bXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
               "Loss Weight",
                "Six Week Challenge");
        dataItems.add(item1);
        Challenges_Model item2=new Challenges_Model(
                "https://images.unsplash.com/photo-1606889464198-fcb18894cf50?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NTV8fGd5bXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
                "Loss Weight",
                "Six Week Challenge");
        dataItems.add(item2);
        Challenges_Model item3=new Challenges_Model(
                "https://images.unsplash.com/photo-1581009137042-c552e485697a?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTE2fHxneW18ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
                "Loss Weight",
                "Six Week Challenge");
        dataItems.add(item3);
        ChallengesAdapter ch_Adapter=new ChallengesAdapter(dataItems,getContext());
        viewPager_Challenges.setAdapter(ch_Adapter);
        SlidingSplashView  slidingSplashView=view.findViewById(R.id.splash);
        slidingSplashView.set
        return view;
    }
}