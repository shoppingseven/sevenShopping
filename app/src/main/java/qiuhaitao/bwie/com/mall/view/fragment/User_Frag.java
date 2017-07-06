package qiuhaitao.bwie.com.mall.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import qiuhaitao.bwie.com.mall.R;
import qiuhaitao.bwie.com.mall.model.utils.Constant;
import qiuhaitao.bwie.com.mall.view.activity.Login_Activity;
import qiuhaitao.bwie.com.mall.view.activity.UsercenterActivity;

/**
 * Created by ASUS on 2017/6/10.
 */

public class User_Frag extends Fragment implements View.OnClickListener {
    private ImageView headImageView;
    private TextView usernameTextView;
    private TextView collectionGoodsTextView;
    private TextView collectionStoreTextView;
    private TextView myFootprintTextView;
    private RelativeLayout userRelativeLayout;
    private TextView orderTextView;
    private TextView orderWaitPayTextView;
    private TextView orderWaitDriveTextView;
    private TextView orderWaitReceiptTextView;
    private TextView orderWaitCommentTextView;
    private TextView orderWaitRefundTextView;
    private LinearLayout orderLinearLayout;
    private TextView propertyTextView;
    private TextView propertyMoneyTextView;
    private TextView propertyCardTextView;
    private TextView propertyVouchersTextView;
    private TextView propertyRedTextView;
    private TextView propertyIntegralTextView;
    private LinearLayout propertyLinearLayout;
    private TextView addressTextView;
    private TextView settingTextView;
    private LinearLayout mainLinearLayout;
    private ScrollView mainScrollView;
    boolean flag;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_frag, null);
        initView(view);

        flag = Constant.mSharedPreferences.getBoolean("User_Login",false);
        Log.d("memeda", "onCreateView: "+flag);
        String Username = Constant.mSharedPreferences.getString("User_Username","0");
        Log.d("memeda", "onCreateView: "+Username);
        if (flag){
            usernameTextView.setText(Username);
        }

        return view;
    }

    private void initView(View view) {
        headImageView = (ImageView) view.findViewById(R.id.headImageView);
        usernameTextView = (TextView) view.findViewById(R.id.usernameTextView);
        collectionGoodsTextView = (TextView) view.findViewById(R.id.collectionGoodsTextView);
        collectionStoreTextView = (TextView) view.findViewById(R.id.collectionStoreTextView);
        myFootprintTextView = (TextView) view.findViewById(R.id.myFootprintTextView);
        userRelativeLayout = (RelativeLayout) view.findViewById(R.id.userRelativeLayout);
        orderTextView = (TextView) view.findViewById(R.id.orderTextView);
        orderWaitPayTextView = (TextView) view.findViewById(R.id.orderWaitPayTextView);
        orderWaitDriveTextView = (TextView) view.findViewById(R.id.orderWaitDriveTextView);
        orderWaitReceiptTextView = (TextView) view.findViewById(R.id.orderWaitReceiptTextView);
        orderWaitCommentTextView = (TextView) view.findViewById(R.id.orderWaitCommentTextView);
        orderWaitRefundTextView = (TextView) view.findViewById(R.id.orderWaitRefundTextView);
        orderLinearLayout = (LinearLayout) view.findViewById(R.id.orderLinearLayout);
        propertyTextView = (TextView) view.findViewById(R.id.propertyTextView);
        propertyMoneyTextView = (TextView) view.findViewById(R.id.propertyMoneyTextView);
        propertyCardTextView = (TextView) view.findViewById(R.id.propertyCardTextView);
        propertyVouchersTextView = (TextView) view.findViewById(R.id.propertyVouchersTextView);
        propertyRedTextView = (TextView) view.findViewById(R.id.propertyRedTextView);
        propertyIntegralTextView = (TextView) view.findViewById(R.id.propertyIntegralTextView);
        propertyLinearLayout = (LinearLayout) view.findViewById(R.id.propertyLinearLayout);
        addressTextView = (TextView) view.findViewById(R.id.addressTextView);
        settingTextView = (TextView) view.findViewById(R.id.settingTextView);
        mainLinearLayout = (LinearLayout) view.findViewById(R.id.mainLinearLayout);
        mainScrollView = (ScrollView) view.findViewById(R.id.mainScrollView);

        usernameTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.usernameTextView:
                if (flag){
                    Intent intent = new Intent(getActivity(), UsercenterActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getActivity(), Login_Activity.class);
                    // startActivityForResult(intent,200);
                    startActivity(intent);
                    getActivity().finish();
                }

                break;

            default:
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Constant.mSharedPreferencesEditor.clear();
    }
   /* @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data!=null){
            String user = data.getStringExtra("user");
            usernameTextView.setText(user);
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainrela,new Home_Frag()).commit();
        }

    }*/
}
