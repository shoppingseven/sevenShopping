package qiuhaitao.bwie.com.mall.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import qiuhaitao.bwie.com.mall.R;
import qiuhaitao.bwie.com.mall.model.bean.ClassFrag_GoodsClassIdNameBean;
import qiuhaitao.bwie.com.mall.view.activity.Goods_search_Activity;

/**
 * Created by 仇海涛 on 2017/6/24.
 * class ：
 * content ：
 */

public class ClassFragExpandableGdAdapter extends BaseAdapter {
    List<ClassFrag_GoodsClassIdNameBean.DatasBean.ClassListBean> list = new ArrayList<>();
    Context context;

    public ClassFragExpandableGdAdapter(Context context) {
        this.context = context;
    }

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

        Holder holder = null;
        if (convertView==null){
            holder = new Holder();
            convertView = View.inflate(context, R.layout.item_classfrag_expandablelv_gd_text,null);
            holder.textView = (TextView) convertView.findViewById(R.id.gridview_item);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.textView.setText(list.get(position).getGc_name());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Goods_search_Activity.class);
                context.startActivity(intent);
            }
        });
        return convertView;
    }

    public void setData(List<ClassFrag_GoodsClassIdNameBean.DatasBean.ClassListBean> data) {
        this.list = data;
        notifyDataSetChanged();
    }

    static class Holder{
        TextView textView;
    }
}
