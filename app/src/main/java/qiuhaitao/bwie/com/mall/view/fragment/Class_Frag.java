package qiuhaitao.bwie.com.mall.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import qiuhaitao.bwie.com.mall.R;
import qiuhaitao.bwie.com.mall.model.bean.ClassFrag_GoodsClassBean;
import qiuhaitao.bwie.com.mall.model.bean.ClassFrag_GoodsClassIdBean;
import qiuhaitao.bwie.com.mall.model.bean.ClassFrag_GoodsClassIdNameBean;
import qiuhaitao.bwie.com.mall.presenter.ClassFrag_Presenter;
import qiuhaitao.bwie.com.mall.view.adapter.ClassFragExpandableLvAdapter;
import qiuhaitao.bwie.com.mall.view.adapter.ClassFragRecyLeftAda;
import qiuhaitao.bwie.com.mall.view.iview.ClassFrag_Iview;
import qiuhaitao.bwie.com.mall.view.iview.Recy_OnClick;

/**
 * Created by ASUS on 2017/6/10.
 */

public class Class_Frag extends Fragment implements ClassFrag_Iview<ClassFrag_GoodsClassBean,ClassFrag_GoodsClassIdBean,ClassFrag_GoodsClassIdNameBean> {
    private RecyclerView class_frag_recy;
    private View view;

    private ClassFragRecyLeftAda ada;

    Map<String,String> goods_class = new HashMap<>();
    Map<String,String> goods_classid = new HashMap<>();
    Map<String,String> goods_classidname = new HashMap<>();
    //Map<String,List<ClassFrag_GoodsClassIdNameBean.DatasBean.ClassListBean>> map = new HashMap<>();
    List<List<ClassFrag_GoodsClassIdNameBean.DatasBean.ClassListBean>> list = new ArrayList();
    private ClassFrag_Presenter presenter;
    private ExpandableListView expandableListView;
    private ClassFragExpandableLvAdapter adapter;
    private List<ClassFrag_GoodsClassIdBean.DatasBean.ClassListBean> class_listIdBean;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.class_frag, null);

        initView();
        initData();
        return view;
    }
    //请求recycleview数据左边列表
    private void initData() {
        goods_class.put("act","goods_class");
        presenter = new ClassFrag_Presenter();
        presenter.attachView(this);
        ada = new ClassFragRecyLeftAda(getActivity());
        presenter.getClassFragGoodsClassBeanData(goods_class);
        class_frag_recy.setAdapter(ada);

        ada.setOnClick(new Recy_OnClick() {
            @Override
            public void onClick(View view, int position, String gc_id) {
                goods_classid.put("act","goods_class");
                goods_classid.put("gc_id",gc_id);
                presenter.getClassFragGoodsClassIdBeanData(goods_classid);
                list.clear();
            }
        });



    }

    private void initView() {
        class_frag_recy = (RecyclerView) view.findViewById(R.id.class_frag_recy);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        class_frag_recy.setLayoutManager(linearLayoutManager);

        expandableListView = (ExpandableListView) view.findViewById(R.id.class_frag_expandablelistview);


    }

    @Override
    public void callBackGoodsClassBean(ClassFrag_GoodsClassBean classFragBean) {
        List<ClassFrag_GoodsClassBean.DatasBean.ClassListBean> class_list = classFragBean.getDatas().getClass_list();
        ada.setData(class_list,presenter);
    }

    @Override
    public void callBackGoodsClassIdBean(ClassFrag_GoodsClassIdBean classFrag_goodsClassIdBean) {
        class_listIdBean = classFrag_goodsClassIdBean.getDatas().getClass_list();
        if (class_listIdBean!=null){

            for( ClassFrag_GoodsClassIdBean.DatasBean.ClassListBean n: class_listIdBean ){
                goods_classidname.put("act","goods_class");
                goods_classidname.put("gc_id",n.getGc_id());
                goods_classidname.put("gc_name",n.getGc_name());
                presenter.getClassFragGoodsClassIdNameBeanData(goods_classidname);
            }
        }


    }

    @Override
    public void callBackGoodsClassIdNameBean(ClassFrag_GoodsClassIdNameBean classFrag_goodsClassIdNameBean) {
        List<ClassFrag_GoodsClassIdNameBean.DatasBean.ClassListBean> class_listIdNameBean = classFrag_goodsClassIdNameBean.getDatas().getClass_list();
        if (class_listIdNameBean!=null){
            list.add(class_listIdNameBean);
        }
        ClassFragExpandableLvAdapter adapter = new ClassFragExpandableLvAdapter(getActivity());
        adapter.setData(class_listIdBean,list);
        expandableListView.setAdapter(adapter);
        Log.d("memeda", "list:"+list.size());

    }


}
