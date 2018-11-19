package com.saltedfish.realshit.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.saltedfish.realshit.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private BottomNavigationView mNav;

    private List<Fragment> mFragmentList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        initView();
        addListener();
    }

    private void findView() {
        mNav = findViewById(R.id.nav);
        mViewPager = findViewById(R.id.vp);
    }

    private void initView() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new AndroidFragment());
        mFragmentList.add(new AndroidFragment());
        mFragmentList.add(new AndroidFragment());
        mViewPager.setAdapter(new MainAdapter(getSupportFragmentManager(), mFragmentList));
        mViewPager.setOffscreenPageLimit(2);
    }

    private void addListener() {
        mNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_benefit:
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.menu_android:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.menu_ios:
                        mViewPager.setCurrentItem(0);
                        break;

                }
                return true;
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position,
                                       float positionOffset,
                                       int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mNav.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
