package qiuhaitao.bwie.com.mall.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import qiuhaitao.bwie.com.mall.R;
import qiuhaitao.bwie.com.mall.model.bean.CartAddBean;
import qiuhaitao.bwie.com.mall.model.bean.Goods_Detail_Bean;
import qiuhaitao.bwie.com.mall.model.utils.Constant;
import qiuhaitao.bwie.com.mall.presenter.CartAddPresenter;
import qiuhaitao.bwie.com.mall.presenter.GoodsDetail_Presenter;
import qiuhaitao.bwie.com.mall.view.adapter.GoodsDetailRecyAdapter;
import qiuhaitao.bwie.com.mall.view.iview.Cart_Iview;
import qiuhaitao.bwie.com.mall.view.iview.Goods_Detail_Iview;
import qiuhaitao.bwie.com.mall.view.iview.Recy_OnClick;

/**
 * Created by 仇海涛 on 2017/7/5.
 * class ：
 * content ：
 */

public class GoodsDetailActivity extends BaseActivity implements Cart_Iview<CartAddBean>, Goods_Detail_Iview<Goods_Detail_Bean> {

    private TextView joincart;
    private String goods_id;
    private String key;
    public static Activity mActivity;


    private boolean isCollection;
    private String id, specList1, specList2;
    private HashMap<String, String> datas;
    //goods_info
    private HashMap<String, String> goods_info;
    private ArrayList<HashMap<String, String>> spec_name;
    private ArrayList<HashMap<String, String>> spec_value;
    private ArrayList<HashMap<String, String>> spec_value1;
    private ArrayList<HashMap<String, String>> spec_value2;
    private ArrayList<HashMap<String, String>> goods_spec;
    //spec_image
    private ArrayList<HashMap<String, String>> spec_image;
    //commend_list
    private ArrayList<HashMap<String, String>> commend_list;
    //store_info
    private HashMap<String, String> store_info;
    private HashMap<String, String> store_desc;
    private HashMap<String, String> store_server;
    private HashMap<String, String> store_delivery;
    //spec_list
    private ArrayList<HashMap<String, String>> spec_list;
    //goods_image
    private ArrayList<HashMap<String, String>> goods_image;
    //eval_list
    private ArrayList<HashMap<String, String>> eval_list;
    //eval_info
    private HashMap<String, String> eval_info;
    //hair_info
    private HashMap<String, String> hair_info;

    private ImageView leftImageView;
    private TextView titleTextView;
    private ImageView rightImageView;
    private ImageView right1ImageView;
    private ScrollView mScrollView;
    private ImageView goodsViewPager;
    private TextView nameTextView;
    private TextView jingleTextView;
    private TextView pricePromotionTextView;
    private TextView priceTextView;
    private TextView saleNumTextView;
    private LinearLayout activityLinearLayout;
    private TextView activityNameTextView;
    private TextView activityRemarkTextView;
    private TextView addressTextView;
    private TextView addressTipTextView;
    private LinearLayout chooseLinearLayout;
    private TextView choose1TextView;
    private TextView choose2TextView;
    private TextView commentTextView;
    private TextView commentNumTextView;
    private TextView bodyTextView;
    private TextView storeTextView;
    private TextView storeDescTextView;
    private TextView storeDescStatusTextView;
    private TextView storeServerTextView;
    private TextView storeServerStatusTextView;
    private TextView storeDeliveryTextView;
    private TextView storeDeliveryStatusTextView;
    private ListView mListView;

    private TextView backgroundTextView;
    private RelativeLayout qrCodeRelativeLayout;
    private ImageView qrCodeCloseImageView;
    private ImageView qrCodeContentImageView;
    private TextView qrCodeOtherTextView;

    private LinearLayout bottomLinearLayout;
    private TextView keFuTextView;
    private TextView cartTextView;
    private TextView joinCartTextView;
    private TextView buyTextView;

