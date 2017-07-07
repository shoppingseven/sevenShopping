package qiuhaitao.bwie.com.mall.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import qiuhaitao.bwie.com.mall.R;

/**
 * Created by 仇海涛 on 2017/7/7.
 * class ：
 * content ：
 */

public class GoodsIntroduceActivity extends BaseActivity {

    private WebView webview;
    private TextView textView;
    private ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goodsintroduceactivity);
        initView();
        initData();
    }

    private void initData() {
        textView.setText("");
        Intent intent = getIntent();
        String link = intent.getStringExtra("Link");
        Log.d("memeda", "initData: "+link);
        //设置WebView属性，能够执行Javascript脚本
         webview.getSettings().setJavaScriptEnabled(true);
        //加载需要显示的网页
        webview.loadUrl("http://169.254.220.2/mobile/index.php?act=goods&op=goods_body&goods_id=100009");
        //设置Web视图

    }

    private void initView() {
        webview = (WebView) findViewById(R.id.webview);
        textView = (TextView) findViewById(R.id.titleTextView);
        img = (ImageView) findViewById(R.id.leftImageView);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    //设置回退
    //覆盖Activity类的onKeyDown(int keyCoder,KeyEvent event)方法
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {
            webview.goBack(); //goBack()表示返回WebView的上一页面
            return true;
        }
        return false;
    }


}
