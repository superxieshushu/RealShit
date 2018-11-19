package com.saltedfish.realshit.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by SaltedFish on 2018/11/14.
 * 简单描述作用
 */
public class TodayInfo {
    private boolean error;
    private ResultsBean results;
    private List<String> category;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public ResultsBean getResults() {
        return results;
    }

    public void setResults(ResultsBean results) {
        this.results = results;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public static class ResultsBean {

        private List<AndroidBean> Android;

        private List<AppBean> App;

        private List<IOSBean> iOS;

        @SerializedName("休息视频")
        private List<VideoBean> video;

        @SerializedName("前端")
        private List<WebBean> web;

        @SerializedName("拓展资源")
        private List<ExtendBean> extend;

        @SerializedName("瞎推荐")
        private List<RecommendBean> recommend;

        @SerializedName("福利")
        private List<BenefitBean> benefit;

        public List<AndroidBean> getAndroid() {
            return Android;
        }

        public void setAndroid(List<AndroidBean> Android) {
            this.Android = Android;
        }

        public List<AppBean> getApp() {
            return App;
        }

        public void setApp(List<AppBean> App) {
            this.App = App;
        }

        public List<IOSBean> getIOS() {
            return iOS;
        }

        public void setIOS(List<IOSBean> iOS) {
            this.iOS = iOS;
        }

        public List<IOSBean> getiOS() {
            return iOS;
        }

        public List<VideoBean> getVideo() {
            return video;
        }

        public List<WebBean> getWeb() {
            return web;
        }

        public List<ExtendBean> getExtend() {
            return extend;
        }

        public List<RecommendBean> getRecommend() {
            return recommend;
        }

        public List<BenefitBean> getBenefit() {
            return benefit;
        }

        public void setiOS(List<IOSBean> iOS) {
            this.iOS = iOS;
        }

        public void setVideo(List<VideoBean> video) {
            this.video = video;
        }

        public void setWeb(List<WebBean> web) {
            this.web = web;
        }

        public void setExtend(List<ExtendBean> extend) {
            this.extend = extend;
        }

        public void setRecommend(List<RecommendBean> recommend) {
            this.recommend = recommend;
        }

        public void setBenefit(List<BenefitBean> benefit) {
            this.benefit = benefit;
        }

        public static class AndroidBean {
            /**
             * _id : 5bc49bb99d2122791c972ca9
             * createdAt : 2018-10-15T13:52:57.103Z
             * desc : 新版youtube视频效果
             * images : ["https://ww1.sinaimg.cn/large/0073sXn7gy1fwyf8dcpt0g308w0fse83","https://ww1.sinaimg.cn/large/0073sXn7gy1fwyf8gpdc4g308w0fsnpg"]
             * publishedAt : 2018-11-06T00:00:00.0Z
             * source : web
             * type : Android
             * url : https://github.com/moyokoo/YoutubeVideoSample
             * used : true
             * who : miaoyj
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;
            private List<String> images;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }
        }

        public static class AppBean {
            /**
             * _id : 5bcd6a6f9d2122185f44ef67
             * createdAt : 2018-10-22T06:13:03.744Z
             * desc : Shotang-App。
             * images : ["https://ww1.sinaimg.cn/large/0073sXn7gy1fwyf8h7kh7j30k0140gpe","https://ww1.sinaimg.cn/large/0073sXn7gy1fwyf8hkaxdj30k0140win"]
             * publishedAt : 2018-11-06T00:00:00.0Z
             * source : chrome
             * type : App
             * url : https://github.com/Shashank02051997/Shotang-App
             * used : true
             * who : lijinshanmx
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;
            private List<String> images;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }
        }

        public static class IOSBean {
            /**
             * _id : 5bcfdbe59d2122185c3cfe28
             * createdAt : 2018-10-24T02:41:41.176Z
             * desc : 一种验证码输入 UI 控件
             * images : ["https://ww1.sinaimg.cn/large/0073sXn7gy1fwyf8i1je4j30ec0t6ju1"]
             * publishedAt : 2018-11-06T00:00:00.0Z
             * source : web
             * type : iOS
             * url : https://github.com/zhwayne/WLUnitField
             * used : true
             * who : Wayne
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;
            private List<String> images;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }
        }

        public static class VideoBean {
            /**
             * _id : 5be14eb39d21223d7a1b0abb
             * createdAt : 2018-11-06T08:20:03.58Z
             * desc : #行不行😂😂
             * publishedAt : 2018-11-06T00:00:00.0Z
             * source : web
             * type : 休息视频
             * url : https://v.douyin.com/RPTYPR/
             * used : true
             * who : lijinshanmx
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }
        }

        public static class WebBean {
            /**
             * _id : 5bcec94e9d21220315c66400
             * createdAt : 2018-10-23T07:10:06.23Z
             * desc : 整理与收集的一些比较优秀github项目，方便自己阅读，顺便分享出来，大家一起学习
             * publishedAt : 2018-11-06T00:00:00.0Z
             * source : web
             * type : 前端
             * url : https://mp.weixin.qq.com/s/jM29svLc1hpamhgntxgdWg
             * used : true
             * who : ttdttt
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }
        }

        public static class ExtendBean {
            /**
             * _id : 5bc63ba69d2122031e77a35d
             * createdAt : 2018-11-06T07:57:17.450Z
             * desc : 模块化、组件化、插件化，傻傻分不清楚……
             * publishedAt : 2018-11-06T00:00:00.0Z
             * source : web
             * type : 拓展资源
             * url : https://mp.weixin.qq.com/s/-gC8JpmmCZWzcOsH5ZzLtQ
             * used : true
             * who : imononoke
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }
        }

        public static class RecommendBean {
            /**
             * _id : 5bda54db9d21223dd88989c4
             * createdAt : 2018-11-01T01:20:27.288Z
             * desc : 程序员在线工具箱
             * publishedAt : 2018-11-06T00:00:00.0Z
             * source : web
             * type : 瞎推荐
             * url : https://www.toolfk.com/
             * used : true
             * who : 蒋朋
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }
        }

        public static class BenefitBean {
            /**
             * _id : 5be14edb9d21223dd50660f8
             * createdAt : 2018-11-06T08:20:43.656Z
             * desc : 2018-11-06
             * publishedAt : 2018-11-06T00:00:00.0Z
             * source : web
             * type : 福利
             * url : https://ws1.sinaimg.cn/large/0065oQSqgy1fwyf0wr8hhj30ie0nhq6p.jpg
             * used : true
             * who : lijinshanmx
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }
        }
    }
}
