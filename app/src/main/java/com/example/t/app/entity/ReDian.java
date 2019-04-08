package com.example.t.app.entity;

import java.util.List;

public class ReDian {

    /**
     * list : [{"aid":33,"article_name":"依法保障民营企业权利","type_name":"经济"},{"aid":34,"article_name":"6000余首歌下架KTV，向\u201c免费午餐\u201d说再见","type_name":"经济"},{"aid":35,"article_name":"与世界互联，与数字共舞","type_name":"经济"},{"aid":36,"article_name":"\u201c双11\u201d购物节 少点套路行不行","type_name":"经济"},{"aid":37,"article_name":"个人信息被\u201c挂售\u201d，当治！","type_name":"经济"},{"aid":38,"article_name":"为民营企业发展营造良好营商环境","type_name":"经济"},{"aid":27,"article_name":"文明养犬，就真的那么难吗？","type_name":"政治"},{"aid":29,"article_name":"交往有分寸 服务要主动","type_name":"政治"},{"aid":30,"article_name":"农村改革的历史脉络与未来趋势","type_name":"政治"},{"aid":31,"article_name":"多些\u201c迟到证明\u201d式的爱心呵护","type_name":"政治"},{"aid":20,"article_name":"坚持包容普惠，推动共同发展","type_name":"社会"},{"aid":22,"article_name":"改革开放让中国特色社会主义制度大步向前","type_name":"社会"},{"aid":23,"article_name":"大学生村干部如何真正做\u201c村官\u201d","type_name":"社会"},{"aid":24,"article_name":"两位革命家这样讲党课","type_name":"社会"},{"aid":25,"article_name":"坚持严字当头、全面从严、一严到底","type_name":"社会"},{"aid":26,"article_name":"\u201c党建名镇\u201d如何再发力？","type_name":"社会"},{"aid":32,"article_name":"建设创新型国家的突破口和着力点","type_name":"社会"},{"aid":39,"article_name":"新时代要继续发扬螺丝钉精神","type_name":"文化"},{"aid":40,"article_name":"用故事展现真实奋斗的中国","type_name":"文化"},{"aid":41,"article_name":"电子游戏会不会是下一代\u201c金庸小说\u201d？","type_name":"文化"},{"aid":42,"article_name":"重视文科 更要摆脱文理科的此消彼长","type_name":"文化"},{"aid":43,"article_name":"重振工匠精神，培养更多大国工匠","type_name":"文化"},{"aid":44,"article_name":"怀念金庸，就是在追忆那永不褪色的侠义精神","type_name":"文化"},{"aid":19,"article_name":"全党履行好生态环境保护的政治责任","type_name":"生态"},{"aid":13,"article_name":"让垃圾分类成为一种新时尚","type_name":"生态"},{"aid":14,"article_name":"完善矿产资源开发生态补偿机制","type_name":"生态"},{"aid":15,"article_name":"处理好城市与低碳发展的关系","type_name":"生态"},{"aid":16,"article_name":"施行\u201c最严控烟令\u201d还需让制度发力","type_name":"生态"},{"aid":17,"article_name":"涵养汽车文明，为生命开辟\u201c绿色通道\u201d","type_name":"生态"},{"aid":45,"article_name":"金庸武侠小说是一个独特的文学存在","type_name":"武侠小说"},{"aid":46,"article_name":"金声玉振，史鉴昭昭","type_name":"武侠小说"},{"aid":47,"article_name":"金庸离世,让\u201c侠骨柔情\u201d永驻心间","type_name":"武侠小说"},{"aid":48,"article_name":"太极拳","type_name":"武侠小说"},{"aid":49,"article_name":"纪念金庸先生，莫过于品读他的武侠江湖","type_name":"武侠小说"}]
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
         * aid : 33
         * article_name : 依法保障民营企业权利
         * type_name : 经济
         */

        private int aid;
        private String article_name;
        private String type_name;

        public int getAid() {
            return aid;
        }

        public void setAid(int aid) {
            this.aid = aid;
        }

        public String getArticle_name() {
            return article_name;
        }

        public void setArticle_name(String article_name) {
            this.article_name = article_name;
        }

        public String getType_name() {
            return type_name;
        }

        public void setType_name(String type_name) {
            this.type_name = type_name;
        }
    }
}
