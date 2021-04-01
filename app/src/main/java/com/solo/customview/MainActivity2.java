package com.solo.customview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity2 extends AppCompatActivity {
    private View rootView;

    private int duration = 600;

    private Rotate3DAnimation open;
    private Rotate3DAnimation close;

    boolean isOpen = false;
    private ConstraintLayout root;
    private Button button;
    private LinearLayout content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_3d);

        initView();
    }

    private void initView() {
        root = (ConstraintLayout) findViewById(R.id.root);
        button = (Button) findViewById(R.id.button);
        content = (LinearLayout) findViewById(R.id.content);
        initOpenAnimation();
        iniCloseAnimation();
    }

    private void initOpenAnimation() {
        open = new Rotate3DAnimation(0, 180);
        open.setDuration(duration);
        open.setFillAfter(true);
    }

    private void iniCloseAnimation() {
        close = new Rotate3DAnimation(180, 0);
        close.setDuration(duration);
        close.setFillAfter(true);
    }

    public void click(View view) {
        if (open.hasStarted() && !open.hasEnded()) {
            return;
        }
        if (close.hasStarted() && !close.hasEnded()) {
            return;
        }
        if (isOpen) {
            content.startAnimation(close);
        } else {
            content.startAnimation(open);
        }

    }
}