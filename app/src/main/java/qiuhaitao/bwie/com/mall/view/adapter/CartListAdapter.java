package qiuhaitao.bwie.com.mall.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import qiuhaitao.bwie.com.mall.R;
import qiuhaitao.bwie.com.mall.constom.AmountView;
import qiuhaitao.bwie.com.mall.model.bean.CartListsBean;


public class CartListAdapter extends BaseAdapter {
    private Context context;
    private Totalcallback cb;

    public void setCb(Totalcallback cb) {
        this.cb = cb;
    }
    private CartListsBean list;
    public CartListsBean getList() {
        return list;
    }

    public CartListAdapter(Context context) {
        this.context = context;
    }



    public void setList(CartListsBean list) {

        if (list!=null){
            this.list = list;
        }

    }

    @Override
    public int getCount() {
        if(list!=null&&list.getDatas().getCart_list().size()!=0&&list.getDatas().getCart_list().get(0).getGoods().size()!=0){
            return list.getDatas().getCart_list().get(0).getGoods().size();
            
        }else{
            return 0;
        }

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
            h.check = (CheckBox) convertView.findViewById(R.id.check);
            h.image= (ImageView) convertView.findViewById(R.id.image);
            h.goods_money= (TextView) convertView.findViewById(R.id.goods_money);
            h.title= (TextView) convertView.findViewById(R.id.textView);
            h.goods_num= (TextView) convertView.findViewById(R.id.goods_num);
//            h.goods_money_subtotal= (TextView) convertView.findViewById(R.id.goods_money_subtotal);
            h.av= (AmountView) convertView.findViewById(R.id.av);
            convertView.setTag(h);
        }else{
            h = (Holder) convertView.getTag();
        }
        final CartListsBean.DatasBean.CartListBean.GoodsBean goodsBean = list.getDatas().getCart_list().get(0).getGoods().get(position);
        Glide.with(context).load(goodsBean.getGoods_image_url()).into(h.image);
        h.goods_money.setText(goodsBean.getGoods_price());
        h.goods_num.setText(goodsBean.getGoods_num());
        h.title.setText(goodsBean.getGoods_name());
        h.check.setChecked(goodsBean.ischeck());
        h.av.setOnAmountChangeListener(new AmountView.OnAmountChangeListener() {
            @Override
            public void onAmountChange(View view, int amount) {
                Double aDouble = Double.valueOf(goodsBean.getGoods_price());
                Log.e("-======", aDouble+"====="+amount );
                h.goods_money.setText((amount * aDouble)+"");
                h.goods_num.setText("x"+amount);
                goodsBean.setGoods_num(""+amount);
                goodsBean.setGoods_total((amount * aDouble)+"");
                cb.total(list);
            }
        });
        h.check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                goodsBean.setIscheck(isChecked);
                notifyDataSetChanged();
            }
        });
        return convertView;
    }
    class Holder{
        TextView title;
        ImageView image;
        TextView goods_money;
        TextView goods_num;
        AmountView av;
        CheckBox check;
    }
    public interface Totalcallback{
       void total(CartListsBean listsBean);
    }
}
