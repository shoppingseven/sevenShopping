package qiuhaitao.bwie.com.mall.presenter;

import android.util.Log;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import qiuhaitao.bwie.com.mall.model.bean.Goods_Search_Bean;
import qiuhaitao.bwie.com.mall.model.utils.HttpUtils;
import qiuhaitao.bwie.com.mall.view.iview.Goods_search_Iview;

/**
 * Created by ASUS on 2017/6/12.
 */

public class GoodsSearch_Presenter extends BasePresenter<Goods_search_Iview> {

    public void getGoodsSearchData(Map<String,String> map){

        HttpUtils.getGoodsSearchBean(map,  new Observer<Goods_Search_Bean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Goods_Search_Bean value) {

                Log.e("onnext", value.toString());
                getView().attachView(value);
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

