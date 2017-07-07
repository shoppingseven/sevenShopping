package qiuhaitao.bwie.com.mall.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import qiuhaitao.bwie.com.mall.R;
import qiuhaitao.bwie.com.mall.constom.AmountView;
import qiuhaitao.bwie.com.mall.model.bean.CartListsBean;


public class CartListAdapter extends BaseAdapter {
    private Context context;

    public CartListAdapter(Context context) {
        this.context = context;
    }

    private CartListsBean list=new CartListsBean();

    public void setList(CartListsBean list) {

        if (list!=null){
            this.list = list;
        }

    }

    @Override
    public int getCount() {
        return list.getDatas().getCart_list().get(0).getGoods().size();
    }

    @Override
    public Object getItem(int position) {
        return list.getDatas().getCart_list().get(0).getGoods().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Holder h;
        if(convertView==null){
            h=new Holder();
            convertView=View.inflate(context, R.layout.item_cartlist,null);
            h.image= (ImageView) convertView.findViewById(R.id.image);
            h.goods_money= (TextView) convertView.findViewById(R.id.goods_money);
            h.title= (TextView) convertView.findViewById(R.id.textView);
            h.goods_num= (TextView) convertView.findViewById(R.id.goods_num);
            h.goods_money_subtotal= (TextView) convertView.findViewById(R.id.goods_money_subtotal);
            h.av= (AmountView) convertView.findViewById(R.id.av);
            convertView.setTag(h);
        }else{
            h = (Holder) convertView.getTag();
        }
        CartListsBean.DatasBean.CartListBean.GoodsBean goodsBean = list.getDatas().getCart_list().get(0).getGoods().get(position);
        Glide.with(context).load(goodsBean.getGoods_image_url()).into(h.image);
        h.goods_money.setText(goodsBean.getGoods_price());
        h.goods_money_subtotal.setText(goodsBean.getGoods_total());
        h.goods_num.setText(goodsBean.getGoods_num());
        h.av.setGoods_storage(2);
        h.title.setText(goodsBean.getGoods_name());
        h.av.setOnAmountChangeListener(new AmountView.OnAmountChangeListener() {
            @Override
            public void onAmountChange(View view, int amount) {
                Double aDouble = Double.valueOf(h.goods_money.getText().toString());
                h.goods_money.setText((amount * aDouble)+"");
                h.goods_num.setText(amount+"");
            }
        });
        return convertView;
    }
    class Holder{
        TextView title;
        ImageView image;
        TextView goods_money;
        TextView goods_num;
        TextView goods_money_subtotal;
        AmountView av;
    }
}
