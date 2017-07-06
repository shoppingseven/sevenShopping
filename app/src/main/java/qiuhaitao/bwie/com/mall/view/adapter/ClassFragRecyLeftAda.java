package qiuhaitao.bwie.com.mall.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import qiuhaitao.bwie.com.mall.R;
import qiuhaitao.bwie.com.mall.model.bean.ClassFrag_GoodsClassBean;
import qiuhaitao.bwie.com.mall.presenter.ClassFrag_Presenter;
import qiuhaitao.bwie.com.mall.view.iview.Recy_OnClick;

/**
 * Created by ASUS on 2017/6/14.
 */

public class ClassFragRecyLeftAda extends RecyclerView.Adapter<ClassFragRecyLeftAda.MyViewHolder> {
    Context context;
    List<ClassFrag_GoodsClassBean.DatasBean.ClassListBean> class_list = new ArrayList<>();
    private Recy_OnClick onClick;
    private ClassFrag_Presenter presenter;
    public void setOnClick(Recy_OnClick recy_onClick){
        this.onClick = recy_onClick;
    }
    public ClassFragRecyLeftAda(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = View.inflate(context,R.layout.item_classfragrecy_left,null);
        final MyViewHolder viewHolder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getLayoutPosition();
                String gc_id = class_list.get(position).getGc_id();
                onClick.onClick(v,position,gc_id);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        //Glide.with(context).load(class_list.get(position).getImage()).placeholder(R.mipmap.ic_normal_class).into(holder.imageView);
        presenter.setImg(context,class_list.get(position).getImage(),holder.imageView);
        holder.textView.setText(class_list.get(position).getGc_name());
    }

    @Override
    public int getItemCount() {
        return class_list.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView imageView;
        private final TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_classfrag_ImageView);
            textView = (TextView) itemView.findViewById(R.id.item_classfrag_TextView);
        }
    }
    public void setData( List<ClassFrag_GoodsClassBean.DatasBean.ClassListBean> data,ClassFrag_Presenter presenter){
        this.class_list = data;
        this.presenter = presenter;
        notifyDataSetChanged();
    }
}
