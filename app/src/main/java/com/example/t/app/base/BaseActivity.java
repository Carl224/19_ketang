package com.example.t.app.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.VelocityTracker;

import com.umeng.analytics.MobclickAgent;
import com.umeng.message.PushAgent;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 爱生活，爱代码
 * 创建于：2018/10/24 10:03
 * 作 者：T
 * 微信：704003376
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder mUnBinder;
    private FragmentManager mManager;

    private MotionEvent mActionDownEvent;
    private VelocityTracker mVelocityTracker;
    private FragmentManager mFragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getActivityLayoutId());
        mUnBinder = ButterKnife.bind(this);
        mManager = getSupportFragmentManager();
        PushAgent.getInstance(this).onAppStart();
        initView();
        loadData();
        mFragmentManager = getSupportFragmentManager();
    }


    protected abstract void initView();

    protected abstract int getActivityLayoutId();

    protected abstract void loadData();


    //添加Fragment  add()         replace()
    public void addFragment(int containerId, BaseFragment fragment) {
        if (fragment != null) {
            mManager.beginTransaction().
                    add(containerId, fragment,
                            fragment.getClass().getSimpleName()).
                    commit();
        } else {
            fragment = (BaseFragment)
                    mManager.findFragmentByTag(fragment.getClass().getSimpleName());
            mManager.beginTransaction().add(containerId, fragment, fragment.getClass().
                    getSimpleName()).commit();
        }
    }

    //添加Fragment
    public void startFragment(int containerId, BaseFragment fragment) {
        if (fragment != null) {
            mManager.beginTransaction().replace(containerId, fragment,
                    fragment.getClass().getSimpleName()).commit();
        }
    }

    // 封装公共的添加Fragment的方法
    public void addFragment(Class<? extends BaseFragment> zClass, int layoutId) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        String tag = zClass.getName();

        // 从 fragmentManager中查找这个fragment是否存在，
        Fragment fragment = mFragmentManager.findFragmentByTag(tag);

        if (fragment != null) { // 如果存在就不用重新创建
            if (fragment.isAdded()) { // 如果 fragment 已经被添加
                if (fragment.isHidden()) { // 如果fragment 已经被添加，并且处于隐藏状态，那么显示
                    transaction.show(fragment); // 显示 fragment
                    hideOtherPage(transaction, fragment); // 隐藏其他fragment
                }
            } else { // 如果 fragment存在，但是没有被添加到activity，那么执行下面添加，（这种一般发生在activity 横竖屏切换）
                transaction.add(layoutId, fragment);
                hideOtherPage(transaction, fragment);
            }
        } else {
            // 如果没有从fragmentManager 中通过tag 找到fragment,那么创建一个新的fragment 实例
            try {
                fragment = zClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            if (fragment != null) {
                transaction.add(layoutId, fragment, tag);
                hideOtherPage(transaction, fragment);
            }
        }

        transaction.commit();
    }


    // 隐藏除了将要显示的fragment 以外的其他所有fragment
    private void hideOtherPage(FragmentTransaction transaction, Fragment willShowFragment) {

        List<Fragment> fragments = mFragmentManager.getFragments();
        for (Fragment fragment : fragments) {
            if (fragment != willShowFragment) {
                transaction.hide(fragment);
            }
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override
    protected void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }
}
