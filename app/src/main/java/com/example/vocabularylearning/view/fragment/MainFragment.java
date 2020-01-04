package com.example.vocabularylearning.view.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vocabularylearning.R;
import com.example.vocabularylearning.adapter.IntroAdapter;
import com.example.vocabularylearning.model.Language;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        MainFragment mainFragment = new MainFragment();
        return mainFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ViewPager viewPager = view.findViewById(R.id.viewpager);

        LanguageFragment xamarinFragment = LanguageFragment.newInstance();
        LanguageFragment androidFragment = LanguageFragment.newInstance();
        LanguageFragment flutterFragment = LanguageFragment.newInstance();

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(xamarinFragment);
        fragments.add(androidFragment);
        fragments.add(flutterFragment);


        ArrayList<Language> languages = new ArrayList<>();
        languages.add(new Language(R.drawable.image_xamarin,"Free. Cross-platform. Open source. An app platform for building Android and iOS apps with .NET and C#.",R.color.bg_screen1));
        languages.add(new Language(R.drawable.image_androidstudio,"Android Studio provides the fastest tools for building apps on every type of Android device.",R.color.bg_screen2));
        languages.add(new Language(R.drawable.image_flutter,"Flutter is Google’s UI toolkit for building beautiful, natively compiled applications for mobile, web, and desktop from a single codebase.",R.color.bg_screen3));

        IntroAdapter introAdapter = new IntroAdapter(getFragmentManager(),fragments,languages);

        viewPager.setAdapter(introAdapter);

        return view;
    }

}
