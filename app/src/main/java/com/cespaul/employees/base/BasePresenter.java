package com.cespaul.employees.base;

public abstract class BasePresenter {
    private final BaseView view;

    public void onViewCreated(){}

    public void onViewDestroyed(){}

    protected final BaseView getView(){
        return this.view;
    }

    public BasePresenter(BaseView view){
        this.view = view;
    }
}
