package com.cespaul.employees.ui;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.cespaul.employees.R;
import com.cespaul.employees.base.BaseActivity;
import com.cespaul.employees.base.BasePresenter;
import com.cespaul.employees.ui.viewPager.MyPagerAdapter;
import com.cespaul.employees.ui.viewPager.PageFragment;
import com.google.android.material.tabs.TabLayout;

public class EmployeeActivity extends BaseActivity implements EmployeeView, PageFragment.OnFragmentInteractionListener {

    private ViewPager mPager;

    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            this.getPresenter().onViewCreated();
        } catch (Exception e) {
            e.printStackTrace();
        }

        mPager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);

        /*TabLayout tabLayout = findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(mPager, true);*/
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        try {
            this.getPresenter().onViewDestroyed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onImgButtonClick() {

    }

    @Override
    public void onExpButtonClick() {

    }

    @Override
    protected BasePresenter instantiatePresenter() {
        return new EmployeePresenter(this);
    }

    @Override
    public Context getContext() {
        return super.getContext();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
