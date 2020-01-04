package com.example.vocabularylearning.view.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vocabularylearning.R;
import com.example.vocabularylearning.model.Language;

/**
 * A simple {@link Fragment} subclass.
 */
public class LanguageFragment extends Fragment {


    public LanguageFragment() {
        // Required empty public constructor
    }

    public static LanguageFragment newInstance(){
        LanguageFragment languageFragment = new LanguageFragment();
        return  languageFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_language, container, false);
        ImageView imglogo = view.findViewById(R.id.img_logo);
        TextView txtcontent = view.findViewById(R.id.txt_content);
        View bgview = view.findViewById(R.id.bg_color);

        Bundle bundle = getArguments();
        if(bundle != null)
        {
            int position = bundle.getInt("position");
            Language language = (Language)bundle.getSerializable("language");
            imglogo.setImageResource(language.getIdLogo());
            txtcontent.setText(language.getContent());
            bgview.setBackgroundColor(language.getIdColor());
        }

        return view;
    }

}
