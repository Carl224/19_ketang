package com.example.t.app.view.main;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.t.app.R;
import com.example.t.app.activity_souke.SouSuoActivity;
import com.example.t.app.adapter.SouKeDiQuAdapter;
import com.example.t.app.adapter.SouKeErJiAdapter;
import com.example.t.app.adapter.SouKeYijIAdapter;
import com.example.t.app.base.BaseFragment;
import com.example.t.app.entity.DiQuBean;
import com.example.t.app.entity.ErJiBean;
import com.example.t.app.entity.YiJiBean;
import com.example.t.app.mvp.Contract;
import com.example.t.app.mvp.presenter.SouKePresenter;
import com.example.t.app.util.PopupWinowUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import pl.droidsonroids.gif.GifImageView;

public class SouKeFragment extends BaseFragment implements Contract.BaseView {
    @BindView(R.id.souke_sousuo)
    ImageView soukeSousuo;
    @BindView(R.id.leixing)
    CheckBox leixing;
    @BindView(R.id.diqu)
    CheckBox diqu;
    @BindView(R.id.paixu)
    CheckBox paixu;
    @BindView(R.id.saixuan)
    CheckBox saixuan;
    @BindView(R.id.img_souke)
    GifImageView imgSouke;
    Unbinder unbinder;
    @BindView(R.id.text_souke)
    TextView textView;
    @BindView(R.id.yiji)
    ListView yiji;
    @BindView(R.id.erji)
    ListView erji;
    @BindView(R.id.diqu_lv)
    ListView diqulv;
    private List<YiJiBean.ListBean> list;
    private SouKePresenter souKePresenter1;

    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(this, view);

    }

    @Override
    protected void loadData() {
        souKePresenter1 = new SouKePresenter(this);
        souKePresenter1.start();
    }

    @Nullable
    @Override
    protected int getFrgamentLayoutId() {
        return R.layout.fragment_souke;
    }

    @Override
    public void setPresenter(final Contract.BasePresenter basePresenter) {

    }

    @Override
    public void onDataSucess(Object o) {
        if (o instanceof YiJiBean) {
            YiJiBean yiJiBean = (YiJiBean) o;
            list = yiJiBean.getList();
            SouKeYijIAdapter souKeYijIAdapter = new SouKeYijIAdapter(list, getContext());
            yiji.setAdapter(souKeYijIAdapter);
            souKePresenter1.erji(list.get(0).getId());
            yiji.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    int id1 = list.get(position).getId();
                    souKePresenter1.erji(id1);
                }
            });
        }
        if (o instanceof ErJiBean) {
            ErJiBean erJiBean = (ErJiBean) o;
            final List<ErJiBean.ListBean> list = erJiBean.getList();
            SouKeErJiAdapter souKeErJiAdapter = new SouKeErJiAdapter(list, getContext());
            erji.setAdapter(souKeErJiAdapter);
            erji.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    leixing.setText(list.get(position).getExam_type1());
                    leixing.setChecked(false);

                    yiji.setVisibility(View.GONE);
                    erji.setVisibility(View.GONE);
                    imgSouke.setVisibility(View.VISIBLE);
                    textView.setVisibility(View.VISIBLE);
                }
            });
        }
        if (o instanceof DiQuBean) {
            DiQuBean diQuBean = (DiQuBean) o;
            List<DiQuBean.ListBean> list = diQuBean.getList();
            final ArrayList<String> list1 = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                list1.add(list.get(i).getAddress());
            }
            SouKeDiQuAdapter souKeDiQuAdapter = new SouKeDiQuAdapter(list, getContext());
            diqulv.setAdapter(souKeDiQuAdapter);
            diqulv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    diqu.setText(list1.get(position));
                    diqu.setChecked(false);

                    diqulv.setVisibility(View.GONE);
                    imgSouke.setVisibility(View.VISIBLE);
                    textView.setVisibility(View.VISIBLE);
                }
            });
        }
    }

    @Override
    public void onDataFaile(Object o) {

    }

    @Override
    public void onComplete() {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.souke_sousuo)
    public void onViewClicked() {
        Intent intent = new Intent(getActivity(), SouSuoActivity.class);
        startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @OnClick({R.id.leixing, R.id.diqu, R.id.paixu, R.id.saixuan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.leixing:
                diqu.setChecked(false);
                paixu.setChecked(false);
                saixuan.setChecked(false);
                if (leixing.isChecked()) {
                    yiji.setVisibility(View.VISIBLE);
                    erji.setVisibility(View.VISIBLE);
                    imgSouke.setVisibility(View.GONE);
                    textView.setVisibility(View.GONE);
                } else {
                    yiji.setVisibility(View.GONE);
                    erji.setVisibility(View.GONE);
                    imgSouke.setVisibility(View.VISIBLE);
                    textView.setVisibility(View.VISIBLE);
                }

                diqulv.setVisibility(View.GONE);
                break;
            case R.id.diqu:
                leixing.setChecked(false);
                paixu.setChecked(false);
                saixuan.setChecked(false);

                if (diqu.isChecked()) {
                    diqulv.setVisibility(View.VISIBLE);
                    imgSouke.setVisibility(View.GONE);
                    textView.setVisibility(View.GONE);
                } else {
                    diqulv.setVisibility(View.GONE);
                    imgSouke.setVisibility(View.VISIBLE);
                    textView.setVisibility(View.VISIBLE);
                }

                yiji.setVisibility(View.GONE);
                erji.setVisibility(View.GONE);
                break;
            case R.id.paixu:
                leixing.setChecked(false);
                diqu.setChecked(false);
                saixuan.setChecked(false);

                View view1 = LayoutInflater.from(getContext()).inflate(R.layout
                        .popupwindow_souke_paixu, null);
                final TextView zonghe = view1.findViewById(R.id.zonghe);
                final TextView renqi = view1.findViewById(R.id.renqi);
                final TextView price_di = view1.findViewById(R.id.price_di);
                final TextView price_gao = view1.findViewById(R.id.price_gao);
                final PopupWindow window = PopupWinowUtils.getPopupWinowUtils().getSoukeLeiXing(view1);
                zonghe.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        paixu.setText(zonghe.getText().toString());
                        window.dismiss();
                    }
                });
                renqi.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        paixu.setText(renqi.getText().toString());
                        window.dismiss();
                    }
                });
                price_di.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        paixu.setText(price_di.getText().toString());
                        window.dismiss();
                    }
                });
                price_gao.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        paixu.setText(price_gao.getText().toString());
                        window.dismiss();
                    }
                });
                if (paixu.isChecked()) {
                    window.showAsDropDown(paixu, Gravity.BOTTOM, 0, 0);
                    imgSouke.setVisibility(View.GONE);
                    textView.setVisibility(View.GONE);
                } else {
                    imgSouke.setVisibility(View.VISIBLE);
                    textView.setVisibility(View.VISIBLE);
                    window.dismiss();
                }
                window.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        paixu.setChecked(false);
                    }
                });


                diqulv.setVisibility(View.GONE);
                yiji.setVisibility(View.GONE);
                erji.setVisibility(View.GONE);
                break;
            case R.id.saixuan:
                leixing.setChecked(false);
                diqu.setChecked(false);
                paixu.setChecked(false);

                diqulv.setVisibility(View.GONE);
                yiji.setVisibility(View.GONE);
                erji.setVisibility(View.GONE);
                imgSouke.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);

                PopupWinowUtils popupWinowUtils = PopupWinowUtils.getPopupWinowUtils();
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout
                        .popupwindow_souke_saixuan, null);
                final RadioGroup rg1 = inflate.findViewById(R.id.rg1);
                final RadioGroup rg2 = inflate.findViewById(R.id.rg2);
                final RadioGroup rg3 = inflate.findViewById(R.id.rg3);
                Button cls = inflate.findViewById(R.id.cls);
                Button ok = inflate.findViewById(R.id.ok);
                cls.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rg1.clearCheck();
                        rg2.clearCheck();
                        rg3.clearCheck();
                    }
                });
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "你都没有数据", Toast.LENGTH_SHORT).show();
                    }
                });

                PopupWindow soukeLeiXing = popupWinowUtils.getSoukeLeiXing(inflate);
                soukeLeiXing.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
//                        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
//                        lp.alpha = 1.0f;
//                        getActivity().getWindow().clearFlags(WindowManager.LayoutParams
// .FLAG_DIM_BEHIND);
//                        getActivity().getWindow().setAttributes(lp);
                        saixuan.setChecked(false);
                    }
                });
                soukeLeiXing.showAsDropDown(saixuan, Gravity.BOTTOM, 0, 0);
//                WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
//                lp.alpha = 0.3f;
//                getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//                getActivity().getWindow().setAttributes(lp);
//                break;
        }
    }
}
