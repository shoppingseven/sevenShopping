package qiuhaitao.bwie.com.mall.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import qiuhaitao.bwie.com.mall.R;
import qiuhaitao.bwie.com.mall.model.bean.ClassFrag_GoodsClassIdBean;
import qiuhaitao.bwie.com.mall.model.bean.ClassFrag_GoodsClassIdNameBean;

/**
 * Created by 仇海涛 on 2017/6/24.
 * class ：
 * content ：
 */

public class ClassFragExpandableLvAdapter extends BaseExpandableListAdapter {
    Context context ;

    public ClassFragExpandableLvAdapter(Context context) {
        this.context = context;
    }
    List<ClassFrag_GoodsClassIdBean.DatasBean.ClassListBean> group_list = new ArrayList<>();
    List<List<ClassFrag_GoodsClassIdNameBean.DatasBean.ClassListBean>> childrenlist = new ArrayList();

    @Override
    public int getGroupCount() {
        return group_list.size();

    }

    @Override
    public int getChildrenCount(int groupPosition) {

        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        convertView = View.inflate(context, R.layout.item_classfrag_expandablelv_text,null);
        TextView textView = (TextView) convertView.findViewById(R.id.item_classfrag_expandablelv_textview);
        textView.setText(group_list.get(groupPosition).getGc_name());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        convertView = (RelativeLayout) RelativeLayout.inflate(context,
                R.layout.item_classfrag_expandablelv_gd, null);
       // convertView = View.inflate(context,R.layout.item_classfrag_expandablelv_gd,null);
        MyGridView gridView = (MyGridView) convertView.findViewById(R.id.gridview);
        ClassFragExpandableGdAdapter adapter = new ClassFragExpandableGdAdapter(context);
        adapter.setData(childrenlist.get(groupPosition));
        gridView.setAdapter(adapter);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    public void setData(List<ClassFrag_GoodsClassIdBean.DatasBean.ClassListBean> class_listIdBean, List<List<ClassFrag_GoodsClassIdNameBean.DatasBean.ClassListBean>> list) {
        if (class_listIdBean!=null){
            this.group_list = class_listIdBean;
        }
        if (list!=null){
            this.childrenlist = list;
        }

        notifyDataSetChanged();
    }
}
