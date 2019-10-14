package com.cespaul.employees.ui;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import com.cespaul.employees.R;
import com.cespaul.employees.base.BaseActivity;
import com.cespaul.employees.base.BasePresenter;
import com.cespaul.employees.ui.pages.Page1Fragment;
import com.cespaul.employees.ui.pages.Page3Fragment;
import com.cespaul.employees.ui.pages.Page4Fragment;
import com.cespaul.employees.ui.viewPager.MyPagerAdapter;
import com.cespaul.employees.ui.pages.Page2Fragment;

public class EmployeeActivity
        extends BaseActivity
        implements EmployeeView,
        Page1Fragment.OnFragmentInteractionListener,
        Page2Fragment.OnFragmentInteractionListener,
        Page3Fragment.OnFragmentInteractionListener,
        Page4Fragment.OnFragmentInteractionListener {

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
