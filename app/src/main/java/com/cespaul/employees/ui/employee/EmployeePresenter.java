package com.cespaul.employees.ui.employee;

import com.cespaul.employees.base.BasePresenter;
import com.cespaul.employees.base.BaseView;

public class EmployeePresenter extends BasePresenter {

    String date = "04.01.1998";
    /*private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    private Date birthDate;*/

    @Override
    public void onViewCreated() {
        super.onViewCreated();
    }

    @Override
    public void onViewDestroyed() {
        super.onViewDestroyed();
    }

    public EmployeePresenter(BaseView view) {
        super(view);
    }
}
