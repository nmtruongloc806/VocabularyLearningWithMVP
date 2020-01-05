package com.example.vocabularylearning.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.vocabularylearning.R;
import com.example.vocabularylearning.view.fragment.MainIntroFragment;
import com.example.vocabularylearning.view.fragment.MainLoginFragment;

public class MainActivity extends AppCompatActivity {
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentTransaction = fragmentManager.beginTransaction();

        showMainLoginFragment();
    }

    private void showMainIntroFragment() {
        MainIntroFragment mainIntroFragment = MainIntroFragment.newInstance();
        mainIntroFragment.setOnChangeFragment(new MainIntroFragment.OnChangeFragment() {
            @Override
            public void changeFragment() {
                showMainLoginFragment();
            }
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, mainIntroFragment).commit();
    }


    private void showMainLoginFragment() {
        MainLoginFragment mainLoginFragment = MainLoginFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.anim_right_in,R.anim.anim_right_out)
                .replace(R.id.frame_container, mainLoginFragment).commit();
    }
}
