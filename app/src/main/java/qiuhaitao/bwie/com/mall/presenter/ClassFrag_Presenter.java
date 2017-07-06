package qiuhaitao.bwie.com.mall.presenter;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import qiuhaitao.bwie.com.mall.model.bean.ClassFrag_GoodsClassBean;
import qiuhaitao.bwie.com.mall.model.bean.ClassFrag_GoodsClassIdBean;
import qiuhaitao.bwie.com.mall.model.bean.ClassFrag_GoodsClassIdNameBean;
import qiuhaitao.bwie.com.mall.model.utils.HttpUtils;
import qiuhaitao.bwie.com.mall.view.iview.ClassFrag_Iview;

/**
 * Created by ASUS on 2017/6/12.
 */

public class ClassFrag_Presenter extends BasePresenter<ClassFrag_Iview> {

    public void getClassFragGoodsClassBeanData(Map<String,String> goods_class ){
        HttpUtils.getClasFragRecyData(goods_class, new Observer<ClassFrag_GoodsClassBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ClassFrag_GoodsClassBean value) {
                getView().callBackGoodsClassBean(value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
    public void getClassFragGoodsClassIdBeanData(Map<String,String> goods_class ){
        HttpUtils.getClasFragRecy1idData(goods_class, new Observer<ClassFrag_GoodsClassIdBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ClassFrag_GoodsClassIdBean value) {
                getView().callBackGoodsClassIdBean(value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
    public void getClassFragGoodsClassIdNameBeanData(Map<String,String> goods_class ){
        HttpUtils.getClasFragRecy1idnameData(goods_class, new Observer<ClassFrag_GoodsClassIdNameBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ClassFrag_GoodsClassIdNameBean value) {
                getView().callBackGoodsClassIdNameBean(value);
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

