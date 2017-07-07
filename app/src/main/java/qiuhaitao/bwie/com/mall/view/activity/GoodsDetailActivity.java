package qiuhaitao.bwie.com.mall.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import qiuhaitao.bwie.com.mall.R;
import qiuhaitao.bwie.com.mall.model.bean.CartAddBean;
import qiuhaitao.bwie.com.mall.model.utils.Constant;
import qiuhaitao.bwie.com.mall.presenter.CartPresenter;
import qiuhaitao.bwie.com.mall.view.iview.Cart_Iview;

/**
 * Created by 仇海涛 on 2017/7/5.
 * class ：
 * content ：
 */

public class GoodsDetailActivity extends BaseActivity implements Cart_Iview<CartAddBean>{

    private TextView joincart;
    private String goods_id;
    private String key;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        initView();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        goods_id = intent.getStringExtra("goods_id");
        key = Constant.mSharedPreferences.getString("key","");
    }
    private void initView() {
        joincart = (TextView) findViewById(R.id.joinCartTextView);
        joincart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("joincart", "onclick" );
                CartPresenter cartp=new CartPresenter();
                cartp.attachView(GoodsDetailActivity.this);
                cartp.cartadd("","");
            }
        });
    }

    @Override
    public void ondata(CartAddBean cartAddBean) {
        Log.e("===========", cartAddBean.toString() );
    }
}
