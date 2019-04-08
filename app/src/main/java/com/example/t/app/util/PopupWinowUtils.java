package com.example.t.app.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RadioGroup;

import com.example.t.app.R;

public class PopupWinowUtils {
    private static PopupWinowUtils popupWinowUtils;

    public static PopupWinowUtils getPopupWinowUtils() {
        if (popupWinowUtils == null) {
            synchronized (PopupWinowUtils.class) {
                if (popupWinowUtils == null) {
                    popupWinowUtils = new PopupWinowUtils();
                }
            }
        }
        return popupWinowUtils;
    }

    public PopupWindow getSoukeLeiXing(View view) {
        PopupWindow windows = new PopupWindow();
        windows.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        windows.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        windows.setOutsideTouchable(true);
        windows.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;

            }
        });
        windows.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        //设置可点击与焦点
        windows.setTouchable(true);
        windows.setFocusable(true);


        windows.setContentView(view);


        return windows;
    }
}
