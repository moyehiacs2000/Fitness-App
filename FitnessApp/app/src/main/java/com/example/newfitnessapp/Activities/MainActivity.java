package com.example.newfitnessapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.newfitnessapp.Activities.Fragments.HistoryFragment;
import com.example.newfitnessapp.Activities.Fragments.HomeFragment;
import com.example.newfitnessapp.Activities.Fragments.NotificationsFragment;
import com.example.newfitnessapp.Activities.Fragments.ProfileFragment;
import com.example.newfitnessapp.Activities.Fragments.SchoolFragment;
import com.example.newfitnessapp.Activities.Fragments.workFragment;
import com.example.newfitnessapp.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    Toolbar toolbar;
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mDrawerToggle;
    NavigationView navigationView;
    ConstraintLayout content;
    static final float END_SCALE=0.7f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        mDrawerLayout=findViewById(R.id.drawerLayout);
        mDrawerToggle =new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
         navigationView =findViewById(R.id.nav_view);
         content=findViewById(R.id.container);
        showFragments(new HomeFragment());
        navigationView.setCheckedItem(R.id.home);
        naviagtionDrawer();
    }

    private void naviagtionDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        animateNaviagationDrawer();

    }

    private void animateNaviagationDrawer() {
      //  mDrawerLayout.setScrimColor(getResources().getColor(R.color.nav_text));
        mDrawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //super.onDrawerSlide(drawerView, slideOffset);
                final float diffScaledoffset=slideOffset*(1-END_SCALE);
                final float offsetScale=1-diffScaledoffset;
                content.setScaleX(offsetScale);
                content.setScaleY(offsetScale);
                final float xOffset=drawerView.getWidth()*slideOffset;
                final float xOffsetDiff=content.getWidth()*diffScaledoffset/2;
                final float xTranslation=xOffset-xOffsetDiff;
                content.setTranslationX(xTranslation);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull  MenuItem item) {
        int id=item.getItemId();
        if(id ==R.id.home){
            showFragments(new HomeFragment());
        }
        if(id ==R.id.work){
            showFragments(new workFragment());
        }
        if(id ==R.id.school){
            showFragments(new SchoolFragment());
        }
        if(id ==R.id.setting){
            showFragments(new SchoolFragment());
        }
        if(id ==R.id.history){
            showFragments(new HistoryFragment());
        }
        if(id ==R.id.notification){
            showFragments(new NotificationsFragment());
        }
        if(id ==R.id.Profile){
            showFragments(new ProfileFragment());
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showFragments(Fragment fragment) {
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout,fragment);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
        super.onBackPressed();
    }
}