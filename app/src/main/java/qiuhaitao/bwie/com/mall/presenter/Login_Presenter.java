package qiuhaitao.bwie.com.mall.presenter;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import qiuhaitao.bwie.com.mall.model.bean.LoginBean;
import qiuhaitao.bwie.com.mall.model.utils.HttpUtils;
import qiuhaitao.bwie.com.mall.view.iview.Login_Iview;

/**
 * Created by ASUS on 2017/6/12.
 */

public class Login_Presenter extends BasePresenter<Login_Iview> {

    public void getLoginData(String user, final String pwd){
        //Log.e("memeda",user="======"+pwd );
        HttpUtils.login(user, pwd, "android", new Observer<LoginBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(LoginBean value) {

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

