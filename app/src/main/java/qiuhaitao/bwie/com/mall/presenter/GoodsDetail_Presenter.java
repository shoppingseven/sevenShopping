package qiuhaitao.bwie.com.mall.presenter;

import android.util.Log;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import qiuhaitao.bwie.com.mall.model.bean.Goods_Detail_Bean;
import qiuhaitao.bwie.com.mall.model.utils.HttpUtils;
import qiuhaitao.bwie.com.mall.view.iview.Goods_Detail_Iview;

/**
 * Created by ASUS on 2017/6/12.
 */

public class GoodsDetail_Presenter extends BasePresenter<Goods_Detail_Iview> {

    public void getGoodsDetailData(Map<String,String> map){

        HttpUtils.getGoodsDetailBean(map,  new Observer<Goods_Detail_Bean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Goods_Detail_Bean value) {

                Log.e("onnext", value.toString());
                getView().attachData(value);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("onerror", e.toString());
            }

            @Override
            public void onComplete() {

            }
        });
    }

}

