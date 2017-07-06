package qiuhaitao.bwie.com.mall.view.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by 仇海涛 on 2017/6/26.
 * class ：
 * content ：
 */

public class MyGridView extends GridView {


    public MyGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 设置不滚动
     */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }


}
