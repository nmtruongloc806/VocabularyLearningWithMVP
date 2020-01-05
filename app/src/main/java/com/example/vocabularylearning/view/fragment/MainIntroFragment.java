package com.example.vocabularylearning.view.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vocabularylearning.OnSkipNextListerner;
import com.example.vocabularylearning.R;
import com.example.vocabularylearning.adapter.IntroAdapter;
import com.example.vocabularylearning.model.Language;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainIntroFragment extends Fragment implements View.OnClickListener {

    ViewPager viewPager;
    View viewRoot;
    int currentPage;
    private OnChangeFragment onChangeFragment;
    public MainIntroFragment() {
        // Required empty public constructor
    }

    public static MainIntroFragment newInstance() {
        MainIntroFragment mainIntroFragment = new MainIntroFragment();
        return mainIntroFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewRoot = inflater.inflate(R.layout.fragment_main_intro, container, false);

        initView();

        return viewRoot;
    }

    private void initView() {
        TextView tvSkip = viewRoot.findViewById(R.id.tvskip);
        final TextView tvNext = viewRoot.findViewById(R.id.tvnext);

        final View indicator1 = viewRoot.findViewById(R.id.indicator1);
        final View indicator2 = viewRoot.findViewById(R.id.indicator2);
        final View indicator3 = viewRoot.findViewById(R.id.indicator3);

        viewPager = viewRoot.findViewById(R.id.viewpager);

        tvSkip.setOnClickListener(this);
        tvNext.setOnClickListener(this);

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

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage =position;
                switch (position)
                {
                    case 0:
                        indicator1.setBackgroundResource(R.drawable.bg_indicator_active);
                        indicator2.setBackgroundResource(R.drawable.bg_indicator_inactive);
                        indicator3.setBackgroundResource(R.drawable.bg_indicator_inactive);
                        tvNext.setText("Next");
                        break;
                    case 1:
                        indicator1.setBackgroundResource(R.drawable.bg_indicator_inactive);
                        indicator2.setBackgroundResource(R.drawable.bg_indicator_active);
                        indicator3.setBackgroundResource(R.drawable.bg_indicator_inactive);
                        tvNext.setText("Next");
                        break;
                    case 2:
                        indicator1.setBackgroundResource(R.drawable.bg_indicator_inactive);
                        indicator2.setBackgroundResource(R.drawable.bg_indicator_inactive);
                        indicator3.setBackgroundResource(R.drawable.bg_indicator_active);
                        tvNext.setText("Finish");
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.tvskip:
                replaceFragmentMainLogin();
                //viewPager.setCurrentItem(3,true);
                break;
            case R.id.tvnext:
                if(currentPage < 2)
                {
                    viewPager.setCurrentItem(currentPage + 1);
                }
                else {
                    replaceFragmentMainLogin();
                }
                break;
        }
    }
    private void replaceFragmentMainLogin(){
        onChangeFragment.changeFragment();
    }

    public void setOnChangeFragment(OnChangeFragment onChangeFragment) {
        this.onChangeFragment = onChangeFragment;
    }

    public interface OnChangeFragment {
        void changeFragment();
    }
}
