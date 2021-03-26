package com.solo.customview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSeekBar;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.SeekBar;
import android.widget.TextView;

import com.solo.customview.R;

public class MainActivity extends AppCompatActivity {

    private AppCompatSeekBar sbBar;
    private View3D view3D;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*        TextView v = findViewById(R.id.tv);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scaleanim);
        v.startAnimation(animation);*/


        initView();
    }

    private void initView() {
        sbBar = (AppCompatSeekBar) findViewById(R.id.sb_bar);
        sbBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                view3D.setProgress(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        view3D = (View3D) findViewById(R.id.view3D);
    }
}