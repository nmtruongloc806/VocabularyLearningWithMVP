package com.example.vocabularylearning.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.vocabularylearning.R;
import com.example.vocabularylearning.util.DatabaseHelper;
import com.example.vocabularylearning.view.fragment.MainIntroFragment;
import com.example.vocabularylearning.view.fragment.MainLoginFragment;

public class MainActivity extends AppCompatActivity {
    FragmentTransaction fragmentTransaction;

    DatabaseHelper dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentTransaction = fragmentManager.beginTransaction();

        dbManager = new DatabaseHelper(this,"vocabularylearning.sqlite",null,1);
        dbManager.QueryData("CREATE TABLE IF NOT EXISTS Vocabulary(Id INTEGER PRIMARY KEY AUTOINCREMENT, Word TEXT, Mean TEXT,Type TEXT,IsNotify INTEGER)");

//        dbManager.QueryData("INSERT INTO Vocabulary VALUES(null, 'start', 'bắt đầu', 'VERB', 0)");

        Cursor data = dbManager.GetData("SELECT * FROM Vocabulary");
        while (data.moveToNext())
        {
            String work = data.getString(1);
            Log.d("MTL",work);
            Toast.makeText(this ,work,Toast.LENGTH_LONG).show();
        }

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
