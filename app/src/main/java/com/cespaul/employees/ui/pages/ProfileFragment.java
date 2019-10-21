package com.cespaul.employees.ui.pages;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.cespaul.employees.R;
import com.cespaul.employees.repository.Employee;
import com.cespaul.employees.ui.experience.ExperienceActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProfileFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";

    int pageNumber;

    Button expButton;

    private OnFragmentInteractionListener mListener;
    private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    private Date date;
    Employee employee = new Employee();

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_profile, container, false);

        expButton = rootView.findViewById(R.id.experienceButton);
        expButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ExperienceActivity.class);
                startActivity(intent);
            }
        });
        //region Элементы макетов
        TextView surname = rootView.findViewById(R.id.surname);
        TextView name = rootView.findViewById(R.id.name);
        TextView patronymic = rootView.findViewById(R.id.patronymic);
        TextView birthDate = rootView.findViewById(R.id.birthDate);
        TextView gender = rootView.findViewById(R.id.gender);
        TextView position = rootView.findViewById(R.id.position);
        TextView jobEvaluation = rootView.findViewById(R.id.jobEvaluation);
        TextView currentExperience = rootView.findViewById(R.id.currentExperience);
        TextView totalExperience = rootView.findViewById(R.id.totalExperience);
        //endregion

        //region Заполнение данных фрагмента
        name.setText(employee.name);
        surname.setText(employee.surname);
        patronymic.setText(employee.patronymic);
        birthDate.setText(employee.birthDate);
        gender.setText(employee.gender);
        position.setText(employee.position);
        jobEvaluation.setText(employee.jobEvaluation);
        currentExperience.setText(employee.currentExperience);
        totalExperience.setText(employee.totalExperience);


        //endregion
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
