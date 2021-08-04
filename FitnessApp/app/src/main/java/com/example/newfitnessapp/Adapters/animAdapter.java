package com.example.newfitnessapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.newfitnessapp.Models.ExerciseModel;
import com.example.newfitnessapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class animAdapter extends PagerAdapter {
    List<ExerciseModel> DataItems;
    Context context;

    public animAdapter(List<ExerciseModel> dataItems, Context context) {
        DataItems = dataItems;
        this.context = context;
    }

    @Override
    public int getCount() {
        return DataItems.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.item_anim,container,false);
        TextView name=view.findViewById(R.id.ex_Name);
        ImageView img=view.findViewById(R.id.Image);
        name.setText(DataItems.get(position).getName());
        Picasso.get().load(DataItems.get(position).getImagePath()).into(img);
        container.addView(view,0);
        return view;
    }
    public int getRealPosition(int position) {
        return position % getCount();
    }
    @Override
    public void destroyItem(@NonNull  ViewGroup container, int position, @NonNull  Object object) {
        if(position!=getCount()-1)
            container.removeView((View) object) ;
    }

    @Override
    public boolean isViewFromObject(@NonNull  View view, @NonNull Object object) {
        return (view.equals(object));
    }
}
