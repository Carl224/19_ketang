package com.example.t.app.activity_live_add;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.t.app.R;
import com.example.t.app.base.BaseActivity;
import com.example.t.app.entity.MyGrid_Item;
import com.example.t.app.mvp.Contract;
import com.example.t.app.ui.LiveAdd_Custom_View;
import com.example.t.app.util.MydbUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class LiveAddActivity extends BaseActivity implements Contract.BaseView {
    @BindView(R.id.live_add_finish)
    ImageView liveAddFinish;
    @BindView(R.id.live_add_guanli)
    TextView liveAddGuanli;
    private MydbUtil mydbUtil;
    private MydbUtil mydbUtil1;
    private LiveAdd_Custom_View grid;
    private LiveAdd_Custom_View grid2;

    @Override
    protected void initView() {
        mydbUtil = MydbUtil.getMydbUtil("list.db");
        mydbUtil1 = MydbUtil.getMydbUtil("list2.db");
        SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
        boolean s = sp.getBoolean("s", false);
        if (!s) {
            final List<MyGrid_Item> list = getList(getResources().getStringArray(R.array.list));
            mydbUtil.addd(list);
            final List<MyGrid_Item> list2 = getList2(getResources().getStringArray(R.array.list2));
            mydbUtil1.addd(list2);
            SharedPreferences.Editor edit = sp.edit();
            edit.putBoolean("s", true);
            edit.commit();
        }


        grid = findViewById(R.id.grid);
        grid.setDragAble(true);
        final List<MyGrid_Item> query = mydbUtil.query();
        grid.addItems(query);
        grid2 = findViewById(R.id.grid2);
        grid2.setDragAble(false);
        final List<MyGrid_Item> query1 = mydbUtil1.query();
        grid2.addItems(query1);
        Log.e("list", query + "\r\n" + query1);


        grid.setOnClickListener2(new LiveAdd_Custom_View.OnItemClickListeren() {
            @Override
            public void OnItemClick(View view) {
                String s = ((TextView) view.findViewById(R.id.tv)).getText().toString().trim();
                Log.e("qwe", s);
                boolean checked = ((CheckBox) view.findViewById(R.id.del)).isChecked();
                for (int i = 0; i < query.size(); i++) {
                    if (query.get(i).getItem().equals(s)) {
                        if (query.size() > 1) {
                            //先删除数据库，否者会报空指针,索引越界
                            mydbUtil.remove(query.get(i));
                            query.remove(i);
                            grid.removeView(view);


                            MyGrid_Item myGrid_item = new MyGrid_Item(null, s, true);
                            mydbUtil1.addd(myGrid_item);
                            query1.add(myGrid_item);
                            grid2.addStrText(myGrid_item);
                        } else {
                            Toast.makeText(LiveAddActivity.this, "至少留一个标签", Toast
                                    .LENGTH_SHORT).show();
                        }
                    }
                }
            }

            @Override
            public void OnItemFinish(Boolean fag) {
                liveAddGuanli.setText("完成");
                falg = fag;
            }
        });
        grid2.setOnClickListener2(new LiveAdd_Custom_View.OnItemClickListeren() {
            @Override
            public void OnItemClick(View view) {
                String s = ((TextView) view.findViewById(R.id.tv)).getText().toString().trim();
                Log.e("qwe", s);
                boolean checked = ((CheckBox) view.findViewById(R.id.del)).isChecked();
                for (int i = 0; i < query1.size(); i++) {
                    if (query1.get(i).getItem().equals(s)) {
                        if (query1.size() > 1) {

                            //先删除数据库，否者会报空指针,索引越界
                            mydbUtil1.remove(query1.get(i));
                            query1.remove(i);
                            grid2.removeView(view);


                            MyGrid_Item myGrid_item = new MyGrid_Item(null, s, false);
                            mydbUtil.addd(myGrid_item);
                            query.add(myGrid_item);
                            grid.addStrText(myGrid_item);
                        }
                    }
                }
            }

            @Override
            public void OnItemFinish(Boolean fag) {
                falg = fag;
                liveAddGuanli.setText("完成");
            }
        });
        grid.hide(true);
        grid2.hide(true);
    }

    private List<MyGrid_Item> getList(String[] array) {
        List<MyGrid_Item> list = new ArrayList<>();
        for (String s : array) {
            list.add(new MyGrid_Item(null, s, false));
        }
        return list;
    }

    private List<MyGrid_Item> getList2(String[] array) {
        List<MyGrid_Item> list = new ArrayList<>();
        for (String s : array) {

            list.add(new MyGrid_Item(null, s, true));
        }
        return list;
    }


    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_liveadd;
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void setPresenter(Contract.BasePresenter basePresenter) {

    }

    @Override
    public void onDataSucess(Object o) {

    }

    @Override
    public void onDataFaile(Object o) {

    }

    @Override
    public void onComplete() {

    }

    @OnClick({R.id.live_add_finish, R.id.live_add_guanli})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.live_add_finish:
                finish();
                break;
            case R.id.live_add_guanli:
                if (falg) {
                    liveAddGuanli.setText("管理");
                } else {
                    liveAddGuanli.setText("完成");
                }
                grid.hide(falg);
                grid2.hide(falg);
                falg = !falg;
                break;
        }
    }

    private boolean falg = false;

}
