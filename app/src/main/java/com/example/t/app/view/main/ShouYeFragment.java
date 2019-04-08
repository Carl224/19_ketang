package com.example.t.app.view.main;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.t.app.R;
import com.example.t.app.activity.ShouYeDetailActivity;
import com.example.t.app.activity_erweima.android.CaptureActivity;
import com.example.t.app.activity_erweima.bean.ZxingConfig;
import com.example.t.app.activity_erweima.common.Constant;
import com.example.t.app.activity_select_city.SelectCityActivity;
import com.example.t.app.activity_souke.SouSuoActivity;
import com.example.t.app.adapter.ShouYeBannerAdapter;
import com.example.t.app.adapter.ShouYeListType1Adapter;
import com.example.t.app.adapter.ShouYeListType2Adapter;
import com.example.t.app.base.BaseFragment;
import com.example.t.app.entity.BannerBean;
import com.example.t.app.entity.ReDian;
import com.example.t.app.entity.ShouYeListBean;
import com.example.t.app.mvp.Contract;
import com.example.t.app.mvp.presenter.ShouYePresenter;
import com.example.t.app.ui.RxTextViewVerticalMore;
import com.example.t.app.util.AlphaTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;

public class ShouYeFragment extends BaseFragment implements Contract.BaseView {
    @BindView(R.id.banner)
    ViewPager banner;
    @BindView(R.id.lin1)
    LinearLayout lin1;
    @BindView(R.id.lin2)
    LinearLayout lin2;
    @BindView(R.id.lin3)
    LinearLayout lin3;
    @BindView(R.id.lin4)
    LinearLayout lin4;
    @BindView(R.id.lin5)
    LinearLayout lin5;
    @BindView(R.id.select_text)
    LinearLayout selectText;
    @BindView(R.id.shouye_sousuo)
    LinearLayout shouyesousuo;
    @BindView(R.id.saoyisao)
    ImageView saoyisao;
    Unbinder unbinder;
    @BindView(R.id.shouye_city)
    TextView shouyeCity;
    @BindView(R.id.upview1)
    RxTextViewVerticalMore upview1;
    @BindView(R.id.haoke_lv)
    RecyclerView haokeLv;
    @BindView(R.id.gongkai_lv)
    RecyclerView gongkaiLv;
    @BindView(R.id.xitong_lv)
    RecyclerView xitongLv;
    @BindView(R.id.weini_lv)
    RecyclerView weiniLv;
    @BindView(R.id.gongkai_duo)
    TextView gongkaiduo;
    @BindView(R.id.xitong_duo)
    TextView xitongduo;
    private int REQUEST_CODE_SCAN = 111;
    private Unbinder mUnBinder;
    private List<ReDian.ListBean> list;

    @Override
    protected void initView(View view) {

        mUnBinder = ButterKnife.bind(this, view);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        haokeLv.setLayoutManager(manager);

        gongkaiLv.setLayoutManager(new LinearLayoutManager(getContext()));
        gongkaiLv.setNestedScrollingEnabled(false);
        xitongLv.setLayoutManager(new LinearLayoutManager(getContext()));
        xitongLv.setNestedScrollingEnabled(false);
        weiniLv.setLayoutManager(new LinearLayoutManager(getContext()));
        weiniLv.setNestedScrollingEnabled(false);
    }


    @Override
    protected void loadData() {
        ShouYePresenter shouYePresenter = new ShouYePresenter(this);
        shouYePresenter.start();
        for (int i = 1; i <= 4; i++) {
            shouYePresenter.http(i);
        }
    }

    @Override
    protected int getFrgamentLayoutId() {
        return R.layout.fragment_shouye;
    }

    @Override
    public void setPresenter(Contract.BasePresenter basePresenter) {

    }


    @Override
    public void onDataSucess(Object o) {
        //更新ui
        if (o instanceof List) {
            List<BannerBean.ListBean> bean = (List<BannerBean.ListBean>) o;
           /* banner.setImages(bean);


            banner.setImages(bean);
            banner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    BannerBean.ListBean bean1 = (BannerBean.ListBean) path;
                    Glide.with(getActivity()).load(bean1.getShow_img()).into(imageView);
                }
            });
            //设置banner动画效果 DepthPage  Accordion折叠式的
            banner.setBannerAnimation(Transformer.Accordion);
            //设置指示器位置（当banner模式中有指示器时）//默认居中
            banner.setIndicatorGravity(BannerConfig.CENTER);
            banner.setDelayTime(3000);
            banner.isAutoPlay(true);
            banner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    Toast.makeText(getActivity(), "你点击了轮播图", Toast.LENGTH_SHORT).show();
                }
            });
            banner.start();*/
            banner.setPageMargin(10);//两个页面之间的距离
            banner.setOffscreenPageLimit(5);
            banner.setPageTransformer(false, new AlphaTransformer());
            ShouYeBannerAdapter shouYeBannerAdapter = new ShouYeBannerAdapter(bean, getContext());
            banner.setAdapter(shouYeBannerAdapter);

        }
        if (o instanceof ReDian) {
            ReDian reDian = (ReDian) o;
            list = reDian.getList();
            List<View> views = new ArrayList<>();
            setUPMarqueeView(views, list.size());
            upview1.setViews(views);
            upview1.setOnItemClickListener(new RxTextViewVerticalMore.OnItemClickListener() {
                @Override
                public void onItemClick(int position, View view) {

                }
            });
        }
        if (o instanceof ShouYeListBean) {
            ShouYeListBean shouYeListBean = (ShouYeListBean) o;
            int id = shouYeListBean.getId();
            if (id == 1) {
                List<ShouYeListBean.ListBean> list = shouYeListBean.getList();
                ShouYeListType1Adapter shouYeListType1Adapter = new ShouYeListType1Adapter(list,
                        getContext());
                shouYeListType1Adapter.setOnButClick(new ShouYeListType1Adapter.OnButClick() {
                    @Override
                    public void butClick() {
                        Intent intent = new Intent(getContext(), ShouYeDetailActivity.class);
                        startActivity(intent);
                    }
                });
                haokeLv.setAdapter(shouYeListType1Adapter);
            } else if (id == 2) {
                List<ShouYeListBean.ListBean> list = shouYeListBean.getList();
                ShouYeListType2Adapter shouYeListType2Adapter = new ShouYeListType2Adapter(list,
                        getContext());
                gongkaiLv.setAdapter(shouYeListType2Adapter);
            } else if (id == 3) {
                List<ShouYeListBean.ListBean> list = shouYeListBean.getList();
                ShouYeListType2Adapter shouYeListType2Adapter = new ShouYeListType2Adapter(list,
                        getContext());
                xitongLv.setAdapter(shouYeListType2Adapter);
            } else {
                List<ShouYeListBean.ListBean> list = shouYeListBean.getList();
                ShouYeListType2Adapter shouYeListType2Adapter = new ShouYeListType2Adapter(list,
                        getContext());
                weiniLv.setAdapter(shouYeListType2Adapter);
            }
        }
    }

