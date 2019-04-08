package com.example.t.app.activity_souke;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.t.app.R;
import com.example.t.app.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class SouSuoActivity extends BaseActivity {
    @BindView(R.id.kc)
    EditText kc;
    @BindView(R.id.sousuo_clean)
    ImageView sousuoClean;
    @BindView(R.id.sousuo_huitui)
    TextView sousuoHuitui;

    @Override
    protected void initView() {
        kc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() != 0) {
                    sousuoClean.setVisibility(View.VISIBLE);
                } else {
                    sousuoClean.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_sousuo;
    }

    @Override
    protected void loadData() {

    }


    @OnClick({R.id.sousuo_clean, R.id.sousuo_huitui})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sousuo_clean:
                kc.setText("");

                break;
            case R.id.sousuo_huitui:
                finish();
                break;
        }
    }
}
