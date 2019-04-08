package com.example.t.app.ui;

import android.animation.LayoutTransition;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.t.app.R;
import com.example.t.app.entity.MyGrid_Item;
import com.example.t.app.global.MyApplication;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class LiveAdd_Custom_View extends GridLayout implements View.OnLongClickListener {


    public LiveAdd_Custom_View(Context context) {
        this(context, null);
    }

    public LiveAdd_Custom_View(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LiveAdd_Custom_View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private int mGridCount = 3;

    private void init() {
        //设置条目列数
        setColumnCount(mGridCount);
        setLayoutTransition(new LayoutTransition());
    }


    private List<View> list = new ArrayList<View>();
    private List<CheckBox> list2 = new ArrayList<CheckBox>();

    public void hide(boolean flag) {
        for (int i = 0; i < list2.size(); i++) {
            if (flag) {
                list2.get(i).setVisibility(GONE);
                list.get(i).setEnabled(false);
            } else {
                list2.get(i).setVisibility(VISIBLE);
                list.get(i).setEnabled(true);
            }
        }
    }

    //接收条目文本集合
    public void addItems(List<MyGrid_Item> items) {
        for (MyGrid_Item tv : items) {
            addStrText(tv);
        }
    }

    public void addStrText(MyGrid_Item st) {
        String str = st.getItem();

        final View view = LayoutInflater.from(getContext()).inflate(R.layout
                .item_live_add2, null);

        final TextView tv = view.findViewById(R.id.tv);
        final CheckBox del = view.findViewById(R.id.del);
        list.add(view);
        list2.add(del);
        del.setChecked(st.getFalg());

        del.setVisibility(VISIBLE);
//        final TextView tv = new TextView(MyApplication.mCtontext);
//        final Drawable drawable = getResources().getDrawable(R.mipmap.btn_type_del);
//        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());// 设置边界
//        // param 左上右下
//        tv.setCompoundDrawables(null, null, drawable, null);

        //设置内容
        tv.setText(str);
        //设置边框
        tv.setBackgroundResource(R.drawable.live_add_item);
        //文字大小
        tv.setTextSize(15);
        //设置文字颜色
        tv.setTextColor(getResources().getColor(R.color.live_item_text));
        //根据屏幕宽度求出条目宽
        int width = getResources().getDisplayMetrics().widthPixels / 3 - (10 + 10) * 2;
        //设置给文字控件
        tv.setWidth(width);
        //设置外边距
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(new LayoutParams());
        params.setMargins(10 + 10, 10 + 10, 10 + 10, 10 + 10);
        tv.setLayoutParams(params);
        //设置内边距
        tv.setPadding(10 + 7, 10 + 7, 10 + 7, 10 + 7);
        //文字居中
        tv.setGravity(Gravity.CENTER);
        //添加到列表
        addView(view);

        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //回调给activity
                onClickListener.OnItemClick(view);
                for (int i = 0; i < getChildCount(); i++) {
                    Log.e("qaz", getChildCount() + "" + getChildAt(i));
                }

            }
        });
        //设置长按监听
        if (mDragAble) {
            view.setOnLongClickListener(onLongClickListener);
        } else {
            view.setOnLongClickListener(null);
        }

    }

    private View mDragedView;
    private boolean mDragAble;

    @Override
    public boolean onLongClick(View v) {
        Log.e("qwe", "长按了");
        //设置拖拽是有阴影
        startDrag(null, new DragShadowBuilder(v), null, 0);
        this.mDragedView = v;

        return true;
    }

    private OnLongClickListener onLongClickListener = new OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            //回调给Activity变换按钮
            onClickListener.OnItemFinish(true);

            LiveAdd_Custom_View.this.mDragedView = v;

            //设置拖拽是有阴影
            startDrag(null, new DragShadowBuilder(v), null, 0);
            //长按的时候图标显示出来，条目可点击
            hide(false);
            return true;
        }
    };

    //设置拖拽监听器
    public void setDragAble(boolean isDragAble) {
        mDragAble = isDragAble;
        if (isDragAble)
            setOnDragListener(listener);
        else {
            setOnDragListener(null);
        }
    }

    //创建长按事件
    private OnDragListener listener = new OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            switch (event.getAction()) {
                //开始拖拽执行一次
                case DragEvent.ACTION_DRAG_STARTED:
                    initRects();
                    break;
                //拖拽中执行
                case DragEvent.ACTION_DRAG_LOCATION:
                    int index = dragChange(event);
                    if (index > -1 && mDragedView != null && mDragedView != getChildAt(index)) {
                        removeView(mDragedView);

                        //将拖拽的View添加到移动的位置
                        LiveAdd_Custom_View.this.addView(mDragedView, index);
                    }
                    break;
            }
            return true;
        }
    };

    //时刻判断 被拖拽的条目是否达到某个条目范围内
    private int dragChange(DragEvent event) {
//        int a = -1;
        for (int i = 0; i < mRectArr.length; i++) {
            if (mRectArr[i].contains((int) event.getX(), (int) event.getY())) {
//                a = i;
                return i;
            }
        }
        return -1;
    }

    private Rect[] mRectArr;

    //将所有的条目封装成矩形对象，存到数组中
    private void initRects() {
        //列表中条目个数
        int ItemCount = getChildCount();
        if (mRectArr == null) {
            mRectArr = new Rect[ItemCount];
        }
        for (int i = 0; i < mRectArr.length; i++) {
            View view = getChildAt(i);
            //把每个条目封装，并存到数组里面
            mRectArr[i] = new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom
                    ());
        }
    }

    private OnItemClickListeren onClickListener;

    public void setOnClickListener2(OnItemClickListeren onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnItemClickListeren {
        void OnItemClick(View view);

        void OnItemFinish(Boolean fag);
    }
}
