package qiuhaitao.bwie.com.mall.presenter;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import qiuhaitao.bwie.com.mall.model.utils.HttpUtils;
import qiuhaitao.bwie.com.mall.view.iview.CartDelete_Iview;

/**
 * 作者:郭凯奇
 * 时间: 2017/7/6 21:19
 * Title:
 * Text:
 */

public class CartDeletePresenter extends BasePresenter<CartDelete_Iview>{
    public void cartDelete(String key,String cart_id){
        HttpUtils.cartDelete(key, cart_id, new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String value) {
                getView().ondata(value);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("error", e.toString() );
            }

            @Override
            public void onComplete() {

            }
        });

    }


}
