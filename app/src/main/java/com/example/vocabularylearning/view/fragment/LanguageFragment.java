package com.example.vocabularylearning.view.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.vocabularylearning.OnSkipNextListerner;
import com.example.vocabularylearning.R;
import com.example.vocabularylearning.model.Language;

/**
 * A simple {@link Fragment} subclass.
 */
public class LanguageFragment extends Fragment {

    private int position;

    public LanguageFragment() {
        // Required empty public constructor
    }

    public static LanguageFragment newInstance() {
        LanguageFragment languageFragment = new LanguageFragment();
        return languageFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_language, container, false);
        ImageView imglogo = view.findViewById(R.id.img_logo);
        TextView txtcontent = view.findViewById(R.id.txt_content);
        LinearLayout bgview = view.findViewById(R.id.view_language);

        Bundle bundle = getArguments();
        if (bundle != null) {
            //position = bundle.getInt("position");
            Language language = (Language) bundle.getSerializable("language");
            imglogo.setImageResource(language.getIdLogo());
            txtcontent.setText(language.getContent());
            bgview.setBackgroundColor(getResources().getColor(language.getIdColor()));
        }

        return view;
    }


}
