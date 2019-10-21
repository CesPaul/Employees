package com.cespaul.employees.ui.employee;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.cespaul.employees.R;
import com.cespaul.employees.base.BaseActivity;
import com.cespaul.employees.base.BasePresenter;
import com.cespaul.employees.repository.Employee;
import com.cespaul.employees.ui.pages.TrainingFragment;
import com.cespaul.employees.ui.pages.ProfileFragment;
import com.cespaul.employees.ui.pages.HealthFragment;
import com.cespaul.employees.ui.pages.DisruptionsFragment;
import com.google.android.material.tabs.TabLayout;

public class EmployeeActivity
        extends BaseActivity
        implements EmployeeView,
        TrainingFragment.OnFragmentInteractionListener,
        ProfileFragment.OnFragmentInteractionListener,
        HealthFragment.OnFragmentInteractionListener,
        DisruptionsFragment.OnFragmentInteractionListener {

    private ViewPager mPager;
    private PagerAdapter pagerAdapter;
    Employee employee = new Employee();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Инициализация и настройка кастомного Toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Установка действия для кнопки "Назад"
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        try {
            this.getPresenter().onViewCreated();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mPager = findViewById(R.id.pager);
        pagerAdapter = new EmployeePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
        // Установка страницы по умолчанию
        mPager.setCurrentItem(1);
        TabLayout tabLayout = findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(mPager, true);
        // Определение содержинаия шапки
        TextView numberH = findViewById(R.id.numberTextView);
        TextView surnameH = findViewById(R.id.surnameHeader);
        TextView nameH = findViewById(R.id.nameHeader);
        TextView patronymicH = findViewById(R.id.patronymicHeader);
        numberH.setText(employee.number);
        surnameH.setText(employee.surname);
        nameH.setText(employee.name);
        patronymicH.setText(employee.patronymic);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
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
