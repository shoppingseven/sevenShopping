package qiuhaitao.bwie.com.mall.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import qiuhaitao.bwie.com.mall.R;
import qiuhaitao.bwie.com.mall.model.bean.RegisterBean;
import qiuhaitao.bwie.com.mall.model.utils.RegexUtils;
import qiuhaitao.bwie.com.mall.presenter.Register_Presenter;
import qiuhaitao.bwie.com.mall.view.iview.Register_Iview;

/**
 * Created by ASUS on 2017/6/12.
 */

public class Register_Activity extends BaseActivity implements Register_Iview<RegisterBean> {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText passwordRepeatEditText;
    private EditText emailEditText;
    private TextView regTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();

    }

    private void initData() {
        String user = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String passwordRepeat = passwordRepeatEditText.getText().toString();
        String email = emailEditText.getText().toString();

        if (!RegexUtils.isPassword(user)){
            Toast.makeText(Register_Activity.this, "用户名格式不正确", Toast.LENGTH_SHORT).show();
        }
        if (!RegexUtils.isPassword(password)){
            Toast.makeText(Register_Activity.this, "密码格式不正确", Toast.LENGTH_SHORT).show();
        }
        if (!RegexUtils.isPassword(passwordRepeat)){
            Toast.makeText(Register_Activity.this, "密码格式不正确", Toast.LENGTH_SHORT).show();
        }
        if (!RegexUtils.isEmail(passwordRepeat)){
            Toast.makeText(Register_Activity.this, "Email式不正确", Toast.LENGTH_SHORT).show();
        }
        if (!password.equals(passwordRepeat)){
            Toast.makeText(Register_Activity.this, "密码不一致", Toast.LENGTH_SHORT).show();
        }
        Register_Presenter presenter = new Register_Presenter();
        presenter.attachView(this);
        presenter.getRegisterData(user, password, passwordRepeat, email);
    }

    private void initView() {
        usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        passwordRepeatEditText = (EditText) findViewById(R.id.passwordRepeatEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        regTextView = (TextView) findViewById(R.id.registerTextView);
        regTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initData();
            }
        });
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

        String passwordRepeatEditTextString = passwordRepeatEditText.getText().toString().trim();
        if (TextUtils.isEmpty(passwordRepeatEditTextString)) {
            Toast.makeText(this, "请再次输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String emailEditTextString = emailEditText.getText().toString().trim();
        if (TextUtils.isEmpty(emailEditTextString)) {
            Toast.makeText(this, "emailEditTextString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }

    @Override
    public void attachView(RegisterBean registerBean) {
        if (registerBean.getCode()==200){
            regTextView.setText("正在注册...");
            Toast.makeText(Register_Activity.this, "注册成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
