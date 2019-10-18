package com.cespaul.employees.ui.experience;

import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.cespaul.employees.R;
import com.cespaul.employees.ui.HeaderFragment;

public class ExperienceActivity extends AppCompatActivity implements HeaderFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
