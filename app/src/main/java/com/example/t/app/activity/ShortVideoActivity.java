package com.example.t.app.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.t.app.R;
import com.meicam.sdk.NvsLiveWindow;
import com.meicam.sdk.NvsStreamingContext;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShortVideoActivity extends AppCompatActivity implements NvsStreamingContext
        .CaptureDeviceCallback {

    @BindView(R.id.liveWindow)
    NvsLiveWindow liveWindow;
    private NvsStreamingContext m_streamingContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        m_streamingContext = NvsStreamingContext.init(this, null); //初始化Streaming Context
        setContentView(R.layout.activity_shortvideo);
        ButterKnife.bind(this);
        initView();

        //FILLMODE_PRESERVEASPECTCROP 平面式
        //FILLMODE_PRESERVEASPECTFIT  斜面式
        //FILLMODE_STRETCH            立体式
        liveWindow.setFillMode(NvsLiveWindow.FILLMODE_PRESERVEASPECTFIT);
    }

    private void initView() {
        //给Streaming Context设置采集设备回调接口（必须有）
        m_streamingContext.setCaptureDeviceCallback(this);
        if (m_streamingContext.getCaptureDeviceCount() == 0)
            return;
        // 将采集预览输出连接到NvsLiveWindow控件（必须有）
        if (!m_streamingContext.connectCapturePreviewWithLiveWindow(liveWindow)) {
            Log.e("tag", "Failed to connect capture preview with livewindow!");
            return;
        }
        //采集设备数量判定，如果采集设备是1，不能开启前置摄像头。
        if (m_streamingContext.getCaptureDeviceCount() > 1)
            liveWindow.setEnabled(true);

        if (m_streamingContext.isCaptureDeviceBackFacing(0))//判断是否为后置采集设备
        {

        }
    }

    @Override
    protected void onDestroy() {
        //streamingContext销毁
        m_streamingContext = null;
        NvsStreamingContext.close();
        super.onDestroy();
    }

    //以下是录制视频而重写的方法
    @Override
    public void onCaptureDeviceCapsReady(int i) {

    }

    @Override
    public void onCaptureDevicePreviewResolutionReady(int i) {

    }

    @Override
    public void onCaptureDevicePreviewStarted(int i) {

    }

    @Override
    public void onCaptureDeviceError(int i, int i1) {

    }

    @Override
    public void onCaptureDeviceStopped(int i) {

    }

    @Override
    public void onCaptureDeviceAutoFocusComplete(int i, boolean b) {

    }

    @Override
    public void onCaptureRecordingFinished(int i) {

    }

    @Override
    public void onCaptureRecordingError(int i) {

    }

}
