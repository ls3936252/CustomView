package com.solo.customview;

import android.graphics.Rect;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    private void initView() {
        rv = (RecyclerView) findViewById(R.id.rv);
        List<String> data = new ArrayList<String>(20);
        for (int i = 0; i < 20; i++) {
            data.add(""+i);
        }

        RvAdapter rvAdapter = new RvAdapter(this, data);
        rv.setAdapter(rvAdapter);
//        rv.setLayoutManager(new CustomLayoutManager());
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}