package com.example.t.app.entity;

import java.util.List;

public class BannerBean {
    @Override
    public String toString() {
        return "BannerBean{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", list=" + list +
                '}';
    }

    /**
     * list : [{"pid":1,"show_name":"23423","show_img":"http://seven.haoyunyun.cn/uploads/5bd996b27fc009881.jpg","show_link":"www.tupiam.com","sort":"1"},{"pid":2,"show_name":"第二张","show_img":"http://seven.haoyunyun.cn/uploads/5bd99952f188f7427.jpg","show_link":"www.百度.com","sort":"2"},{"pid":4,"show_name":"mm","show_img":"http://seven.haoyunyun.cn/uploads/5bd999e8746677728.jpg","show_link":"www.百度.com","sort":"4"},{"pid":5,"show_name":"来得快","show_img":"http://seven.haoyunyun.cn/uploads/5bd9a91eb4bed2160.jpg","show_link":"www.tupiam.com","sort":"50"},{"pid":6,"show_name":"第二张","show_img":"http://seven.haoyunyun.cn/uploads/5bd9aa9a6b0fa8289.jpg","show_link":"www.tupiam.com","sort":"50"},{"pid":7,"show_name":"图片","show_img":"http://seven.haoyunyun.cn/uploads/5be1405f92ac52920.png","show_link":"www.baidu.com","sort":"50"},{"pid":8,"show_name":"第二张","show_img":"http://seven.haoyunyun.cn/uploads/5be14075adfea4268.png","show_link":"www.baidu.com","sort":"50"},{"pid":9,"show_name":"图片","show_img":"http://seven.haoyunyun.cn/uploads/5be140e2277565629.png","show_link":"www.baidu.com","sort":"50"},{"pid":10,"show_name":"图片","show_img":"http://seven.haoyunyun.cn/uploads/5be23033562cf9788.png","show_link":"www.baidu.com","sort":"50"},{"pid":11,"show_name":"冲天飞机","show_img":"http://seven.haoyunyun.cn/uploads/5be262eab989b2570.gif","show_link":"www.baidu.com","sort":"50"}]
     * status : 100
     * msg : 接口请求成功
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
         * pid : 1
         * show_name : 23423
         * show_img : http://seven.haoyunyun.cn/uploads/5bd996b27fc009881.jpg
         * show_link : www.tupiam.com
         * sort : 1
         */

        private int pid;
        private String show_name;
        private String show_img;
        private String show_link;
        private String sort;

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public String getShow_name() {
            return show_name;
        }

        public void setShow_name(String show_name) {
            this.show_name = show_name;
        }

        public String getShow_img() {
            return show_img;
        }

        public void setShow_img(String show_img) {
            this.show_img = show_img;
        }

        public String getShow_link() {
            return show_link;
        }

        public void setShow_link(String show_link) {
            this.show_link = show_link;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }
    }
}
