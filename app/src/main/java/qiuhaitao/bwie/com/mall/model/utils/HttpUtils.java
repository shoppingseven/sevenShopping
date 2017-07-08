package qiuhaitao.bwie.com.mall.model.utils;

import android.util.Log;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import qiuhaitao.bwie.com.mall.model.bean.CartAddBean;
import qiuhaitao.bwie.com.mall.model.bean.CartListsBean;
import qiuhaitao.bwie.com.mall.model.bean.ClassFrag_GoodsClassBean;
import qiuhaitao.bwie.com.mall.model.bean.ClassFrag_GoodsClassIdBean;
import qiuhaitao.bwie.com.mall.model.bean.ClassFrag_GoodsClassIdNameBean;
import qiuhaitao.bwie.com.mall.model.bean.Goods_Detail_Bean;
import qiuhaitao.bwie.com.mall.model.bean.Goods_Search_Bean;
import qiuhaitao.bwie.com.mall.model.bean.LoginBean;
import qiuhaitao.bwie.com.mall.model.bean.RegisterBean;
import qiuhaitao.bwie.com.mall.view.iview.ApiService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by ASUS on 2017/6/9.
 */

public class HttpUtils {
    OkHttpClient client = new OkHttpClient();
    //登录
     public static void login(String username, String password, String client, Observer<LoginBean> observer) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.LINK_MAIN)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<LoginBean> observable = apiService.getLoginCode("login", username, password, client);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
    //注册
    public static void register(String username, String password,String password2,String email, String client, Observer<RegisterBean> observer) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.LINK_MAIN)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<RegisterBean> observable = apiService.getRegCode("login","register", username, password, password2,email,client);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
    //class frag 分类
    public static void getClasFragRecyData(Map<String,String> goods_class, Observer<ClassFrag_GoodsClassBean> observer){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.LINK_MAIN)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<ClassFrag_GoodsClassBean> observable = apiService.getClassFragBean_goodsclass(goods_class);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
    //class frag 分类
    public static void getClasFragRecy1idData(Map<String,String> goods_class, Observer<ClassFrag_GoodsClassIdBean> observer){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.LINK_MAIN)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<ClassFrag_GoodsClassIdBean> observable = apiService.getClassFragBean_goodsclassid(goods_class);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
    //class frag 分类
    public static void getClasFragRecy1idnameData(Map<String,String> goods_class, Observer<ClassFrag_GoodsClassIdNameBean> observer){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.LINK_MAIN)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<ClassFrag_GoodsClassIdNameBean> observable = apiService.getClassFragBean_goodsclassidname(goods_class);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
    //goods_search 商品列表
    public static void getGoodsSearchBean(Map<String,String> map, Observer<Goods_Search_Bean> observer){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.LINK_MAIN)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<Goods_Search_Bean> observable = apiService.getGoodsSearch(map);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
    //购物车添加
    public static void cartadd(String goods_id,String qu, Observer<CartAddBean> observer){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.LINK_MAIN)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
//        act=member_cart&op=cart_del
        ApiService apiService = retrofit.create(ApiService.class);
        String key = Constant.mSharedPreferences.getString("key", "");
        Log.e("key", key+"==="+goods_id);
        Observable<CartAddBean> observable = apiService.cartadd("member_cart","cart_add",key,goods_id,"1");
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
    public static void cartList(Observer<CartListsBean> observer){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.LINK_MAIN)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        String key = Constant.mSharedPreferences.getString("key", "");
        Log.e("cartlist",key );
        Observable<CartListsBean> observable = apiService.cartList("member_cart","cart_list",key);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
    //goods_search 商品列表
    public static void getGoodsDetailBean(Map<String,String> map, Observer<Goods_Detail_Bean> observer){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.LINK_MAIN)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<Goods_Detail_Bean> observable = apiService.getGoodsDetail(map);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
    //购物车删除
    public static void cartDelete(String key, String cart_id,Observer<CartAddBean> observer) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.LINK_MAIN)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<CartAddBean> observable = apiService.cartDelete("member_cart", "cart_del", key, cart_id);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
}
