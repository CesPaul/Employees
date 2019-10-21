package com.cespaul.employees.ui.experience;

import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.cespaul.employees.R;
import com.cespaul.employees.base.BaseActivity;
import com.cespaul.employees.base.BasePresenter;
import com.cespaul.employees.repository.Employee;

public class ExperienceActivity extends BaseActivity implements ExperienceView {

    Employee employee = new Employee();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);
        // Инициализация и настройка кастомного Toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

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
        // Inflate the menu, this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    protected BasePresenter instantiatePresenter() {
        return null;
    }
}
