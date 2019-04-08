package com.example.t.app.entity;

import java.util.List;

public class LiveContent {
    @Override
    public String toString() {
        return "LiveContent{" +
                "ERRORCODE='" + ERRORCODE + '\'' +
                ", RESULT=" + RESULT +
                '}';
    }

    /**
     * ERRORCODE : 0
     * RESULT : {"newsList":[{"publishTime":"2018-11-08 18:40:00","newsId":"94d577cfb29fca02781b395aa63b113a","newsImg":"//inews.gtimg.com/newsapp_ls/0/6232655023_150120/0","source":"","category":"财经","title":"博鳌亚洲论坛青年会议在香港举行"},{"publishTime":"2018-11-08 18:21:46","newsId":"b505bd83e49bf4d1782e42444da11965","newsImg":"//inews.gtimg.com/newsapp_ls/0/6232394802_150120/0","source":"中国房地产报","category":"财经","title":"万科否认暂停\u201c万村计划\u201d 总是中枪的深圳城中村理想"},{"publishTime":"2018-11-08 18:18:00","newsId":"b896d4bbf84e5c9f7f8830b4fd912be1","newsImg":"//inews.gtimg.com/newsapp_ls/0/6232194208_150120/0","source":"中国证券报","category":"财经","title":"刘士余和证券基金行业哪些首席经济学家座谈？名单在此"},{"publishTime":"2018-11-08 18:15:00","newsId":"c3721e24d33b8094731a2fe735c432cb","newsImg":"//inews.gtimg.com/newsapp_ls/0/6232138711_150120/0","source":"","category":"财经","title":"海航控股终止近105亿元收购多项航运资产事项"},{"publishTime":"2018-11-08 18:10:43","newsId":"07fd681d3bb50cc3db94b25fb9487ce7","newsImg":"//inews.gtimg.com/newsapp_ls/0/6232486645_150120/0","source":"中国房地产报","category":"财经","title":"安徽一楼盘降价6000元/平方米 房产局长亲自去调研后回涨"},{"publishTime":"2018-11-08 18:00:03","newsId":"b69af3bbf4c5bf9009845bfce7e7b39f","newsImg":"//inews.gtimg.com/newsapp_ls/0/6232896887_150120/0","source":"新京报","category":"财经","title":"酸碱体质\u201c大师\u201d被罚一亿美元：别让理论骗子们跑了"},{"publishTime":"2018-11-08 17:57:00","newsId":"caa15cae261fd4361ad4afb888ab5de7","newsImg":"//inews.gtimg.com/newsapp_ls/0/6231716282_150120/0","source":"经济日报","category":"财经","title":"郭树清：推动金融机构敢贷能贷愿贷 消除金融服务民企的隐形壁垒"},{"publishTime":"2018-11-08 17:53:53","newsId":"82761e125eb377ba52aeb2b2104dd8fc","newsImg":"//inews.gtimg.com/newsapp_ls/0/6232831071_150120/0","source":"小小金融","category":"财经","title":"2019年房价还会上涨吗？打算买房的要小心！"},{"publishTime":"2018-11-08 17:52:55","newsId":"0d8c6d28002229cdb31bcc89ddfffceb","newsImg":"//inews.gtimg.com/newsapp_ls/0/6232820883_150120/0","source":"参考消息","category":"财经","title":"进博会释放自由贸易信心 外媒：美政策把世界推向\u201c中国市场\u201d"},{"publishTime":"2018-11-08 17:47:00","newsId":"a7087cfa4e8bf1d1fc3bfdff6ed36570","newsImg":"//inews.gtimg.com/newsapp_ls/0/6231483509_150120/0","source":"","category":"财经","title":"只是开始！监管就互联网贷款制定管理办法，未来会进一步加强规范"},{"publishTime":"2018-11-08 17:40:46","newsId":"ee9b9c96558a2daf8914f0b4f7a22e0f","newsImg":"//inews.gtimg.com/newsapp_ls/0/6232598566_150120/0","source":"华商韬略","category":"财经","title":"定了！京沪高铁IPO"},{"publishTime":"2018-11-08 17:37:55","newsId":"c698f3bf00fed6fb2eca526d6d5c1712","newsImg":"//inews.gtimg.com/newsapp_ls/0/6232751110_150120/0","source":"钛媒体APP","category":"财经","title":"美国CFTC前主席：区块链纳入监管前，无法体现真正价值"},{"publishTime":"2018-11-08 17:36:28","newsId":"43e47c4560f758b7d0eb66211674d210","newsImg":"//inews.gtimg.com/newsapp_ls/0/6231778351_150120/0","source":"野马财经","category":"财经","title":"这家国企也有3位90后美女董高监，上任半年净利暴涨87%？"},{"publishTime":"2018-11-08 17:36:16","newsId":"7453f5a99835ee1c5a729b57db28ea3a","newsImg":"//inews.gtimg.com/newsapp_ls/0/6232803330_150120/0","source":"华夏时报","category":"财经","title":"私募大佬三季度持仓路径分化 押宝生物医药变为\u201c重伤员\u201d"},{"publishTime":"2018-11-08 17:33:00","newsId":"77aed71dde2d94fd43989af9baeab14a","newsImg":"//inews.gtimg.com/newsapp_ls/0/6231135229_150120/0","source":"","category":"财经","title":"灼见 | 10月中国进出口数据超预期 出口悲观论根据不足"},{"publishTime":"2018-11-08 17:31:00","newsId":"92f3e47465de93f7cc2e934556d30126","newsImg":"//inews.gtimg.com/newsapp_ls/0/6231112526_150120/0","source":"","category":"财经","title":"灼见丨民生银行研究院王静文：为什么中国选择在此时扩大进口？"},{"publishTime":"2018-11-08 17:29:00","newsId":"60321669ccd4a19ce1a330cb0edf2c96","newsImg":"//inews.gtimg.com/newsapp_ls/0/6231082817_150120/0","source":"","category":"财经","title":"灼见 | 进口红利重塑中国经济增长动力"},{"publishTime":"2018-11-08 17:25:00","newsId":"0f4d18669de807ef825f6ed85efe474d","newsImg":"//inews.gtimg.com/newsapp_ls/0/6230970803_150120/0","source":"","category":"财经","title":"四大美人漫谈网购掉坑记：需要注意哪些防骗技巧"},{"publishTime":"2018-11-08 17:23:58","newsId":"0d11238d5f0da8240be3decb1eaa8390","newsImg":"//inews.gtimg.com/newsapp_ls/0/6232186049_150120/0","source":"小小金融","category":"财经","title":"不久的将来，已经持有房产的人，将不得不面对这3个问题！"},{"publishTime":"2018-11-08 17:23:12","newsId":"f3e28f94165524093817f2bf5bcaa1eb","newsImg":"//inews.gtimg.com/newsapp_ls/0/6231153622_150120/0","source":"中国财经报社","category":"财经","title":"14省市上调最低工资标准 各地的\u201c含金量\u201d却不尽相同"},{"publishTime":"2018-11-08 17:20:46","newsId":"3517ac1e6edb7f004c80b9993de1f54d","newsImg":"//inews.gtimg.com/newsapp_ls/0/6231178037_150120/0","source":"中国网","category":"财经","title":"信了16年的\u201c酸碱体质\u201d居然是个骗局！美国创始人被罚1亿美元"},{"publishTime":"2018-11-08 17:14:00","newsId":"e9bf0c2bf45a00eac75bdcb3165249a9","newsImg":"//inews.gtimg.com/newsapp_ls/0/6230770686_150120/0","source":"华尔街见闻","category":"财经","title":"中国10月车市\u201c透心凉\u201d 销量同比下滑13.2%"},{"publishTime":"2018-11-08 17:11:21","newsId":"7c85b079a32991afb6e0bf4b77a64180","newsImg":"//inews.gtimg.com/newsapp_ls/0/6231170326_150120/0","source":"券商中国","category":"财经","title":"首次！刘士余和首席经济学家座谈，对首席们提出新要求"},{"publishTime":"2018-11-08 17:10:45","newsId":"96f9d99d258c3e2194cd2bcbda6d2996","newsImg":"//inews.gtimg.com/newsapp_ls/0/6232090402_150120/0","source":"经济日报","category":"财经","title":"前十月我国外贸增长11.3％ 贸易顺差收窄26.1％"},{"publishTime":"2018-11-08 17:08:00","newsId":"6fbcb3aac7df5ba455a6ab21ed7616b9","newsImg":"//inews.gtimg.com/newsapp_ls/0/6230568812_150120/0","source":"","category":"财经","title":"国办发文进一步优化营商环境政策 缓解中小微企业融资难"},{"publishTime":"2018-11-08 17:03:00","newsId":"a6fbbcddd1a07eeb2b7dfbc182938632","newsImg":"//inews.gtimg.com/newsapp_ls/0/6230482081_150120/0","source":"","category":"财经","title":"最高法副院长：严格遵循疑罪从无原则，让企业家轻装前进"},{"publishTime":"2018-11-08 17:01:00","newsId":"4411d3079631c1619cfd276fa22c3367","newsImg":"//inews.gtimg.com/newsapp_ls/0/6230440282_150120/0","source":"澎湃新闻","category":"财经","title":"苹果被曝拒绝与高通和解：\u201c它们的法律纠纷没有商谈的可能\u201d"},{"publishTime":"2018-11-08 16:58:00","newsId":"b6ac2c510b6d06ef4c4a5ebbfa839bfa","newsImg":"//inews.gtimg.com/newsapp_ls/0/6230403266_150120/0","source":"","category":"财经","title":"一线|招商证券与招商资管出资20.1亿元成立纾困资管计划"},{"publishTime":"2018-11-08 16:54:44","newsId":"562af5ba166d70f7862e9e76c93e10e3","newsImg":"//inews.gtimg.com/newsapp_ls/0/6231235708_150120/0","source":"澎湃新闻","category":"财经","title":"比尔·盖茨谈访华\u201c新头衔\u201d：\u201c中国人民老朋友\u201d是很大褒奖"},{"publishTime":"2018-11-08 16:49:53","newsId":"2646aef147c05d2bd53fe4f9a9de9a50","newsImg":"//inews.gtimg.com/newsapp_ls/0/6231473113_150120/0","source":"财联社","category":"财经","title":"京东投资版图浮出水面 参股又一家私募基金曝光"}],"page":1,"allPage":10}
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
         * newsList : [{"publishTime":"2018-11-08 18:40:00","newsId":"94d577cfb29fca02781b395aa63b113a","newsImg":"//inews.gtimg.com/newsapp_ls/0/6232655023_150120/0","source":"","category":"财经","title":"博鳌亚洲论坛青年会议在香港举行"},{"publishTime":"2018-11-08 18:21:46","newsId":"b505bd83e49bf4d1782e42444da11965","newsImg":"//inews.gtimg.com/newsapp_ls/0/6232394802_150120/0","source":"中国房地产报","category":"财经","title":"万科否认暂停\u201c万村计划\u201d 总是中枪的深圳城中村理想"},{"publishTime":"2018-11-08 18:18:00","newsId":"b896d4bbf84e5c9f7f8830b4fd912be1","newsImg":"//inews.gtimg.com/newsapp_ls/0/6232194208_150120/0","source":"中国证券报","category":"财经","title":"刘士余和证券基金行业哪些首席经济学家座谈？名单在此"},{"publishTime":"2018-11-08 18:15:00","newsId":"c3721e24d33b8094731a2fe735c432cb","newsImg":"//inews.gtimg.com/newsapp_ls/0/6232138711_150120/0","source":"","category":"财经","title":"海航控股终止近105亿元收购多项航运资产事项"},{"publishTime":"2018-11-08 18:10:43","newsId":"07fd681d3bb50cc3db94b25fb9487ce7","newsImg":"//inews.gtimg.com/newsapp_ls/0/6232486645_150120/0","source":"中国房地产报","category":"财经","title":"安徽一楼盘降价6000元/平方米 房产局长亲自去调研后回涨"},{"publishTime":"2018-11-08 18:00:03","newsId":"b69af3bbf4c5bf9009845bfce7e7b39f","newsImg":"//inews.gtimg.com/newsapp_ls/0/6232896887_150120/0","source":"新京报","category":"财经","title":"酸碱体质\u201c大师\u201d被罚一亿美元：别让理论骗子们跑了"},{"publishTime":"2018-11-08 17:57:00","newsId":"caa15cae261fd4361ad4afb888ab5de7","newsImg":"//inews.gtimg.com/newsapp_ls/0/6231716282_150120/0","source":"经济日报","category":"财经","title":"郭树清：推动金融机构敢贷能贷愿贷 消除金融服务民企的隐形壁垒"},{"publishTime":"2018-11-08 17:53:53","newsId":"82761e125eb377ba52aeb2b2104dd8fc","newsImg":"//inews.gtimg.com/newsapp_ls/0/6232831071_150120/0","source":"小小金融","category":"财经","title":"2019年房价还会上涨吗？打算买房的要小心！"},{"publishTime":"2018-11-08 17:52:55","newsId":"0d8c6d28002229cdb31bcc89ddfffceb","newsImg":"//inews.gtimg.com/newsapp_ls/0/6232820883_150120/0","source":"参考消息","category":"财经","title":"进博会释放自由贸易信心 外媒：美政策把世界推向\u201c中国市场\u201d"},{"publishTime":"2018-11-08 17:47:00","newsId":"a7087cfa4e8bf1d1fc3bfdff6ed36570","newsImg":"//inews.gtimg.com/newsapp_ls/0/6231483509_150120/0","source":"","category":"财经","title":"只是开始！监管就互联网贷款制定管理办法，未来会进一步加强规范"},{"publishTime":"2018-11-08 17:40:46","newsId":"ee9b9c96558a2daf8914f0b4f7a22e0f","newsImg":"//inews.gtimg.com/newsapp_ls/0/6232598566_150120/0","source":"华商韬略","category":"财经","title":"定了！京沪高铁IPO"},{"publishTime":"2018-11-08 17:37:55","newsId":"c698f3bf00fed6fb2eca526d6d5c1712","newsImg":"//inews.gtimg.com/newsapp_ls/0/6232751110_150120/0","source":"钛媒体APP","category":"财经","title":"美国CFTC前主席：区块链纳入监管前，无法体现真正价值"},{"publishTime":"2018-11-08 17:36:28","newsId":"43e47c4560f758b7d0eb66211674d210","newsImg":"//inews.gtimg.com/newsapp_ls/0/6231778351_150120/0","source":"野马财经","category":"财经","title":"这家国企也有3位90后美女董高监，上任半年净利暴涨87%？"},{"publishTime":"2018-11-08 17:36:16","newsId":"7453f5a99835ee1c5a729b57db28ea3a","newsImg":"//inews.gtimg.com/newsapp_ls/0/6232803330_150120/0","source":"华夏时报","category":"财经","title":"私募大佬三季度持仓路径分化 押宝生物医药变为\u201c重伤员\u201d"},{"publishTime":"2018-11-08 17:33:00","newsId":"77aed71dde2d94fd43989af9baeab14a","newsImg":"//inews.gtimg.com/newsapp_ls/0/6231135229_150120/0","source":"","category":"财经","title":"灼见 | 10月中国进出口数据超预期 出口悲观论根据不足"},{"publishTime":"2018-11-08 17:31:00","newsId":"92f3e47465de93f7cc2e934556d30126","newsImg":"//inews.gtimg.com/newsapp_ls/0/6231112526_150120/0","source":"","category":"财经","title":"灼见丨民生银行研究院王静文：为什么中国选择在此时扩大进口？"},{"publishTime":"2018-11-08 17:29:00","newsId":"60321669ccd4a19ce1a330cb0edf2c96","newsImg":"//inews.gtimg.com/newsapp_ls/0/6231082817_150120/0","source":"","category":"财经","title":"灼见 | 进口红利重塑中国经济增长动力"},{"publishTime":"2018-11-08 17:25:00","newsId":"0f4d18669de807ef825f6ed85efe474d","newsImg":"//inews.gtimg.com/newsapp_ls/0/6230970803_150120/0","source":"","category":"财经","title":"四大美人漫谈网购掉坑记：需要注意哪些防骗技巧"},{"publishTime":"2018-11-08 17:23:58","newsId":"0d11238d5f0da8240be3decb1eaa8390","newsImg":"//inews.gtimg.com/newsapp_ls/0/6232186049_150120/0","source":"小小金融","category":"财经","title":"不久的将来，已经持有房产的人，将不得不面对这3个问题！"},{"publishTime":"2018-11-08 17:23:12","newsId":"f3e28f94165524093817f2bf5bcaa1eb","newsImg":"//inews.gtimg.com/newsapp_ls/0/6231153622_150120/0","source":"中国财经报社","category":"财经","title":"14省市上调最低工资标准 各地的\u201c含金量\u201d却不尽相同"},{"publishTime":"2018-11-08 17:20:46","newsId":"3517ac1e6edb7f004c80b9993de1f54d","newsImg":"//inews.gtimg.com/newsapp_ls/0/6231178037_150120/0","source":"中国网","category":"财经","title":"信了16年的\u201c酸碱体质\u201d居然是个骗局！美国创始人被罚1亿美元"},{"publishTime":"2018-11-08 17:14:00","newsId":"e9bf0c2bf45a00eac75bdcb3165249a9","newsImg":"//inews.gtimg.com/newsapp_ls/0/6230770686_150120/0","source":"华尔街见闻","category":"财经","title":"中国10月车市\u201c透心凉\u201d 销量同比下滑13.2%"},{"publishTime":"2018-11-08 17:11:21","newsId":"7c85b079a32991afb6e0bf4b77a64180","newsImg":"//inews.gtimg.com/newsapp_ls/0/6231170326_150120/0","source":"券商中国","category":"财经","title":"首次！刘士余和首席经济学家座谈，对首席们提出新要求"},{"publishTime":"2018-11-08 17:10:45","newsId":"96f9d99d258c3e2194cd2bcbda6d2996","newsImg":"//inews.gtimg.com/newsapp_ls/0/6232090402_150120/0","source":"经济日报","category":"财经","title":"前十月我国外贸增长11.3％ 贸易顺差收窄26.1％"},{"publishTime":"2018-11-08 17:08:00","newsId":"6fbcb3aac7df5ba455a6ab21ed7616b9","newsImg":"//inews.gtimg.com/newsapp_ls/0/6230568812_150120/0","source":"","category":"财经","title":"国办发文进一步优化营商环境政策 缓解中小微企业融资难"},{"publishTime":"2018-11-08 17:03:00","newsId":"a6fbbcddd1a07eeb2b7dfbc182938632","newsImg":"//inews.gtimg.com/newsapp_ls/0/6230482081_150120/0","source":"","category":"财经","title":"最高法副院长：严格遵循疑罪从无原则，让企业家轻装前进"},{"publishTime":"2018-11-08 17:01:00","newsId":"4411d3079631c1619cfd276fa22c3367","newsImg":"//inews.gtimg.com/newsapp_ls/0/6230440282_150120/0","source":"澎湃新闻","category":"财经","title":"苹果被曝拒绝与高通和解：\u201c它们的法律纠纷没有商谈的可能\u201d"},{"publishTime":"2018-11-08 16:58:00","newsId":"b6ac2c510b6d06ef4c4a5ebbfa839bfa","newsImg":"//inews.gtimg.com/newsapp_ls/0/6230403266_150120/0","source":"","category":"财经","title":"一线|招商证券与招商资管出资20.1亿元成立纾困资管计划"},{"publishTime":"2018-11-08 16:54:44","newsId":"562af5ba166d70f7862e9e76c93e10e3","newsImg":"//inews.gtimg.com/newsapp_ls/0/6231235708_150120/0","source":"澎湃新闻","category":"财经","title":"比尔·盖茨谈访华\u201c新头衔\u201d：\u201c中国人民老朋友\u201d是很大褒奖"},{"publishTime":"2018-11-08 16:49:53","newsId":"2646aef147c05d2bd53fe4f9a9de9a50","newsImg":"//inews.gtimg.com/newsapp_ls/0/6231473113_150120/0","source":"财联社","category":"财经","title":"京东投资版图浮出水面 参股又一家私募基金曝光"}]
         * page : 1
         * allPage : 10
         */

        private int page;
        private int allPage;
        private List<NewsListBean> newsList;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getAllPage() {
            return allPage;
        }

        public void setAllPage(int allPage) {
            this.allPage = allPage;
        }

        public List<NewsListBean> getNewsList() {
            return newsList;
        }

        public void setNewsList(List<NewsListBean> newsList) {
            this.newsList = newsList;
        }

        public static class NewsListBean {
            /**
             * publishTime : 2018-11-08 18:40:00
             * newsId : 94d577cfb29fca02781b395aa63b113a
             * newsImg : //inews.gtimg.com/newsapp_ls/0/6232655023_150120/0
             * source :
             * category : 财经
             * title : 博鳌亚洲论坛青年会议在香港举行
             */

            private String publishTime;
            private String newsId;
            private String newsImg;
            private String source;
            private String category;
            private String title;

            public String getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(String publishTime) {
                this.publishTime = publishTime;
            }

            public String getNewsId() {
                return newsId;
            }

            public void setNewsId(String newsId) {
                this.newsId = newsId;
            }

            public String getNewsImg() {
                return newsImg;
            }

            public void setNewsImg(String newsImg) {
                this.newsImg = newsImg;
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
        }
    }
}
