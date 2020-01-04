package com.example.vocabularylearning.adapter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.vocabularylearning.model.Language;

import java.io.Serializable;
import java.util.ArrayList;

public class IntroAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> mListFragment;
    private ArrayList<Language> mLanguages;

    public IntroAdapter(FragmentManager fragmentManager, ArrayList<Fragment> mListFragment, ArrayList<Language> mLanguages){
        super(fragmentManager);
        this.mListFragment = mListFragment;
        this.mLanguages = mLanguages;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = mListFragment.get(position);
        Bundle bundle = new Bundle();
        bundle.putInt("position",position);
        bundle.putSerializable("language",(Serializable) mLanguages.get(position));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return mListFragment.size();
    }
}
