package com.example.t.app.view.main;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.t.app.R;
import com.example.t.app.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Optional;

public class MainActivity extends BaseActivity {


    @BindView(R.id.rb1)
    RadioButton rb1;
    @BindView(R.id.rb2)
    RadioButton rb2;
    @BindView(R.id.rb3)
    RadioButton rb3;
    @BindView(R.id.rb4)
    RadioButton rb4;
    @BindView(R.id.rb5)
    RadioButton rb5;
    @BindView(R.id.rg)
    RadioGroup rg;
    @BindView(R.id.cb)
    CheckBox cb;
    private final String SHOUYETAG = "f1";
    private final String SOUKETAG = "f2";
    private final String LIVETAG = "f3";
    private final String HUANCUNTAG = "f4";
    private final String MYTAG = "f5";

    private ShouYeFragment shouYeFragment;
    private SouKeFragment souKeFragment;
    private LiveFragment liveFragment;
    private CacheFragment cacheFragment;
    private MyFragment myFragment;
    private FragmentManager manager;
    private FragmentTransaction fragmentTransaction;
    private int tabSelection;

    class a extends AsyncTask<View, Integer, String> {

        @Override
        protected String doInBackground(View... views) {
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }
    }

    @Override
    protected void initView() {
        //进来默认显示第一页
        rg.check(R.id.rb1);
        manager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction1 = manager.beginTransaction();
        shouYeFragment = (ShouYeFragment) manager.findFragmentByTag(SHOUYETAG);
        if (shouYeFragment == null) {
            shouYeFragment = new ShouYeFragment();
            fragmentTransaction1.add(R.id.content, shouYeFragment, SHOUYETAG);
            fragmentTransaction1.commit();
        }
        shouYeFragment.setOnButtonClick(new ShouYeFragment.OnButtonClick() {
            @Override
            public void onClick(int view) {
                FragmentTransaction transaction = manager.beginTransaction();
                if (shouYeFragment != null) {
                    if (!shouYeFragment.isHidden()) {
                        transaction.hide(shouYeFragment);
                    }
                }
                liveFragment = (LiveFragment) manager.findFragmentByTag(LIVETAG);
                if (liveFragment == null) {
                    liveFragment = new LiveFragment();
                    transaction.add(R.id.content, liveFragment, LIVETAG);
                } else {
                    transaction.show(liveFragment);
                }

                liveFragment.setType(view);
                rg.check(R.id.rb3);
                cb.setChecked(true);
                transaction.commit();
            }
        });

/*
                new ShouYeFragment();
        souKeFragment = new SouKeFragment();
        liveFragment = new LiveFragment();
        cacheFragment = new CacheFragment();
        myFragment = new MyFragment();

        fragmentTransaction.add(R.id.content, shouYeFragment, shouYeFragment.getClass()
        .getSimpleName()).
                add(R.id.content, souKeFragment, souKeFragment.getClass().getSimpleName()).
                add(R.id.content, liveFragment, liveFragment.getClass().getSimpleName()).
                add(R.id.content, cacheFragment, cacheFragment.getClass().getSimpleName()).
                add(R.id.content, myFragment, myFragment.getClass().getSimpleName()).
                hide(souKeFragment).hide(liveFragment).hide(cacheFragment).hide(myFragment)
                .commit();*/

    }


    @Override
    protected void loadData() {

    }


    private void hideFragment() {
        fragmentTransaction = manager.beginTransaction();
        shouYeFragment = (ShouYeFragment) manager.findFragmentByTag(SHOUYETAG);
        if (shouYeFragment == null) {
            shouYeFragment = new ShouYeFragment();
            fragmentTransaction.add(R.id.content, shouYeFragment, SHOUYETAG);
            fragmentTransaction.hide(shouYeFragment);
        } else {
            if (shouYeFragment.isAdded()) {
                if (!shouYeFragment.isHidden()) {
                    fragmentTransaction.hide(shouYeFragment);
                }
            }
        }
        souKeFragment = (SouKeFragment) manager.findFragmentByTag(SOUKETAG);
        if (souKeFragment == null) {
            souKeFragment = new SouKeFragment();
            fragmentTransaction.add(R.id.content, souKeFragment, SOUKETAG);
            fragmentTransaction.hide(souKeFragment);
        } else {
            if (souKeFragment.isAdded()) {
                if (!souKeFragment.isHidden()) {
                    fragmentTransaction.hide(souKeFragment);
                }
            }
        }


        liveFragment = (LiveFragment) manager.findFragmentByTag(LIVETAG);
        if (liveFragment == null) {
            liveFragment = new LiveFragment();
            fragmentTransaction.add(R.id.content, liveFragment, LIVETAG);
            fragmentTransaction.hide(liveFragment);
        } else {
            if (liveFragment.isAdded()) {
                if (!liveFragment.isHidden()) {
                    fragmentTransaction.hide(liveFragment);
                }
            }
        }


        cacheFragment = (CacheFragment) manager.findFragmentByTag(HUANCUNTAG);
        if (cacheFragment == null) {
            cacheFragment = new CacheFragment();
            fragmentTransaction.add(R.id.content, cacheFragment, HUANCUNTAG);
            fragmentTransaction.hide(cacheFragment);
        } else {
            if (cacheFragment.isAdded()) {
                if (!cacheFragment.isHidden()) {
                    fragmentTransaction.hide(cacheFragment);
                }
            }
        }


        myFragment = (MyFragment) manager.findFragmentByTag(MYTAG);
        if (myFragment == null) {
            myFragment = new MyFragment();
            fragmentTransaction.add(R.id.content, myFragment, MYTAG);
            fragmentTransaction.hide(myFragment);
        } else {
            if (myFragment.isAdded()) {
                if (!myFragment.isHidden()) {
                    fragmentTransaction.hide(myFragment);
                }
            }
        }

    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_main;
    }

