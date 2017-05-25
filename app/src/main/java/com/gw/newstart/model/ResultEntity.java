package com.gw.newstart.model;

import java.util.List;

/**
 * Created by GongWen on 17/5/25.
 */

public class ResultEntity {

    /**
     * error : false
     * results : [{"_id":"59257f4d421aa92c73b64754","createdAt":"2017-05-24T20:40:45.669Z","desc":"Android View绘制源码分析--Measure篇","publishedAt":"2017-05-25T13:32:48.92Z","source":"web","type":"Android","url":"http://rkhcy.github.io/2017/05/24/View%E7%9A%84%E7%BB%98%E5%88%B6-Measure/","used":true,"who":"HuYounger"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 59257f4d421aa92c73b64754
         * createdAt : 2017-05-24T20:40:45.669Z
         * desc : Android View绘制源码分析--Measure篇
         * publishedAt : 2017-05-25T13:32:48.92Z
         * source : web
         * type : Android
         * url : http://rkhcy.github.io/2017/05/24/View%E7%9A%84%E7%BB%98%E5%88%B6-Measure/
         * used : true
         * who : HuYounger
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
