package com.jiyun.myapplication.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.myapplication.R;

public class DragLayout extends ViewGroup {

    private View childAt;

    public DragLayout(Context context) {
        super(context);
    }

    public DragLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DragLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //当完成填充会执行该方法，也知道自己有几个子View
    //一般用来初始化ziView的引用
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        childAt = getChildAt(0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //测量自己的子View
        //从文件里面获取单位
        //float size = getResources().getDimension(R.dimen.dp_100);
        int measureSpec = MeasureSpec.makeMeasureSpec(childAt.getLayoutParams().width,
                MeasureSpec.EXACTLY);
        childAt.measure(measureSpec, measureSpec);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        int left = 0;
        int top = 0;
        childAt.layout(left, top, left + childAt.getMeasuredWidth(), top + childAt
                .getMeasuredHeight());






    }
}
