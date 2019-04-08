package com.example.t.app.entity;

import java.util.List;

public class YiJiBean {

    /**
     * status : 100
     * msg : 接口请求成功
     * list : [{"id":1,"exam_type":"公务员"},{"id":2,"exam_type":"事业单位考试"},{"id":3,"exam_type":"基层公职类"},{"id":4,"exam_type":"财会金融"},{"id":5,"exam_type":"教师考试"},{"id":6,"exam_type":"警法军考试"},{"id":7,"exam_type":"学历考试"},{"id":8,"exam_type":"医疗卫生"},{"id":9,"exam_type":"职业技能"},{"id":10,"exam_type":"国企名企"},{"id":11,"exam_type":"其他课程"},{"id":12,"exam_type":"基层公职"}]
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
         */

        private int id;
        private String exam_type;

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
    }
}
