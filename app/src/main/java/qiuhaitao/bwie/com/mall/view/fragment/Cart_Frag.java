package qiuhaitao.bwie.com.mall.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;

import qiuhaitao.bwie.com.mall.R;
import qiuhaitao.bwie.com.mall.model.bean.CartListsBean;
import qiuhaitao.bwie.com.mall.model.utils.Constant;
import qiuhaitao.bwie.com.mall.presenter.CartDeletePresenter;
import qiuhaitao.bwie.com.mall.presenter.CartListPresenter;
import qiuhaitao.bwie.com.mall.view.adapter.CartListAdapter;
import qiuhaitao.bwie.com.mall.view.iview.CartDelete_Iview;
import qiuhaitao.bwie.com.mall.view.iview.CartList_Iview;

/**
 * Created by ASUS on 2017/6/10.
 */

public class Cart_Frag extends Fragment implements CartList_Iview<CartListsBean> {
    private ListView mainListView;
    private SwipeRefreshLayout mainSwipeRefreshLayout;
    private TextView statusTextView;
    private TextView buyTextView;
    private TextView tipsTextView;
    private boolean flag;
    private CartListAdapter adapter;
    private CheckBox cball;
    private Button delete;
    private CartListPresenter cp;
    private TextView money_textview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cart_frag, null);
        initView(view);
        initdata();
        return view;
    }

    private void initdata() {
        cp = new CartListPresenter();
        cp.attachView(this);
        cp.cartList();
    }

    private void initView(View view) {
        cball = (CheckBox) view.findViewById(R.id.checkall);
        mainListView = (ListView) view.findViewById(R.id.mainListView);
        mainSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.mainSwipeRefreshLayout);
        statusTextView = (TextView) view.findViewById(R.id.statusTextView);
        buyTextView = (TextView) view.findViewById(R.id.cart_frag_buyTextView);
        tipsTextView = (TextView) view.findViewById(R.id.tipsTextView);
        delete = (Button) view.findViewById(R.id.delete);
        money_textview = (TextView) view.findViewById(R.id.money_textview);
        adapter = new CartListAdapter(getActivity());
        mainListView.setAdapter(adapter);
        flag = Constant.mSharedPreferences.getBoolean("User_Login", false);
        if (!flag) {
            buyTextView.setVisibility(View.GONE);
            statusTextView.setVisibility(View.GONE);
        } else {
            tipsTextView.setVisibility(View.GONE);
        }
    }

    @Override
    public void ondata(final CartListsBean cartListsBean) {
        adapter.setList(cartListsBean);
        adapter.notifyDataSetChanged();
        cball.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CartListsBean list = adapter.getList();
                if (list != null && list.getDatas().getCart_list().size() != 0 && list.getDatas().getCart_list().get(0).getGoods().size() != 0) {
                    for (CartListsBean.DatasBean.CartListBean.GoodsBean gb :
                            list.getDatas().getCart_list().get(0).getGoods()) {
                        gb.setIscheck(isChecked);
                        adapter.notifyDataSetChanged();
                    }
                }

            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartDeletePresenter cdp = new CartDeletePresenter();
                cdp.attachView(new CartDelete_Iview<String>() {
                    @Override
                    public void ondata(String cartAddBean) {
                        Log.e("delete", cartAddBean.toString());
                        cp.cartList();
                    }

                });
                CartListsBean list = adapter.getList();
                for (CartListsBean.DatasBean.CartListBean.GoodsBean gb :
                        list.getDatas().getCart_list().get(0).getGoods()) {
                    if (gb.ischeck()) {
                        cdp.cartDelete(Constant.mSharedPreferences.getString("key", ""), gb.getCart_id());

                    }
                }

            }
        });
        Log.e("1111", cartListsBean.toString());

        Log.e("cart", cartListsBean.toString());
        statusTextView.setVisibility(View.GONE);
    }
}
