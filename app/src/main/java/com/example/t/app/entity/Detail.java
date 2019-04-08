package com.example.t.app.entity;

import java.util.List;

public class Detail {
    @Override
    public String toString() {
        return "Detail{" +
                "ERRORCODE='" + ERRORCODE + '\'' +
                ", RESULT=" + RESULT +
                '}';
    }

    /**
     * ERRORCODE : 0
     * RESULT : {"imgUrl":[],"editor":"","publishTime":"2018-11-12 15:30:03","source":"新京报","category":"要闻","title":"山东青银高速两处车辆碰撞燃烧 16车起火致2死9伤","content":"   新京报讯（记者 张彤）今日（12日），山东聊城青银高速高唐境内因突发团雾，在420公里至421公里（石家庄方向）之间两处发生车辆碰撞起火燃烧事故。聊城市公安局高速交警支队发布通报称，两处事故共涉及21辆车，造成16辆车起火燃烧，致2死9伤。目前，火已扑灭，事故原因正在调查中。    现场视频显示，一高速公路某路段有两处车辆起火，两个起火点相距较近，其中一处火势凶猛，冒出滚滚黑烟，数十辆车辆堵在起火点后方。    今日14时许，聊城市公安局高速交警支队发布通报称，11月12日7时至8时，青银高速高唐境内因突发团雾，在420公里至421公里（石家庄方向）之间，两处发生车辆碰撞起火燃烧事故。经初步勘查，两处事故共涉及21辆车，造成16辆车起火燃烧。事故造成2人死亡，9人受伤，受伤人员得到救治，均无生命危险。 目前，事故现场火已扑灭，事故原因正在调查中。    新京报记者 张彤    编辑 潘佳锟 校对 陆爱英   "}
     */

    private String ERRORCODE;
    private RESULTBean RESULT;

    public String getERRORCODE() {
        return ERRORCODE;
    }

    public void setERRORCODE(String ERRORCODE) {
        this.ERRORCODE = ERRORCODE;
    }

    public RESULTBean getRESULT() {
        return RESULT;
    }

    public void setRESULT(RESULTBean RESULT) {
        this.RESULT = RESULT;
    }

    public static class RESULTBean {
        /**
         * imgUrl : []
         * editor :
         * publishTime : 2018-11-12 15:30:03
         * source : 新京报
         * category : 要闻
         * title : 山东青银高速两处车辆碰撞燃烧 16车起火致2死9伤
         * content :    新京报讯（记者 张彤）今日（12日），山东聊城青银高速高唐境内因突发团雾，在420公里至421公里（石家庄方向）之间两处发生车辆碰撞起火燃烧事故。聊城市公安局高速交警支队发布通报称，两处事故共涉及21辆车，造成16辆车起火燃烧，致2死9伤。目前，火已扑灭，事故原因正在调查中。    现场视频显示，一高速公路某路段有两处车辆起火，两个起火点相距较近，其中一处火势凶猛，冒出滚滚黑烟，数十辆车辆堵在起火点后方。    今日14时许，聊城市公安局高速交警支队发布通报称，11月12日7时至8时，青银高速高唐境内因突发团雾，在420公里至421公里（石家庄方向）之间，两处发生车辆碰撞起火燃烧事故。经初步勘查，两处事故共涉及21辆车，造成16辆车起火燃烧。事故造成2人死亡，9人受伤，受伤人员得到救治，均无生命危险。 目前，事故现场火已扑灭，事故原因正在调查中。    新京报记者 张彤    编辑 潘佳锟 校对 陆爱英
         */

        private String editor;
        private String publishTime;
        private String source;
        private String category;
        private String title;
        private String content;
        private List<?> imgUrl;

        public String getEditor() {
            return editor;
        }

        public void setEditor(String editor) {
            this.editor = editor;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public List<?> getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(List<?> imgUrl) {
            this.imgUrl = imgUrl;
        }
    }
}