    @Optional
    @OnClick({R.id.rg, R.id.cb, R.id.rb1, R.id.rb2, R.id.rb3, R.id.rb4, R.id.rb5})
    public void onViewClicked(View view) {
        hideFragment();
        switch (view.getId()) {
            case R.id.rb1:
                if (cb.isChecked()) {
                    cb.setChecked(false);
                }
                fragmentTransaction.show(shouYeFragment);
                Log.e("qwe", "1=======shouYeFragment===========" + manager.getFragments().size());
                break;
            case R.id.rb2:
                if (cb.isChecked()) {
                    cb.setChecked(false);
                }
                fragmentTransaction.show(souKeFragment);
                Log.e("qwe", "2======souKeFragment============" + manager.getFragments().size());
                break;
            case R.id.rb3:
                if (!cb.isChecked()) {
                    cb.setChecked(true);
                }
                fragmentTransaction.show(liveFragment);
                Log.e("qwe", "3======liveFragment============" + manager.getFragments().size());
                break;
            case R.id.rb4:
                if (cb.isChecked()) {
                    cb.setChecked(false);
                }
                fragmentTransaction.show(cacheFragment);
                Log.e("qwe", "4======cacheFragment============" + manager.getFragments().size());
                break;
            case R.id.rb5:
                if (cb.isChecked()) {
                    cb.setChecked(false);
                }
                fragmentTransaction.show(myFragment);
                Log.e("qwe", "5======myFragment============" + manager.getFragments().size());
                break;
            case R.id.cb:
                if (!rb3.isChecked()) {
                    rg.check(R.id.rb3);
                }
                fragmentTransaction.show(liveFragment);
                Log.e("qwe", "5======liveFragment============" + manager.getFragments().size());
                break;
        }
        fragmentTransaction.commit();
    }


    @Override
    public void onAttachFragment(Fragment fragment) {
        if (shouYeFragment == null && fragment instanceof ShouYeFragment)
            shouYeFragment = (ShouYeFragment) fragment;
        if (souKeFragment == null && fragment instanceof SouKeFragment)
            souKeFragment = (SouKeFragment) fragment;
        if (liveFragment == null && fragment instanceof LiveFragment)
            liveFragment = (LiveFragment) fragment;
        if (cacheFragment == null && fragment instanceof CacheFragment)
            cacheFragment = (CacheFragment) fragment;
        if (myFragment == null && fragment instanceof MyFragment)
            myFragment = (MyFragment) fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle
            persistentState) {
        if (savedInstanceState != null) {
            //读取上一次界面Save的时候tab选中的状态
            selindex = savedInstanceState.getInt(PRV_SELINDEX, selindex);
            shouYeFragment = (ShouYeFragment) manager.findFragmentByTag(SHOUYETAG);
            souKeFragment = (SouKeFragment) manager.findFragmentByTag(SOUKETAG);
            liveFragment = (LiveFragment) manager.findFragmentByTag(LIVETAG);
            cacheFragment = (CacheFragment) manager.findFragmentByTag(HUANCUNTAG);
            myFragment = (MyFragment) manager.findFragmentByTag(MYTAG);
        }
        // 选中index
        setTabSelection(selindex);
        super.onCreate(savedInstanceState, persistentState);
    }


    private static final String PRV_SELINDEX = "PREV_SELINDEX";
    private int selindex;

    public void setTabSelection(int tabSelection) {
        this.tabSelection = tabSelection;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            clickTwoExit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    private boolean mFlag = false;

    private void clickTwoExit() {
        if (!mFlag) {
            mFlag = true;
            Toast.makeText(this, R.string.click_two_exit_message, Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mFlag = false;
                }
            }, 2000);
        } else {
//            for (Activity activity : MyApplication.objectVector) {
//                activity.finish();
//            }
            finish();
        }
    }
}
