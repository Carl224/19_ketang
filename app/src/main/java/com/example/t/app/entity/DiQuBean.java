package com.example.t.app.entity;

import java.util.List;

public class DiQuBean {

    /**
     * list : [{"id":1,"address":"安徽"},{"id":2,"address":"北京"},{"id":3,"address":"重庆"},{"id":4,"address":"福建"},{"id":5,"address":"甘肃"},{"id":6,"address":"广东"},{"id":7,"address":"广西"},{"id":8,"address":"贵州"},{"id":9,"address":"海南"},{"id":10,"address":"河北"},{"id":11,"address":"河南"},{"id":12,"address":"黑龙江"},{"id":13,"address":"湖北"},{"id":14,"address":"湖南"},{"id":15,"address":"吉林"},{"id":16,"address":"江苏"},{"id":17,"address":"江西"},{"id":18,"address":"辽宁"},{"id":19,"address":"内蒙古"},{"id":20,"address":"宁夏"},{"id":21,"address":"青海"},{"id":22,"address":"山东"},{"id":23,"address":"山西"},{"id":24,"address":"陕西"},{"id":25,"address":"上海"},{"id":26,"address":"四川"},{"id":27,"address":"天津"},{"id":28,"address":"台湾"},{"id":29,"address":"西藏"},{"id":30,"address":"新疆"},{"id":31,"address":"云南"},{"id":32,"address":"浙江"}]
     * status : 100
     * msg : 地区请求成功
     */

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

    public static class ListBean {
        /**
         * id : 1
         * address : 安徽
         */

        private int id;
        private String address;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
