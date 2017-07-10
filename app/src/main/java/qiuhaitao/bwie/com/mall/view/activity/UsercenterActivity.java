package qiuhaitao.bwie.com.mall.view.activity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import qiuhaitao.bwie.com.mall.R;
import qiuhaitao.bwie.com.mall.model.utils.Constant;

/**
 * Created by ASUS on 2017/6/13.
 */

public class UsercenterActivity extends BaseActivity {

    private ImageView back;
    private TextView exittext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_center);
        initView();
        initData();
    }

    private void initData() {

    }

    private void initView() {
        back = (ImageView) findViewById(R.id.leftImageView);
        exittext = (TextView) findViewById(R.id.exitTextView);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        exittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog dialog = new AlertDialog.Builder(UsercenterActivity.this).create();
                View view = View.inflate(UsercenterActivity.this,R.layout.exit_dialog,null);
                dialog.setView(view);
                TextView textView = (TextView) view.findViewById(R.id.confirmTextView);
                TextView textView1 = (TextView) view.findViewById(R.id.cancelTextView);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Constant.mSharedPreferencesEditor.clear();
                        Constant.mSharedPreferencesEditor.commit();

                        UsercenterActivity.this.finish();
                    }
                });
                textView1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
    }
}
