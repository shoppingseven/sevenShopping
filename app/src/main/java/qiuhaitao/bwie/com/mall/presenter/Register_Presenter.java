package qiuhaitao.bwie.com.mall.presenter;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import qiuhaitao.bwie.com.mall.model.bean.RegisterBean;
import qiuhaitao.bwie.com.mall.model.utils.HttpUtils;
import qiuhaitao.bwie.com.mall.view.iview.Register_Iview;

/**
 * Created by ASUS on 2017/6/12.
 */

public class Register_Presenter extends BasePresenter<Register_Iview> {

    public void getRegisterData(String user, final String pwd,String pwd2,String email){
        //Log.e("memeda",user="======"+pwd );
        HttpUtils.register(user, pwd,pwd2,email, "android", new Observer<RegisterBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RegisterBean value) {

                Log.e("onnext", value.getCode()+"");
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

