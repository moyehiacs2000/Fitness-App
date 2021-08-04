package com.example.newfitnessapp.Activities.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.viewpagerdots.DotsIndicator;
import com.chabbal.slidingdotsplash.SlidingSplashView;
import com.example.newfitnessapp.Adapters.ChallengesAdapter;
import com.example.newfitnessapp.Adapters.ProgramsAdapter;
import com.example.newfitnessapp.Adapters.animAdapter;
import com.example.newfitnessapp.Animation.HorizontalStackTransformerWithRotation;
import com.example.newfitnessapp.Models.Challenges_Model;
import com.example.newfitnessapp.Models.ExerciseModel;
import com.example.newfitnessapp.Models.PogramModel;
import com.example.newfitnessapp.R;

import java.util.ArrayList;
import java.util.List;
import android.os.Handler;
import android.view.animation.AccelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
   private  List<Challenges_Model> Challenges_dataItems;
   private List<PogramModel>Programs_dataItems;
   private  ChallengesAdapter ch_Adapter;
   private ProgramsAdapter programsAdapter;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        ViewPager viewPager_Challenges=view.findViewById(R.id.VP_Challenges);
        final RecyclerView RV_Programs=view.findViewById(R.id.RV_Program);
        Challenges_dataItems=new ArrayList<>();
        Challenges_Model item1=new Challenges_Model(
        "https://images.unsplash.com/photo-1610554843876-9be9b896b2d2?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NDF8fGd5bXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
               "Loss Weight",
                "Loss Weight Six Week Challenge");
        Challenges_dataItems.add(item1);
        Challenges_Model item2=new Challenges_Model(
                "https://images.unsplash.com/photo-1606889464198-fcb18894cf50?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NTV8fGd5bXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
                "Loss Weight",
                "Loss Weight Six Week Challenge");
        Challenges_dataItems.add(item2);
        Challenges_Model item3=new Challenges_Model(
                "https://images.unsplash.com/photo-1581009137042-c552e485697a?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTE2fHxneW18ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
                "Loss Weight",
                "Loss Weight Six Week Challenge");
        Challenges_dataItems.add(item3);
         ch_Adapter=new ChallengesAdapter(Challenges_dataItems,getContext());
        viewPager_Challenges.setAdapter(ch_Adapter);
        DotsIndicator dots=view.findViewById(R.id.dots);
        dots.attachViewPager(viewPager_Challenges);
        Programs_dataItems=new ArrayList<>();
        PogramModel p1=new PogramModel("Powerfull Chest","https://media.istockphoto.com/photos/muscular-man-standing-in-the-gym-picture-id998035336?k=6&m=998035336&s=612x612&w=0&h=er4PMIHZTuJcmBxIn_PKUIJu7vdHC6LIBmawmMayGYY=");
        Programs_dataItems.add(p1);
        PogramModel p2=new PogramModel("Wide Back","https://media.istockphoto.com/photos/strong-muscular-back-picture-id618210004?k=6&m=618210004&s=612x612&w=0&h=Y1_lkogLooZcwu7IePCLLH8rG-e67trgWJcfAk5Uoy4=");
        Programs_dataItems.add(p2);
        PogramModel p3=new PogramModel("Arm","https://media.istockphoto.com/photos/bodybuilder-performing-power-lift-curl-picture-id181894126?k=6&m=181894126&s=612x612&w=0&h=LLgSysauJo95bv0kjKWVHxL94mluhtpB0_B29m-lAQE=");
        Programs_dataItems.add(p3);
        PogramModel p4=new PogramModel("Big Shoulder","https://images.pexels.com/photos/7289367/pexels-photo-7289367.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500");;
        Programs_dataItems.add(p4);
        PogramModel p5=new PogramModel("6 Pack Abs","https://www.posture-works.com/wp-content/uploads/2017/07/Posture-Works-strong-abs-strong-posture-back.jpg");
        Programs_dataItems.add(p5);
        PogramModel p6=new PogramModel("Strong Leg","https://i1.wp.com/www.strengthlog.com/wp-content/uploads/2020/11/Quad-muscle-exercises.jpg?fit=1600%2C1065&ssl=1");
        Programs_dataItems.add(p6);
        programsAdapter=new ProgramsAdapter(Programs_dataItems,getContext());
        RV_Programs.setHasFixedSize(true);
        final RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        RV_Programs.setLayoutManager(layoutManager);
        RV_Programs.setAdapter(programsAdapter);
        RV_Programs.setPadding(30,20,30,40);
        final SnapHelper snapHelper=new LinearSnapHelper() ;
        snapHelper.attachToRecyclerView(RV_Programs);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                RecyclerView.ViewHolder viewHolder=RV_Programs.findViewHolderForAdapterPosition(0);
                ConstraintLayout rl1=viewHolder.itemView.findViewById(R.id.rl1);
                rl1.animate().scaleY(1).scaleX(1).setDuration(350).setInterpolator(new AccelerateInterpolator()).start();
            }
        },100);
        RV_Programs.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                View v=snapHelper.findSnapView(layoutManager);
                int pos=layoutManager.getPosition(v);
                RecyclerView.ViewHolder viewHolder =RV_Programs.findViewHolderForAdapterPosition(pos);
                ConstraintLayout rl1=viewHolder.itemView.findViewById(R.id.rl1);
                if(newState==RecyclerView.SCROLL_STATE_IDLE){
                    rl1.animate().setDuration(350).scaleX(1).scaleY(1).setInterpolator(new AccelerateInterpolator()).start();
                }
                else{
                    rl1.animate().setDuration(350).scaleX(0.85f).scaleY(0.85f).setInterpolator(new AccelerateInterpolator()).start();
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        ViewPager viewPager=view.findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setRotationY(180);
        viewPager.setPageTransformer(false,new HorizontalStackTransformerWithRotation(viewPager));
        List<ExerciseModel> data=new ArrayList<>();
        ExerciseModel ex=new ExerciseModel("Chest","https://images.unsplash.com/photo-1507398941214-572c25f4b1dc?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzJ8fGd5bXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60");
        data.add(ex);
        ex=new ExerciseModel("Chest","https://images.unsplash.com/photo-1596357395217-80de13130e92?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mzd8fGd5bXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60");
        data.add(ex);
        ex=new ExerciseModel("leg","https://images.unsplash.com/photo-1610554843876-9be9b896b2d2?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NDB8fGd5bXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60");
        data.add(ex);
        ex=new ExerciseModel("Abs","https://images.unsplash.com/photo-1597452485669-2c7bb5fef90d?ixid=MnwxMjA3fDB8MHxzZWFyY2h8ODN8fGd5bXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60");
        data.add(ex);
        ex=new ExerciseModel("Back","https://images.unsplash.com/photo-1585892478508-130c50eb7a69?ixid=MnwxMjA3fDB8MHxzZWFyY2h8OTF8fGd5bXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60");
        data.add(ex);
        ex=new ExerciseModel("Arm","https://images.unsplash.com/photo-1601422407692-ec4eeec1d9b3?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTEwfHxneW18ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60");
        data.add(ex);
        viewPager.setAdapter(new animAdapter(data,getContext()));
        return view;
    }
}
//https://media.istockphoto.com/photos/muscular-man-standing-in-the-gym-picture-id998035336?k=6&m=998035336&s=612x612&w=0&h=er4PMIHZTuJcmBxIn_PKUIJu7vdHC6LIBmawmMayGYY=