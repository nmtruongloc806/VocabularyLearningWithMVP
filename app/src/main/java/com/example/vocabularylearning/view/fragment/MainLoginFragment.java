package com.example.vocabularylearning.view.fragment;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.vocabularylearning.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainLoginFragment extends Fragment implements View.OnClickListener {

    View viewroot;
    RelativeLayout viewContainer;
    Button btnlogin,btnregister;
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
        viewContainer = viewroot.findViewById(R.id.viewContainer);
        btnlogin = viewroot.findViewById(R.id.btnlogin);
        btnregister = viewroot.findViewById(R.id.btnregister);

        btnlogin.setSelected(true);
        btnlogin.setOnClickListener(this);
        btnregister.setOnClickListener(this);

        replaceLoginFragment();
        DrawBackground();
        return viewroot;
    }

    private void replaceLoginFragment(){
        LoginFragment loginFragment = LoginFragment.newInstance();
        getChildFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.anim_left_in,R.anim.anim_left_out)
                .replace(R.id.fragment_field, loginFragment)
                .commit();
    }
    private void replaceRegisterFragmentFragment(){
        RegisterFragment registerFragment = RegisterFragment.newInstance();
        getChildFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.anim_right_in,R.anim.anim_right_out)
                .replace(R.id.fragment_field, registerFragment)
                .commit();
    }

    private void DrawBackground()
    {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final int width = displayMetrics.widthPixels;
        final int halfHeight = displayMetrics.heightPixels / 2;

        ShapeDrawable mDrawable = new ShapeDrawable(new Shape() {
            @Override
            public void draw(Canvas canvas, Paint paint) {
                paint.setColor(0xff74AC23);
                Path mPath = new Path();
                mPath.lineTo(0,(float)(halfHeight * 0.85));
                mPath.quadTo(width / 2, halfHeight, width,(float)(halfHeight * 0.85));
                mPath.lineTo(width,0);
                canvas.drawPath(mPath,paint);
            }
        });
        viewContainer.setBackground(mDrawable);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnlogin:
                btnlogin.setSelected(true);
                btnregister.setSelected(false);
                replaceLoginFragment();
                break;
            case R.id.btnregister:
                btnlogin.setSelected(false);
                btnregister.setSelected(true);
                replaceRegisterFragmentFragment();
                break;
        }
    }
}
