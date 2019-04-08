package com.example.t.app.live.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.t.app.R;
import com.example.t.app.ui.HackyViewPager;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

public class ShowWebImageActivity extends AppCompatActivity {
    private ArrayList<String> images;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showwebimage);
        HackyViewPager hackyViewPager = (HackyViewPager) findViewById(R.id.view_pager);

        Bundle bundle = getIntent().getBundleExtra("bundle");
        images = bundle.getStringArrayList("list_image");
        int index = bundle.getInt("index");
        hackyViewPager.setAdapter(new ViewPagerAdapter());
        hackyViewPager.setCurrentItem(index);

    }

    class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = View.inflate(ShowWebImageActivity.this, R.layout.view_pager_item, null);
            PhotoView photoView = (PhotoView) view.findViewById(R.id.photoview);
            photoView.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
                @Override
                public void onPhotoTap(View view, float v, float v1) {
                    finish();
                }
            });
            photoView.setBackgroundColor(Color.TRANSPARENT);
            TextView indicator = (TextView) view.findViewById(R.id.indicator);
            //用Glide加载图片
            Glide.with(ShowWebImageActivity.this).load(images.get(position)).into(photoView);
            CharSequence text = getString(R.string.viewpager_indicator, position + 1, images.size());
            //设置indicator
            indicator.setText(text);
            container.addView(view, ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.MATCH_PARENT);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}