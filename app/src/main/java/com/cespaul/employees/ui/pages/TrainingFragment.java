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

public class TrainingFragment extends Fragment {
    private static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";

    int pageNumber;

    private OnFragmentInteractionListener mListener;
    Employee employee = new Employee();

    public TrainingFragment() {
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
                R.layout.fragment_training, container, false);
        //region Элементы макетов
        TextView training = rootView.findViewById(R.id.training);
        TextView briefings = rootView.findViewById(R.id.briefings);
        TextView certificationOt = rootView.findViewById(R.id.certificationOt);
        TextView certificationPb = rootView.findViewById(R.id.certificationPb);
        TextView preExaminer = rootView.findViewById(R.id.preExaminer);
        //endregion

        //region Заполнение данных фрагмента
        training.setText(employee.training);
        briefings.setText(employee.briefings);
        certificationOt.setText(employee.certificationOt);
        certificationPb.setText(employee.certificationPb);
        preExaminer.setText(employee.preExaminer);
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
