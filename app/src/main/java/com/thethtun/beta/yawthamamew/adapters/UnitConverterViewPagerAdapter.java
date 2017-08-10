package com.thethtun.beta.yawthamamew.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beta on 8/9/17.
 */

public class UnitConverterViewPagerAdapter extends BaseViewPagerAdapter {

    private List<Fragment> fragments;
    private List<String> fragmentTitles;

    public UnitConverterViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<>();
        fragmentTitles = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitles.get(position);
    }

    public void addTab(Fragment fragment, String pageTitle){
        fragments.add(fragment);
        fragmentTitles.add(pageTitle);
    }
}
