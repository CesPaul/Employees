package com.cespaul.employees.ui.viewPager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.cespaul.employees.ui.pages.Page1Fragment;
import com.cespaul.employees.ui.pages.Page2Fragment;
import com.cespaul.employees.ui.pages.Page3Fragment;
import com.cespaul.employees.ui.pages.Page4Fragment;

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    private static final int NUM_PAGES = 4;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Page1Fragment();
            case 1:
                return new Page2Fragment();
            case 2:
                return new Page3Fragment();
            case 3:
                return new Page4Fragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }


}