    private RelativeLayout chooseRelativeLayout;
    private ImageView chooseImageView;
    private TextView chooseNameTextView;
    private TextView choosePriceTextView;
    private TextView chooseStorageTextView;
    private TextView chooseSpec1TextView;
    private HorizontalScrollView chooseSpec1ScrollView;
    private HorizontalScrollView chooseSpec2ScrollView;
    private TextView[] chooseSpec1AttrTextView;
    private TextView chooseSpec2TextView;
    private TextView[] chooseSpec2AttrTextView;
    private View chooseLine2View;
    private View chooseLine3View;
    private Button chooseAddButton;
    private EditText chooseNumberEditText;
    private Button chooseSubButton;
    private Button chooseCartButton;
    private Button chooseBuyButton;

    private Map<String, String> map = new HashMap<>();
    private GoodsDetail_Presenter presenter;
    private RecyclerView recyclerView;
    private GoodsDetailRecyAdapter adapter;
    private String goods_id1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        initView();
        initData();
        initOnClick();
    }

    private void initOnClick() {
        leftImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnActivity();
            }
        });
    }

    private void initData() {
        Intent intent = getIntent();
        goods_id = intent.getStringExtra("goods_id");
        key = Constant.mSharedPreferences.getString("key", "");
        presenter = new GoodsDetail_Presenter();
        presenter.attachView(GoodsDetailActivity.this);

        adapter = new GoodsDetailRecyAdapter(this);
        recyclerView.setAdapter(adapter);
        map.put("act", "goods");
        map.put("op", "goods_detail");
        map.put("goods_id", goods_id);
        presenter.getGoodsDetailData(map);
        adapter.setOnClick(new Recy_OnClick() {
            @Override
            public void onClick(View view, int position, String gc_id) {
                Intent intent1 = new Intent(GoodsDetailActivity.this, GoodsDetailActivity.class);
                intent1.putExtra("goods_id", gc_id);
                startActivity(intent1);
                finish();
            }
        });
    }

    private void initView() {
        joincart = (TextView) findViewById(R.id.joinCartTextView);
        joincart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showChoose();
//                Log.e("joincart", "onclick" );
//                CartAddPresenter cartp=new CartAddPresenter();
//                cartp.attachView(GoodsDetailActivity.this);
//                cartp.cartadd("","");
            }
        });
        mActivity = this;
        isCollection = false;
        //实例化控件
        leftImageView = (ImageView) findViewById(R.id.leftImageView);
        titleTextView = (TextView) findViewById(R.id.titleTextView);
        rightImageView = (ImageView) findViewById(R.id.rightImageView);
        right1ImageView = (ImageView) findViewById(R.id.right1ImageView);
        mScrollView = (ScrollView) findViewById(R.id.mainScrollView);
        goodsViewPager = (ImageView) findViewById(R.id.goodsViewPager);
        nameTextView = (TextView) findViewById(R.id.nameTextView);
        jingleTextView = (TextView) findViewById(R.id.jingleTextView);
        pricePromotionTextView = (TextView) findViewById(R.id.pricePromotionTextView);
        priceTextView = (TextView) findViewById(R.id.priceTextView);
        saleNumTextView = (TextView) findViewById(R.id.saleNumTextView);
        activityLinearLayout = (LinearLayout) findViewById(R.id.activityLinearLayout);
        activityNameTextView = (TextView) findViewById(R.id.activityNameTextView);
        activityRemarkTextView = (TextView) findViewById(R.id.activityRemarkTextView);
        addressTextView = (TextView) findViewById(R.id.addressTextView);
        addressTipTextView = (TextView) findViewById(R.id.addressTipTextView);
        chooseLinearLayout = (LinearLayout) findViewById(R.id.chooseLinearLayout);
        choose1TextView = (TextView) findViewById(R.id.choose1TextView);
        choose2TextView = (TextView) findViewById(R.id.choose2TextView);
        commentTextView = (TextView) findViewById(R.id.commentTextView);
        commentNumTextView = (TextView) findViewById(R.id.commentNumTextView);
        bodyTextView = (TextView) findViewById(R.id.bodyTextView);
        storeTextView = (TextView) findViewById(R.id.storeTextView);
        storeDescTextView = (TextView) findViewById(R.id.storeDescTextView);
        storeDescStatusTextView = (TextView) findViewById(R.id.storeDescStatusTextView);
        storeServerTextView = (TextView) findViewById(R.id.storeServerTextView);
        storeServerStatusTextView = (TextView) findViewById(R.id.storeServerStatusTextView);
        storeDeliveryTextView = (TextView) findViewById(R.id.storeDeliveryTextView);
        storeDeliveryStatusTextView = (TextView) findViewById(R.id.storeDeliveryStatusTextView);

        backgroundTextView = (TextView) findViewById(R.id.backgroundTextView);
        qrCodeRelativeLayout = (RelativeLayout) findViewById(R.id.qrCodeRelativeLayout);
        qrCodeCloseImageView = (ImageView) findViewById(R.id.qrCodeCloseImageView);
        qrCodeContentImageView = (ImageView) findViewById(R.id.qrCodeContentImageView);
        qrCodeOtherTextView = (TextView) findViewById(R.id.qrCodeOtherTextView);

        bottomLinearLayout = (LinearLayout) findViewById(R.id.bottomLinearLayout);
        keFuTextView = (TextView) findViewById(R.id.kefuTextView);
        cartTextView = (TextView) findViewById(R.id.cartTextView);
        joinCartTextView = (TextView) findViewById(R.id.joinCartTextView);
        buyTextView = (TextView) findViewById(R.id.buyTextView);

        chooseRelativeLayout = (RelativeLayout) findViewById(R.id.chooseRelativeLayout);
        chooseImageView = (ImageView) findViewById(R.id.chooseImageView);
        chooseNameTextView = (TextView) findViewById(R.id.chooseNameTextView);
        choosePriceTextView = (TextView) findViewById(R.id.choosePriceTextView);
        chooseStorageTextView = (TextView) findViewById(R.id.chooseStorageTextView);
        chooseSpec1ScrollView = (HorizontalScrollView) findViewById(R.id.chooseSpec1ScrollView);
        chooseSpec2ScrollView = (HorizontalScrollView) findViewById(R.id.chooseSpec2ScrollView);
        chooseSpec1TextView = (TextView) findViewById(R.id.chooseSpec1TextView);
        chooseSpec2TextView = (TextView) findViewById(R.id.chooseSpec2TextView);
        chooseLine2View = findViewById(R.id.chooseLine2View);
        chooseLine3View = findViewById(R.id.chooseLine3View);
        chooseAddButton = (Button) findViewById(R.id.chooseAddButton);
        chooseNumberEditText = (EditText) findViewById(R.id.chooseNumberEditText);
        chooseSubButton = (Button) findViewById(R.id.chooseSubButton);
        chooseCartButton = (Button) findViewById(R.id.chooseCartButton);
        chooseBuyButton = (Button) findViewById(R.id.chooseBuyButton);
        recyclerView = (RecyclerView) findViewById(R.id.goodsdetailrecy);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        chooseSpec1AttrTextView = new TextView[10];
        chooseSpec2AttrTextView = new TextView[10];
        for (int i = 0; i < 10; i++) {
            chooseSpec1AttrTextView[i] = (TextView) findViewById(R.id.chooseSpec1Attr1TextView + i);
            chooseSpec2AttrTextView[i] = (TextView) findViewById(R.id.chooseSpec2Attr1TextView + i);
            chooseSpec1AttrTextView[i].setVisibility(View.GONE);
            chooseSpec2AttrTextView[i].setVisibility(View.GONE);
        }

        //初始化参数
        titleTextView.setText("商品详细");
        chooseCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("joincart", "onclick");
                CartAddPresenter cartp = new CartAddPresenter();
                cartp.attachView(GoodsDetailActivity.this);
                cartp.cartadd(goods_id, "1");

                backgroundTextView.setVisibility(View.GONE);
                chooseRelativeLayout.setVisibility(View.GONE);


                bottomLinearLayout.setVisibility(View.VISIBLE);
            }
        });

    }

    private void showChoose() {

        backgroundTextView.setVisibility(View.GONE);
        chooseRelativeLayout.setVisibility(View.GONE);
        qrCodeRelativeLayout.setVisibility(View.GONE);
        bottomLinearLayout.setVisibility(View.GONE);
        backgroundTextView.setVisibility(View.VISIBLE);
        chooseRelativeLayout.setVisibility(View.VISIBLE);
        backgroundTextView.startAnimation(Constant.showAlphaAnimation);
        chooseRelativeLayout.startAnimation(Constant.showAlphaAnimation);

        chooseAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = chooseNumberEditText.getText().toString();
                if (temp.isEmpty()) {
                    chooseNumberEditText.setText("1");
                } else {
                    int number = Integer.parseInt(temp);
                    temp = number + 1 + "";
                    chooseNumberEditText.setText(temp);
                }
                chooseNumberEditText.setSelection(chooseNumberEditText.getText().toString().length());
            }
        });

        chooseSubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = chooseNumberEditText.getText().toString();
                if (temp.isEmpty()) {
                    chooseNumberEditText.setText("1");
                } else {
                    if (!temp.equals("0")) {
                        int number = Integer.parseInt(temp);
                        temp = number - 1 + "";
                        chooseNumberEditText.setText(temp);
                    }
                }
                chooseNumberEditText.setSelection(chooseNumberEditText.getText().toString().length());
            }
        });

    }

    private void returnActivity() {

        if (qrCodeRelativeLayout.getVisibility() == View.VISIBLE || chooseRelativeLayout.getVisibility() == View.VISIBLE) {
            chooseRelativeLayout.setVisibility(View.GONE);
            qrCodeRelativeLayout.setVisibility(View.GONE);
            backgroundTextView.setVisibility(View.GONE);
        } else {
            finish();
        }

    }

    @Override
    public void attachData(final Goods_Detail_Bean goods_detail_bean) {
        if (goods_detail_bean != null) {
            final Goods_Detail_Bean.DatasBean.GoodsInfoBean goods_info = goods_detail_bean.getDatas().getGoods_info();
            nameTextView.setText(goods_info.getGoods_name());
            List<Goods_Detail_Bean.DatasBean.GoodsCommendListBean> goods_commend_list = goods_detail_bean.getDatas().getGoods_commend_list();
            adapter.setData(goods_commend_list, presenter);
            Log.d("memeda", "attachData: " + goods_detail_bean.getDatas().getSpec_image());
            Glide.with(this).load(goods_detail_bean.getDatas().getSpec_image().get(0)).placeholder(R.mipmap.ic_normal_class).into(goodsViewPager);
            jingleTextView.setText(goods_info.getGoods_jingle());
            pricePromotionTextView.setText("￥" + goods_info.getGoods_promotion_price());
            priceTextView.setText("￥" + goods_info.getGoods_price());
            saleNumTextView.setText(Html.fromHtml("销量 : <font color='#FF0000'>" + goods_info.getGoods_salenum() + "</font> 件"));
            activityNameTextView.setText("直降");
            activityRemarkTextView.setText("￥300");
            addressTextView.setText("全国");
            addressTipTextView.setText("有货：免运费");
            commentTextView.setText("好评率:100%");
            commentNumTextView.setText("0人评价");
            storeTextView.setText("好商城V5");
            storeDescTextView.setText("描述:5.0分");
            storeServerTextView.setText("服务:5.0分");
            storeDeliveryTextView.setText("物流:5.0分");
            bodyTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mActivity, GoodsIntroduceActivity.class);
                    intent.putExtra("Link", goods_info.getGoods_url());
                    startActivity(intent);
                }
            });
            goodsViewPager.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(GoodsDetailActivity.this, PhotoActivity.class);
                    intent.putExtra("img", goods_detail_bean.getDatas().getSpec_image().get(0));
                    startActivity(intent);
                }
            });

        }
    }

    @Override
    public void ondata(CartAddBean cartAddBean) {

        if(cartAddBean.getCode()==200){
            Toast.makeText(GoodsDetailActivity.this,"加入购物车成功了哈哈哈哈哈哈哈哈啊哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈",Toast.LENGTH_SHORT).show();
        }
    }
}
