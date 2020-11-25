package com.example.musictask;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SectionPageAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragmentList=new ArrayList<>();
    private final List<String> mFragmentTitleList=new ArrayList<>();

    public void addFragment(Fragment fragment,String title){
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    public SectionPageAdapter(FragmentManager fm) {
        super(fm);
    }

    private String tabtitles[]=new String[]{"Home","Music"};
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
