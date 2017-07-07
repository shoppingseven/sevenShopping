package qiuhaitao.bwie.com.mall.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import qiuhaitao.bwie.com.mall.R;
import qiuhaitao.bwie.com.mall.model.bean.CartListsBean;

/**
 * 作者:郭凯奇
 * 时间: 2017/7/7 9:56
 * Title:
 * Text:
 */

public class CartListAdapter extends BaseAdapter {
    private Context context;

    public CartListAdapter(Context context) {
        this.context = context;
    }

    private List<CartListsBean> list=new ArrayList<>();

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=View.inflate(context, R.layout.item_cartlist,null);
        }
        return convertView;
    }
}
