package qiuhaitao.bwie.com.mall.view.iview;

/**
 * Created by ASUS on 2017/6/12.
 */

public interface ClassFrag_Iview<T,E,A > extends IView {
    void callBackGoodsClassBean(T t);
    void callBackGoodsClassIdBean(E e);
    void callBackGoodsClassIdNameBean(A a);

}
