package com.example.t.app.entity;

import java.util.List;


public class ShouYeListBean {

    /**
     * list : [{"cid":1,"img":"http://seven.haoyunyun.cn/classuploads/5beeb907abcb66766.png",
     * "classname":"12312",
     * "new_price":"2018.00"},{"cid":2,"img":"http://seven.haoyunyun
     * .cn/classuploads/5bed60a0c8c2e2881.png",
     * "classname":"234535","new_price":"2000.00"},{"cid":8,"img":"http://seven.haoyunyun
     * .cn/classuploads/5bed6028e00929562.png","classname":"2019国考","new_price":"123.00"}]
     * status : 100
     * msg : 接口请求成功
     */
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int status;
    private String msg;
    private List<ListBean> list;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public class ListBean {
        /**
         * cid : 1
         * img : http://seven.haoyunyun.cn/classuploads/5beeb907abcb66766.png
         * classname : 12312
         * new_price : 2018.00
         */

        private int cid;
        private String img;
        private String classname;
        private String new_price;

        public int getCid() {
            return cid;
        }

        public void setCid(int cid) {
            this.cid = cid;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getClassname() {
            return classname;
        }

        public void setClassname(String classname) {
            this.classname = classname;
        }

        public String getNew_price() {
            return new_price;
        }

        public void setNew_price(String new_price) {
            this.new_price = new_price;
        }
    }
}
