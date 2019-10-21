package com.cespaul.employees.ui.employee;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.cespaul.employees.ui.pages.TrainingFragment;
import com.cespaul.employees.ui.pages.ProfileFragment;
import com.cespaul.employees.ui.pages.HealthFragment;
import com.cespaul.employees.ui.pages.DisruptionsFragment;

public class EmployeePagerAdapter extends FragmentStatePagerAdapter {
    private static final int NUM_PAGES = 4;

    public EmployeePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TrainingFragment();
            case 1:
                return new ProfileFragment();
            case 2:
                return new HealthFragment();
            case 3:
                return new DisruptionsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }


}
