package qiuhaitao.bwie.com.mall.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import qiuhaitao.bwie.com.mall.R;

/**
 * Created by ASUS on 2017/6/10.
 */

public class Cart_Frag extends Fragment {
    private ListView mainListView;
    private SwipeRefreshLayout mainSwipeRefreshLayout;
    private TextView statusTextView;
    private TextView buyTextView;
    private TextView tipsTextView;
    private boolean flag;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cart_frag, null);

        initView(view);
        return view;
    }

    private void initView(View view) {

        mainListView = (ListView) view.findViewById(R.id.mainListView);
        mainSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.mainSwipeRefreshLayout);
        statusTextView = (TextView) view.findViewById(R.id.statusTextView);
        buyTextView = (TextView) view.findViewById(R.id.cart_frag_buyTextView);
        tipsTextView = (TextView) view.findViewById(R.id.tipsTextView);

        flag =  getActivity().getSharedPreferences("islogin", Context.MODE_PRIVATE).getBoolean("flag",false);
        if (!flag){
            buyTextView.setVisibility(View.GONE);
            statusTextView.setVisibility(View.GONE);
        }
    }
}
