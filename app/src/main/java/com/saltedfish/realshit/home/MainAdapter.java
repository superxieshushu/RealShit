package com.saltedfish.realshit.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by SaltedFish on 2018/11/19.
 * 简单描述作用
 */
public class MainAdapter extends FragmentPagerAdapter {
    private List<Fragment> mListFragment;

    public MainAdapter(FragmentManager fm, List<Fragment> listFragment) {
        super(fm);
        mListFragment = listFragment;
    }

    @Override
    public Fragment getItem(int position) {
        return mListFragment.get(position);
    }

    @Override
    public int getCount() {
        return mListFragment.size();
    }
}
