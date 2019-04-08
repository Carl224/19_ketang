package com.jiyun.app2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyList lv;
    private MyScrollView myscr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    @SuppressLint("ClickableViewAccessibility")
    private void initView() {
        lv = (MyList) findViewById(R.id.lv);
        myscr = (MyScrollView) findViewById(R.id.myscr);

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, getList());
        lv.setAdapter(stringArrayAdapter);
        lv.setScrollview(myscr);
        myscr.setListView(lv);


    }

    public List<String> getList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add("测试条目" + i);
        }
        return list;
    }


}
