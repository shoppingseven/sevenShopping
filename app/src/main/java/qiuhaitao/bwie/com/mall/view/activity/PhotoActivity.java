package qiuhaitao.bwie.com.mall.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import qiuhaitao.bwie.com.mall.R;

/**
 * Created by 仇海涛 on 2017/7/7.
 * class ：
 * content ：
 */

public class PhotoActivity extends BaseActivity {
    TextView textView;
    ImageView img;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        initView();
        initData();
    }

    private void initView() {

        textView = (TextView) findViewById(R.id.titleTextView);
        img = (ImageView) findViewById(R.id.leftImageView);
        imageView = (ImageView) findViewById(R.id.photo_img);

       img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initData() {
     textView.setText("");
        Intent intent = getIntent();
        String img = intent.getStringExtra("img");
        Glide.with(this).load(img).placeholder(R.mipmap.ic_normal_class).into(imageView);
    }
}
