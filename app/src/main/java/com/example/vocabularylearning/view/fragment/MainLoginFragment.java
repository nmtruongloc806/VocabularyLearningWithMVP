package com.example.vocabularylearning.view.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vocabularylearning.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainLoginFragment extends Fragment {

    View viewroot;
    public MainLoginFragment() {
        // Required empty public constructor
    }

    public static MainLoginFragment newInstance() {
        MainLoginFragment mainLoginFragment = new MainLoginFragment();
        return mainLoginFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewroot = inflater.inflate(R.layout.fragment_main_login, container, false);
        return viewroot;
    }

}