    private void setUPMarqueeView(List<View> views, int size) {
        for (int i = 0; i < size; i = i + 2) {
            final int position = i;
            //设置滚动的单个布局
            LinearLayout moreView = (LinearLayout) LayoutInflater.from(getContext()).inflate(R
                    .layout.item_view, null);
            //初始化布局的控件
            TextView tv1 = moreView.findViewById(R.id.tv1);
            TextView tv2 = moreView.findViewById(R.id.tv2);
            moreView.findViewById(R.id.rl).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), list.get(position).getArticle_name(), Toast
                            .LENGTH_SHORT).show();
                }
            });
            if (size > i + 1) {
                moreView.findViewById(R.id.rl2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), list.get(position + 1).getArticle_name(), Toast
                                .LENGTH_SHORT).show();
                    }
                });
            }
            //进行对控件赋值
            tv1.setText(list.get(i).getArticle_name());
            if (size > i + 1) {
                //因为是两条数据，但是当数据是奇数时就不需要赋值第二个，所以加了一个判断，还应该把第二个布局给隐藏掉
                tv2.setText(list.get(i + 1).getArticle_name());
            } else {
                moreView.findViewById(R.id.rl2).setVisibility(View.GONE);
            }
            //添加到循环滚动数组里面去
            views.add(moreView);
        }
    }

    @Override
    public void onDataFaile(Object o) {

    }

    @Override
    public void onComplete() {

    }

    @Optional
    @OnClick({R.id.shouye_sousuo, R.id.lin1, R.id.lin2, R.id.lin3, R.id.lin4, R.id.lin5, R.id
            .select_text, R.id.saoyisao, R.id.gongkai_duo, R.id.xitong_duo
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lin1:
                break;
            case R.id.lin2:
                break;
            case R.id.lin3:
                break;
            case R.id.lin4:
                break;
            case R.id.lin5:
                break;
            case R.id.select_text:
                Intent intent1 = new Intent(getActivity(), SelectCityActivity.class);
                startActivityForResult(intent1, 1);
                break;
            case R.id.shouye_sousuo:
                Intent intent = new Intent(getActivity(), SouSuoActivity.class);
                startActivity(intent);
                break;
            case R.id.saoyisao:
                Toast.makeText(getActivity(), "二维码扫描", Toast.LENGTH_SHORT).show();
                saoyisao();
                break;
            case R.id.gongkai_duo:
                onButtonClick.onClick(1);
                break;
            case R.id.xitong_duo:
                onButtonClick.onClick(2);
                break;
        }
    }

    private void saoyisao() {
        Intent intent = new Intent(getActivity(), CaptureActivity.class);
        /*ZxingConfig是配置类
         *可以设置是否显示底部布局，闪光灯，相册，
         * 是否播放提示音  震动
         * 设置扫描框颜色等
         * 也可以不传这个参数
         * */
        ZxingConfig config = new ZxingConfig();
        config.setPlayBeep(true);//是否播放扫描声音 默认为true
        config.setShake(true);//是否震动  默认为true
        config.setDecodeBarCode(true);//是否扫描条形码 默认为true
        config.setReactColor(R.color.colorAccent);//设置扫描框四个角的颜色 默认为白色
        config.setFrameLineColor(R.color.colorAccent);//设置扫描框边框颜色 默认无色
        config.setScanLineColor(R.color.colorAccent);//设置扫描线的颜色 默认白色
        config.setFullScreenScan(true);//是否全屏扫描  默认为true  设为false则只会在扫描框中扫描
        intent.putExtra(Constant.INTENT_ZXING_CONFIG, config);

        startActivityForResult(intent, REQUEST_CODE_SCAN);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    //页面回传
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 1) {
            String item = data.getStringExtra("item");
            shouyeCity.setText(item);
        }
        // 扫描二维码/条码回传
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {
                String content = data.getStringExtra(Constant.CODED_CONTENT);
//                result.setText("扫描结果为：" + content);
                Toast.makeText(getActivity(), content, Toast.LENGTH_SHORT).show();
            }
        }
    }

    //定义接口变量的get方法
    public OnButtonClick getOnButtonClick() {
        return onButtonClick;
    }

    //定义接口变量的set方法
    public void setOnButtonClick(OnButtonClick onButtonClick) {
        this.onButtonClick = onButtonClick;
    }

    private OnButtonClick onButtonClick;

    //定义接口
    public interface OnButtonClick {
        void onClick(int view);
    }

}
