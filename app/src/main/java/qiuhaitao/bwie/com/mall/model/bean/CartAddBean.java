package qiuhaitao.bwie.com.mall.model.bean;

/**
 * 作者:郭凯奇
 * 时间: 2017/7/6 21:08
 * Title:
 * Text:
 */

public class CartAddBean {
    @Override
    public String toString() {
        return "CartAddBean{" +
                "code=" + code +
                ", datas='" + datas + '\'' +
                '}';
    }

    /**
     * code : 200
     * datas : 1
     */

    private int code;
    private String datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDatas() {
        return datas;
    }

    public void setDatas(String datas) {
        this.datas = datas;
    }
}
