package qiuhaitao.bwie.com.mall.presenter;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import qiuhaitao.bwie.com.mall.model.bean.CartAddBean;
import qiuhaitao.bwie.com.mall.model.bean.CartListsBean;
import qiuhaitao.bwie.com.mall.model.utils.HttpUtils;
import qiuhaitao.bwie.com.mall.view.iview.CartList_Iview;
import qiuhaitao.bwie.com.mall.view.iview.Cart_Iview;

/**
 * 作者:郭凯奇
 * 时间: 2017/7/6 21:19
 * Title:
 * Text:
 */

public class CartListPresenter extends BasePresenter<CartList_Iview>{
    public void cartList(){
        HttpUtils.cartList(new Observer<CartListsBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(CartListsBean value) {
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
