package qiuhaitao.bwie.com.mall.presenter;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import qiuhaitao.bwie.com.mall.model.bean.CartAddBean;
import qiuhaitao.bwie.com.mall.model.utils.HttpUtils;
import qiuhaitao.bwie.com.mall.view.iview.Cart_Iview;


public class CartAddPresenter extends BasePresenter<Cart_Iview>{
    public void cartadd(String goods_id,String qu){
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
