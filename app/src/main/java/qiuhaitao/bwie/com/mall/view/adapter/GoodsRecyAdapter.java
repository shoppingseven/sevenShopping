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
import qiuhaitao.bwie.com.mall.model.bean.Goods_Search_Bean;
import qiuhaitao.bwie.com.mall.presenter.GoodsSearch_Presenter;
import qiuhaitao.bwie.com.mall.view.iview.Recy_OnClick;

/**
 * Created by 仇海涛 on 2017/7/5.
 * class ：
 * content ：
 */

public class GoodsRecyAdapter extends RecyclerView.Adapter <GoodsRecyAdapter.MyViewHolder>{
    Context context;
    private List<Goods_Search_Bean.DatasBean.GoodsListBean> data = new ArrayList<>();
    private GoodsSearch_Presenter presenter;
    public GoodsRecyAdapter(Context context) {
        this.context = context;
    }
    private Recy_OnClick onClick ;
    public void setOnClick(Recy_OnClick onClick){
        this.onClick = onClick;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_recyclerview_goods,null);
        final MyViewHolder viewHolder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getLayoutPosition();
                onClick.onClick(v,position,data.get(position).getGoods_id()+"");
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        presenter.setImg(context,data.get(position).getGoods_image_url(),holder.verImageView);
        holder.verTitleTextView.setText(data.get(position).getGoods_name());
        holder.verPromotionPriceTextView.setText(data.get(position).getGoods_price());
        holder.verPriceTextView.setText("已售："+data.get(position).getIs_presell()+"件");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<Goods_Search_Bean.DatasBean.GoodsListBean> data,GoodsSearch_Presenter presenter) {
        this.data = data;
        this.presenter = presenter;

       notifyDataSetChanged();
    }


    static class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView verImageView;

        private final TextView verTitleTextView;

        private final TextView verPromotionPriceTextView;
        private final TextView verPriceTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            verImageView = (ImageView) itemView.findViewById(R.id.verImageView);

            verTitleTextView = (TextView) itemView.findViewById(R.id.verTitleTextView);

            verPromotionPriceTextView = (TextView) itemView.findViewById(R.id.verPricePromotionTextView);
            verPriceTextView = (TextView) itemView.findViewById(R.id.verPriceTextView);
        }
    }
}
