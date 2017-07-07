package qiuhaitao.bwie.com.mall.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import qiuhaitao.bwie.com.mall.R;
import qiuhaitao.bwie.com.mall.model.bean.CartListsBean;
import qiuhaitao.bwie.com.mall.model.utils.Constant;
import qiuhaitao.bwie.com.mall.presenter.CartListPresenter;
import qiuhaitao.bwie.com.mall.view.adapter.CartListAdapter;
import qiuhaitao.bwie.com.mall.view.iview.CartList_Iview;

/**
 * Created by ASUS on 2017/6/10.
 */

public class Cart_Frag extends Fragment implements CartList_Iview<CartListsBean>{
    private ListView mainListView;
    private SwipeRefreshLayout mainSwipeRefreshLayout;
    private TextView statusTextView;
    private TextView buyTextView;
    private TextView tipsTextView;
    private boolean flag;
    private CartListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cart_frag, null);
        initView(view);
        initdata();
        return view;
    }

    private void initdata() {
        CartListPresenter cp=new CartListPresenter();
        cp.attachView(this);
        cp.cartList();
    }

    private void initView(View view) {
        mainListView = (ListView) view.findViewById(R.id.mainListView);
        mainSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.mainSwipeRefreshLayout);
        statusTextView = (TextView) view.findViewById(R.id.statusTextView);
        buyTextView = (TextView) view.findViewById(R.id.cart_frag_buyTextView);
        tipsTextView = (TextView) view.findViewById(R.id.tipsTextView);
        adapter = new CartListAdapter(getActivity());

        flag = Constant.mSharedPreferences.getBoolean("User_Login", false);
        if (!flag){
            buyTextView.setVisibility(View.GONE);
            statusTextView.setVisibility(View.GONE);
        }else{
            tipsTextView.setVisibility(View.GONE);
        }
    }
    @Override
    public void ondata(CartListsBean cartListsBean) {

       adapter.setList(cartListsBean);
        Log.e("1111", cartListsBean.toString() );
        mainListView.setAdapter(adapter);
        Log.e("cart",cartListsBean.toString());
        statusTextView.setVisibility(View.GONE);

    }
}
