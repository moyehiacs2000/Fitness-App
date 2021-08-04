package com.example.newfitnessapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.afollestad.viewpagerdots.DotsIndicator;
import com.example.newfitnessapp.Models.*;
import com.example.newfitnessapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ChallengesAdapter extends PagerAdapter {

    List<Challenges_Model> DataItems;
    Context context;
    public ChallengesAdapter(List<Challenges_Model> dataItems, Context context) {
        DataItems = dataItems;
        this.context = context;
    }

    @Override
    public int getCount() {
        return DataItems.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull  ViewGroup container, int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.vp_challenges_item,container,false);
        ImageView Ch_Image=view.findViewById(R.id.VP_Challenges_item_Image);
        TextView Ch_Desc=view.findViewById(R.id.VP_Challenges_Weeks);
        Picasso.get().load(DataItems.get(position).getChallenge_Img()).into(Ch_Image);
       // Ch_Name.setText(DataItems.get(position).getChallenge_Type());
        Ch_Desc.setText(DataItems.get(position).getChallenge_Desc());
        container.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull  ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object) ;
    }

    @Override
    public boolean isViewFromObject(@NonNull  View view, @NonNull Object object) {
        return (view.equals(object));
    }
}
