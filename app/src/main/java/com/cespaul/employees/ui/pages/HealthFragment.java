package com.cespaul.employees.ui.pages;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cespaul.employees.R;
import com.cespaul.employees.repository.Employee;

public class HealthFragment extends Fragment {
    private static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";

    int pageNumber;

    private OnFragmentInteractionListener mListener;
    Employee employee = new Employee();

    public HealthFragment() {
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
                R.layout.fragment_health, container, false);
        //region Элементы макета
        TextView physical = rootView.findViewById(R.id.physical);
        TextView breathalyzer = rootView.findViewById(R.id.breathalyzer);
        TextView disease = rootView.findViewById(R.id.disease);
        TextView dateOfAccidents = rootView.findViewById(R.id.dateOfAccidents);
        TextView expOfAccidents = rootView.findViewById(R.id.experienceAccident);
        TextView provision = rootView.findViewById(R.id.provision);
        //endregion

        //region Заполнение данных фрагмента
        physical.setText(employee.physical);
        breathalyzer.setText(employee.breathalyzer);
        disease.setText(employee.disease);
        dateOfAccidents.setText(employee.dateOfAccidents);
        expOfAccidents.setText(employee.expOfAccidents);

        provision.setText(employee.provision);
        //endregion
        return rootView;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
