package qiuhaitao.bwie.com.mall.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import qiuhaitao.bwie.com.mall.R;

/**
 * Created by 仇海涛 on 2017/7/5.
 * class ：
 * content ：
 */

public class GoodsDetailActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        initView();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        String goods_id = intent.getStringExtra("goods_id");
    }

    private void initView() {

    }
}
