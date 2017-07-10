package qiuhaitao.bwie.com.mall.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import qiuhaitao.bwie.com.mall.R;
import qiuhaitao.bwie.com.mall.model.utils.Constant;
import qiuhaitao.bwie.com.mall.view.fragment.Cart_Frag;
import qiuhaitao.bwie.com.mall.view.fragment.Class_Frag;
import qiuhaitao.bwie.com.mall.view.fragment.Home_Frag;
import qiuhaitao.bwie.com.mall.view.fragment.User_Frag;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private RelativeLayout mainrela;
    private RadioButton homeradiobutton;
    private RadioButton classradiobutton;
    private RadioButton cartradiobutton;
    private RadioButton userradiobutton;
    private RadioGroup mainradioGroup;

    private Home_Frag home_frag;
    private Class_Frag class_frag;
    private Cart_Frag cart_frag;
    private User_Frag user_frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
        initData();

    }

    private void initData() {
        home_frag = new Home_Frag();
        class_frag = new Class_Frag();
        cart_frag = new Cart_Frag();
        user_frag = new User_Frag();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainrela, home_frag).commit();
    }

    private void initView() {
        mainrela = (RelativeLayout) findViewById(R.id.mainrela);
        homeradiobutton = (RadioButton) findViewById(R.id.homeradiobutton);
        classradiobutton = (RadioButton) findViewById(R.id.classradiobutton);
        cartradiobutton = (RadioButton) findViewById(R.id.cartradiobutton);
        userradiobutton = (RadioButton) findViewById(R.id.userradiobutton);
        mainradioGroup = (RadioGroup) findViewById(R.id.mainradioGroup);

        homeradiobutton.setOnClickListener(this);
        classradiobutton.setOnClickListener(this);
        cartradiobutton.setOnClickListener(this);
        userradiobutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.homeradiobutton:
                getSupportFragmentManager().beginTransaction().replace(R.id.mainrela, home_frag).commit();
                break;
            case R.id.classradiobutton:
                getSupportFragmentManager().beginTransaction().replace(R.id.mainrela, class_frag).commit();
                break;
            case R.id.cartradiobutton:
                getSupportFragmentManager().beginTransaction().replace(R.id.mainrela, cart_frag).commit();
                break;
            case R.id.userradiobutton:
                getSupportFragmentManager().beginTransaction().replace(R.id.mainrela, user_frag).commit();
                break;

            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
//        Constant.mSharedPreferencesEditor.clear();
//        Constant.mSharedPreferencesEditor.commit();
        super.onDestroy();
    }
}
