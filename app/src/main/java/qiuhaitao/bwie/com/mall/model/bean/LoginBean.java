package qiuhaitao.bwie.com.mall.model.bean;

/**
 * Created by ASUS on 2017/6/9.
 */

public class LoginBean {

    /**
     * code : 200
     * datas : {"username":"a123456","userid":"3","key":"1afdf31892a98e211f91cdb92d616983"}
     */

    private int code;
    private DatasBean datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DatasBean getDatas() {
        return datas;
    }

    public void setDatas(DatasBean datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        /**
         * username : a123456
         * userid : 3
         * key : 1afdf31892a98e211f91cdb92d616983
         */

        private String username;
        private String userid;
        private String key;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "DatasBean{" +
                    "username='" + username + '\'' +
                    ", userid='" + userid + '\'' +
                    ", key='" + key + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "code=" + code +
                ", datas=" + datas +
                '}';
    }
}
