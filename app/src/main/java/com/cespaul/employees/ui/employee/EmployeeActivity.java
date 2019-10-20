package com.cespaul.employees.ui.employee;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.cespaul.employees.R;
import com.cespaul.employees.base.BaseActivity;
import com.cespaul.employees.base.BasePresenter;
import com.cespaul.employees.model.App;
import com.cespaul.employees.model.AppDatabase;
import com.cespaul.employees.model.EmployeeDao;
import com.cespaul.employees.model.entities.Employee;
import com.cespaul.employees.ui.HeaderFragment;
import com.cespaul.employees.ui.pages.Page1Fragment;
import com.cespaul.employees.ui.pages.Page2Fragment;
import com.cespaul.employees.ui.pages.Page3Fragment;
import com.cespaul.employees.ui.pages.Page4Fragment;
import com.cespaul.employees.ui.viewPager.MyPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class EmployeeActivity
        extends BaseActivity
        implements EmployeeView,
        HeaderFragment.OnFragmentInteractionListener,
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
        pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
        // Установка страницы по умолчанию
        mPager.setCurrentItem(1);
        //AppDatabase db = App.getInstance().getDatabase();
        //EmployeeDao employeeDao = db.employeeDao();
        //entDb = db.employeeDao().getAll();
                //fillData();
        TabLayout tabLayout = findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(mPager, true);
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
    public void fillData() {
        AppDatabase db = App.getInstance().getDatabase();
        EmployeeDao employeeDao = db.employeeDao();
        Employee employee = new Employee();
        employee.id = 1;
        employee.name = "Ivan";
        /*employee.surname = "Ivanov";
        employee.patronymic = "Ivanovich";
        employee.gender = "муж.";
        try {
            birthDate = format.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        employee.birthDate = birthDate;
        employee.breathalyzer = 100;*/
        employeeDao.insert(employee);

    }

    @Override
    public void onImgButtonClick() {
        // TODO: Реализовать вставку картинки по нажатию на кнопку
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
