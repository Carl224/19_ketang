package com.example.t.app.activity_set;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.t.app.R;
import com.example.t.app.base.BaseActivity;

import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SystemSetActivity extends BaseActivity {
    @BindView(R.id.wangluo_kaiguan)
    CheckBox wangluokaiguan;
    @BindView(R.id.systemset_guanbi)
    ImageView systemsetGuanbi;
    @BindView(R.id.lijidenglu)
    Button lijidenglu;
    @BindView(R.id.line_wangluo)
    RelativeLayout lineWangluo;
    @BindView(R.id.line_cache)
    RelativeLayout lineCache;
    @BindView(R.id.line_yijian)
    RelativeLayout lineYijian;
    @BindView(R.id.line_guanyu)
    RelativeLayout lineGuanyu;

    @Override
    protected void initView() {

    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_systemset;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.systemset_guanbi, R.id.lijidenglu, R.id.line_wangluo, R.id.line_cache, R.id.line_yijian, R.id.line_guanyu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.systemset_guanbi:
                finish();
                break;
            case R.id.lijidenglu:
                break;
            case R.id.line_wangluo:
                break;
            case R.id.line_cache:
                break;
            case R.id.line_yijian:
                break;
            case R.id.line_guanyu:
                break;
        }
    }
}
