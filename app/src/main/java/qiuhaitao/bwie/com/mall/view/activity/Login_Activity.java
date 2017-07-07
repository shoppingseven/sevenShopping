package qiuhaitao.bwie.com.mall.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import qiuhaitao.bwie.com.mall.R;
import qiuhaitao.bwie.com.mall.model.bean.LoginBean;
import qiuhaitao.bwie.com.mall.model.utils.Constant;
import qiuhaitao.bwie.com.mall.model.utils.RegexUtils;
import qiuhaitao.bwie.com.mall.presenter.Login_Presenter;
import qiuhaitao.bwie.com.mall.view.iview.Login_Iview;

/**
 * Created by ASUS on 2017/6/12.
 */

public class Login_Activity extends BaseActivity implements Login_Iview<LoginBean>,View.OnClickListener {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private TextView loginTextView;
    private TextView regTextView;
    private TextView backTextView;

    private  LoginBean loginBean;
    private ImageView leftimg;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor edit;
    private String user;
    private String pwd;
    boolean flag;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();


    }

    private void initData() {

        user = usernameEditText.getText().toString();
        pwd = passwordEditText.getText().toString();
        submit();
        if (!RegexUtils.isPassword(user)){
            Toast.makeText(Login_Activity.this, "用户名格式不正确", Toast.LENGTH_SHORT).show();
        }
        if (!RegexUtils.isPassword(pwd)){
            Toast.makeText(Login_Activity.this, "密码格式不正确", Toast.LENGTH_SHORT).show();
        }
        Login_Presenter presenter = new Login_Presenter();
        presenter.attachView(this);
        presenter.getLoginData(user, pwd);
    }

    private void initView() {
        leftimg = (ImageView) findViewById(R.id.leftImageView);
        usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        loginTextView = (TextView) findViewById(R.id.loginTextView);
        regTextView = (TextView) findViewById(R.id.regTextView);
        backTextView = (TextView) findViewById(R.id.backTextView);

        leftimg.setOnClickListener(this);
        loginTextView.setOnClickListener(this);
        regTextView.setOnClickListener(this);
    }

    private void submit() {
        // validate
        String usernameEditTextString = usernameEditText.getText().toString().trim();
        if (TextUtils.isEmpty(usernameEditTextString)) {
            Toast.makeText(this, "usernameEditTextString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String passwordEditTextString = passwordEditText.getText().toString().trim();
        if (TextUtils.isEmpty(passwordEditTextString)) {
            Toast.makeText(this, "passwordEditTextString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }



    @Override
    public void attachView(LoginBean loginBean) {
        Log.d("memeda", "callBackGoodsClassBean: "+loginBean.toString());
        //this.loginBean = loginBean;
        if (loginBean.getCode()==200) {
            loginTextView.setText("登陆中...");
            Toast.makeText(Login_Activity.this, "登录成功", Toast.LENGTH_SHORT).show();
            Constant.mSharedPreferencesEditor.putBoolean("User_Login", true);
            Constant.mSharedPreferencesEditor.putString("User_Username", user);
            Constant.mSharedPreferencesEditor.putString("key", loginBean.getDatas().getKey());
            Constant.mSharedPreferencesEditor.commit();

            Intent intent = new Intent(Login_Activity.this,MainActivity.class);
            startActivity(intent);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.leftImageView:
                finish();
                break;
            case R.id.loginTextView:
                initData();
                break;
            case R.id.regTextView:
                Intent intent = new Intent(Login_Activity.this,Register_Activity.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }
}
