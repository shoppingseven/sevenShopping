package qiuhaitao.bwie.com.mall.presenter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import qiuhaitao.bwie.com.mall.R;
import qiuhaitao.bwie.com.mall.view.iview.IView;

/**
 * Created by ASUS on 2017/6/9.
 */

public class BasePresenter<T extends IView> {
    private T mt;
    public void attachView(T t){
        this.mt = t;
    }
    public T getView(){
        return mt;
    }
    public void setImg(Context context, String imgUri, ImageView img){
        Glide.with(context).load(imgUri).placeholder(R.mipmap.ic_normal_class).into(img);
    }
}
