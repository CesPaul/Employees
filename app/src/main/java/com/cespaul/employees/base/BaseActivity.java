package com.cespaul.employees.base;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {
    protected BasePresenter presenter;

    protected final BasePresenter getPresenter() throws Exception {
        BasePresenter basePresenter = this.presenter;
        if (basePresenter == null){
            throw new Exception("Presenter is null");
        }
        return basePresenter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.presenter = this.instantiatePresenter();
    }

    protected abstract BasePresenter instantiatePresenter();

    public Context getContext(){
        return this;
    }
}
