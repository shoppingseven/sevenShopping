package qiuhaitao.bwie.com.mall.view.iview;

import java.util.Map;

import io.reactivex.Observable;
import qiuhaitao.bwie.com.mall.model.bean.CartAddBean;
import qiuhaitao.bwie.com.mall.model.bean.CartListsBean;
import qiuhaitao.bwie.com.mall.model.bean.ClassFrag_GoodsClassBean;
import qiuhaitao.bwie.com.mall.model.bean.ClassFrag_GoodsClassIdBean;
import qiuhaitao.bwie.com.mall.model.bean.ClassFrag_GoodsClassIdNameBean;
import qiuhaitao.bwie.com.mall.model.bean.Goods_Detail_Bean;
import qiuhaitao.bwie.com.mall.model.bean.Goods_Search_Bean;
import qiuhaitao.bwie.com.mall.model.bean.LoginBean;
import qiuhaitao.bwie.com.mall.model.bean.RegisterBean;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by ASUS on 2017/6/9.
 */

public interface ApiService {
    @FormUrlEncoded
    @POST("mobile/index.php")
    Observable<RegisterBean> getRegCode(@Field("act") String sort,
                                        @Field("op") String op,
                                        @Field("username") String username,
                                        @Field("password") String password,
                                        @Field("password_confirm") String password_confirm,
                                        @Field("email") String email,
                                        @Field("client") String client);
    @FormUrlEncoded
    @POST("mobile/index.php")
//            ajaxParams.put("key", Constant.userKeyString);
//                ajaxParams.put("goods_id", id);
//                ajaxParams.put("quantity", quantity);
    Observable<CartAddBean> cartadd(@Field("act") String act,
                                    @Field("op") String op,
                                    @Field("key") String key,
                                    @Field("goods_id") String goods_id,
                                    @Field("quantity") String quantity);
    @FormUrlEncoded
    @POST("mobile/index.php")
    Observable<CartListsBean> cartList(@Field("act") String act,
                                      @Field("op") String op,
                                      @Field("key") String key);

    @FormUrlEncoded
    @POST("mobile/index.php")
    Observable<LoginBean> getLoginCode(@Field("act") String sort,
                                       @Field("username") String username,
                                       @Field("password") String password,
                                       @Field("client") String client);

    @GET("mobile/index.php")
    Observable<ClassFrag_GoodsClassBean> getClassFragBean_goodsclass
            (@QueryMap Map<String, String> request);

    @GET("mobile/index.php")
    Observable<ClassFrag_GoodsClassIdBean> getClassFragBean_goodsclassid
            (@QueryMap Map<String, String> request);

    @GET("mobile/index.php")
    Observable<ClassFrag_GoodsClassIdNameBean> getClassFragBean_goodsclassidname
            (@QueryMap Map<String, String> request);

    @GET("mobile/index.php")
    Observable<Goods_Search_Bean> getGoodsSearch
            (@QueryMap Map<String, String> request);
    @GET("mobile/index.php")
    Observable<Goods_Detail_Bean> getGoodsDetail
            (@QueryMap Map<String, String> request);
}
