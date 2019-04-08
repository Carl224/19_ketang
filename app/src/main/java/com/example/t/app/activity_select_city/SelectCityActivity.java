package com.example.t.app.activity_select_city;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.example.t.app.R;
import com.example.t.app.base.BaseActivity;
import com.example.t.app.mvp.model.APIServicde;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Optional;

public class SelectCityActivity extends BaseActivity {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.city)
    TextView city;
    @BindView(R.id.dialog)
    TextView dialog;
    @BindView(R.id.sideBar)
    SideBar sideBar;
    @BindView(R.id.selectcity_guanbi)
    ImageView selectcityGuanbi;

    private SortAdapter adapter;
    LinearLayoutManager manager;

    private List<SortModel> SourceDateList;

    /**
     * 根据拼音来排列RecyclerView里面的数据类
     */
    private PinyinComparator pinyinComparator;
    private LocationClient mlocationClient;


    @Override
    protected void initView() {
        pinyinComparator = new PinyinComparator();

        sideBar = (SideBar) findViewById(R.id.sideBar);
        dialog = (TextView) findViewById(R.id.dialog);
        sideBar.setTextView(dialog);

        //设置右侧SideBar触摸监听
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {

            @Override
            public void onTouchingLetterChanged(String s) {
                //该字母首次出现的位置
                int position = adapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    manager.scrollToPositionWithOffset(position, 0);
                }

            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //设置列表数据源
        SourceDateList = filledData(getResources().getStringArray(R.array.date));
        // 根据a-z进行排序源数据
        Collections.sort(SourceDateList, pinyinComparator);
        //RecyclerView社置manager
        manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        adapter = new SortAdapter(this, SourceDateList);
        recyclerView.setAdapter(adapter);
        //item点击事件
        adapter.setOnItemClickListener(new SortAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                SortModel item = (SortModel) adapter.getItem(position);
                if (item != null) {
                    Intent intent = getIntent();
                    intent.putExtra("item", item.getName());
                    setResult(1, intent);
                }
                finish();
            }
        });
//        mClearEditText = (ClearEditText) findViewById(R.id.filter_edit);
//
//        //根据输入框输入值的改变来过滤搜索
//        mClearEditText.addTextChangedListener(new TextWatcher() {
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                //当输入框里面的值为空，更新为原来的列表，否则为过滤数据列表
//                filterData(s.toString());
//            }
//
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count,
//                                          int after) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//            }
//        });
    }

    //返回布局
    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_selectcity;
    }

    @Override
    protected void loadData() {
        mlocationClient = new LocationClient(getApplicationContext());
        //注册定位监听器
        mlocationClient.registerLocationListener(new MyLocationListener());
        //判断手机版本是否大于6.0
        if (Build.VERSION.SDK_INT > 23) {
            ArrayList<String> list = new ArrayList<>();
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                    PackageManager.PERMISSION_GRANTED) {
                list.add(Manifest.permission.ACCESS_FINE_LOCATION);
            }
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) !=
                    PackageManager.PERMISSION_GRANTED) {
                list.add(Manifest.permission.READ_PHONE_STATE);
            }
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                    PackageManager.PERMISSION_GRANTED) {
                list.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }
            if (!list.isEmpty()) {
                Log.e("qwe", list.size() + "");
                String[] strings = list.toArray(new String[list.size()]);
                Log.e("qwe", strings.length + "");
                ActivityCompat.requestPermissions(this, strings, 1);
            } else {
                dingwei();
            }
        }
    }

    private void dingwei() {
        LocationClientOption option = new LocationClientOption();
        //设置更新间隔
//        option.setScanSpan(5000);
        //获取详细信息
        option.setIsNeedAddress(true);
        //设置定位模式为GPS定位
        option.setLocationMode(LocationClientOption.LocationMode.Device_Sensors);
        mlocationClient.setLocOption(option);
        mlocationClient.start();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    for (int i : grantResults) {
                        if (i != PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(this, "必须授权才可使用定位", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                    dingwei();
                } else {
                    Toast.makeText(this, "发生未知错误", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    /**
     * 为RecyclerView填充数据
     *
     * @param date
     * @return
     */
    private List<SortModel> filledData(String[] date) {
        List<SortModel> mSortList = new ArrayList<>();

        for (int i = 0; i < date.length; i++) {
            SortModel sortModel = new SortModel();
            sortModel.setName(date[i]);
            //汉字转换成拼音
            String pinyin = PinyinUtils.getPingYin(date[i]);
            String sortString = pinyin.substring(0, 1).toUpperCase();

            // 正则表达式，判断首字母是否是英文字母
            if (sortString.matches("[A-Z]")) {
                //把全部设置到第一位
                if ("全部".equals(sortModel.getName().trim())) {
                    sortModel.setLetters("#");
                }else{
                    sortModel.setLetters(sortString.toUpperCase());
                }
            } else {
                sortModel.setLetters("#");
            }
            mSortList.add(sortModel);
        }
        return mSortList;

    }

    /**
     * 根据输入框中的值来过滤数据并更新RecyclerView
     *
     * @param filterStr
     */
    private void filterData(String filterStr) {
        List<SortModel> filterDateList = new ArrayList<>();

        if (TextUtils.isEmpty(filterStr)) {
            filterDateList = SourceDateList;
        } else {
            filterDateList.clear();
            for (SortModel sortModel : SourceDateList) {
                String name = sortModel.getName();
                if (name.indexOf(filterStr.toString()) != -1 ||
                        PinyinUtils.getFirstSpell(name).startsWith(filterStr.toString())
                        //不区分大小写
                        || PinyinUtils.getFirstSpell(name).toLowerCase().startsWith(filterStr.toString())
                        || PinyinUtils.getFirstSpell(name).toUpperCase().startsWith(filterStr.toString())
                        ) {
                    filterDateList.add(sortModel);
                }
            }
        }

        // 根据a-z进行排序
        Collections.sort(filterDateList, pinyinComparator);
        adapter.updateList(filterDateList);
    }

    @Optional
    @OnClick(R.id.selectcity_guanbi)
    public void onViewClicked() {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mlocationClient != null) {
            mlocationClient.stop();
        }
    }

    //创建一个定位监听器
    public class MyLocationListener implements BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            String city1 = bdLocation.getCity();
            Toast.makeText(SelectCityActivity.this, city1, Toast.LENGTH_SHORT).show();
            city.setText(city1);
        }
    }

}
