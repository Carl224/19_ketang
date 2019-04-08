package com.example.t.app.entity;

import java.util.List;

public class ErJiBean {

    /**
     * status : 100
     * msg : 接口请求成功
     * list : [{"id":1,"exam_type":"公务员","exam_type1":"国家公务员","exam_type2":"1"},{"id":2,"exam_type":"公务员","exam_type1":"地方公务员","exam_type2":"1"},{"id":3,"exam_type":"公务员","exam_type1":"选调生","exam_type2":"1"},{"id":4,"exam_type":"公务员","exam_type1":"乡镇公务员","exam_type2":"1"},{"id":5,"exam_type":"公务员","exam_type1":"公开遴选","exam_type2":"1"}]
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
         * exam_type : 公务员
         * exam_type1 : 国家公务员
         * exam_type2 : 1
         */

        private int id;
        private String exam_type;
        private String exam_type1;
        private String exam_type2;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getExam_type() {
            return exam_type;
        }

        public void setExam_type(String exam_type) {
            this.exam_type = exam_type;
        }

        public String getExam_type1() {
            return exam_type1;
        }

        public void setExam_type1(String exam_type1) {
            this.exam_type1 = exam_type1;
        }

        public String getExam_type2() {
            return exam_type2;
        }

        public void setExam_type2(String exam_type2) {
            this.exam_type2 = exam_type2;
        }
    }
}
