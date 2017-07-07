package qiuhaitao.bwie.com.mall.presenter;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import qiuhaitao.bwie.com.mall.model.bean.CartAddBean;
import qiuhaitao.bwie.com.mall.model.utils.HttpUtils;
import qiuhaitao.bwie.com.mall.view.iview.Cart_Iview;

/**
 * 作者:郭凯奇
 * 时间: 2017/7/6 21:19
 * Title:
 * Text:
 */

public class CartDeletePresenter extends BasePresenter<Cart_Iview>{
    public void cartDelete(String goods_id,String qu){
        HttpUtils.cartadd(goods_id, qu, new Observer<CartAddBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(CartAddBean value) {
                getView().ondata(value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }


}
