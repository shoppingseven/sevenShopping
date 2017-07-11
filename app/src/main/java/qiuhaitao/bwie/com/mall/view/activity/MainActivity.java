package qiuhaitao.bwie.com.mall.view.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;
import qiuhaitao.bwie.com.mall.R;
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
        //注册EventBus
        EventBus.getDefault().register(this);

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

    @Subscribe(threadMode = ThreadMode.MainThread)
    public void helloEventBus(String message) {
        Toast.makeText(MainActivity.this, "么么哒", Toast.LENGTH_SHORT).show();
        Log.d("memeda", "helloEventBus: " + "cart_frag");

        getSupportFragmentManager().beginTransaction().replace(R.id.mainrela, cart_frag).show(cart_frag).commitAllowingStateLoss();
        cartradiobutton.setChecked(true);

    }



    @Override
    protected void onDestroy() {

        super.onDestroy();
        EventBus.getDefault().unregister(this);//反注册EventBus

    }
}
