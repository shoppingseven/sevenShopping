package qiuhaitao.bwie.com.mall.application;

import android.app.Application;

import qiuhaitao.bwie.com.mall.model.utils.Constant;

/**
 * Created by ASUS on 2017/6/9.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Constant.init(this);
    }
}
