package qiuhaitao.bwie.com.mall.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import qiuhaitao.bwie.com.mall.R;
import qiuhaitao.bwie.com.mall.model.bean.Goods_Search_Bean;
import qiuhaitao.bwie.com.mall.presenter.GoodsSearch_Presenter;
import qiuhaitao.bwie.com.mall.view.adapter.GoodsRecyAdapter;
import qiuhaitao.bwie.com.mall.view.iview.Goods_search_Iview;
import qiuhaitao.bwie.com.mall.view.iview.Recy_OnClick;

/**
 * Created by 仇海涛 on 2017/7/4.
 * class ：
 * content ：
 */

public class Goods_search_Activity extends BaseActivity implements Goods_search_Iview<Goods_Search_Bean> {

    public static Activity mActivity;
    private Spinner sortSpinner;
    private TextView screenTextView;
    private RelativeLayout screenRelativeLayout;
    private ImageView listImageView;
    private RecyclerView goodsrecy;
    private String listTypeString;
    private GoodsSearch_Presenter presenter;
    private Map<String,String> map = new HashMap<>();
    private GoodsRecyAdapter goodsRecyAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_search);
        initView();
        initData();
    }

    private void initData() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new String[]{"综合排序", "人气排序", "价格从高到低", "价格从低到高"});
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sortSpinner.setAdapter(adapter);

        presenter = new GoodsSearch_Presenter();
        presenter.attachView(Goods_search_Activity.this);
        goodsRecyAdapter = new GoodsRecyAdapter(this);
        goodsrecy.setAdapter(goodsRecyAdapter);
        map.put("act","goods");
        map.put("op","goods_list");
        map.put("page","100");
        presenter.getGoodsSearchData(map);

        goodsRecyAdapter.setOnClick(new Recy_OnClick() {
            @Override
            public void onClick(View view, int position, String gc_id) {
                Intent intent = new Intent(Goods_search_Activity.this,GoodsDetailActivity.class);
                intent.putExtra("goods_id",""+gc_id);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mActivity = this;
        LinearLayoutManager manager = new LinearLayoutManager(mActivity);
        sortSpinner = (Spinner) findViewById(R.id.sortSpinner);
        screenTextView = (TextView) findViewById(R.id.screenTextView);
        screenRelativeLayout = (RelativeLayout) findViewById(R.id.screenRelativeLayout);
        goodsrecy = (RecyclerView) findViewById(R.id.goods_recyclerview);
        listImageView = (ImageView) findViewById(R.id.listImageView);

        listTypeString = "ver";

        goodsrecy.setLayoutManager(manager);
        screenTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (screenRelativeLayout.getVisibility() == View.VISIBLE) {
                    screenRelativeLayout.setVisibility(View.GONE);
                    screenTextView.setTextColor(ContextCompat.getColor(mActivity, R.color.main));
                } else {
                    screenRelativeLayout.setVisibility(View.VISIBLE);
                    screenTextView.setTextColor(ContextCompat.getColor(mActivity, R.color.greyAdd));
                }
            }
        });


        listImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listTypeString.equals("ver")) {
                    listImageView.setImageResource(R.mipmap.ic_goods_list_hor);
                    listTypeString = "hor";

                } else {
                    listImageView.setImageResource(R.mipmap.ic_goods_list_ver);
                    listTypeString = "ver";

                }
            }
        });
    }

    @Override
    public void attachView(Goods_Search_Bean goods_search_bean) {
        if (goods_search_bean!=null){
            List<Goods_Search_Bean.DatasBean.GoodsListBean> goods_list = goods_search_bean.getDatas().getGoods_list();

            goodsRecyAdapter.setData(goods_list,presenter);
        }
    }
}
