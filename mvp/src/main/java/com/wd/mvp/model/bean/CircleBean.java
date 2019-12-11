package com.wd.mvp.model.bean;

import java.util.List;

public class CircleBean {

    /**
     * result : [{"amount":0,"collectionNum":0,"commentNum":4,"detail":"呀呀呀","releaseTime":1575475200000,"sickCircleId":1641,"title":"嘿嘿嘿"},{"amount":0,"collectionNum":0,"commentNum":1,"detail":"呀呀呀","releaseTime":1575475200000,"sickCircleId":1635,"title":"嘿嘿嘿"},{"amount":0,"collectionNum":0,"commentNum":0,"detail":"呀呀呀","releaseTime":1575475200000,"sickCircleId":1636,"title":"嘿嘿嘿"},{"amount":0,"collectionNum":0,"commentNum":0,"detail":"呀呀呀","releaseTime":1575475200000,"sickCircleId":1637,"title":"嘿嘿嘿"},{"amount":0,"collectionNum":0,"commentNum":0,"detail":"呀呀呀","releaseTime":1575475200000,"sickCircleId":1638,"title":"嘿嘿嘿"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * amount : 0
         * collectionNum : 0
         * commentNum : 4
         * detail : 呀呀呀
         * releaseTime : 1575475200000
         * sickCircleId : 1641
         * title : 嘿嘿嘿
         */

        private int amount;
        private int collectionNum;
        private int commentNum;
        private String detail;
        private long releaseTime;
        private int sickCircleId;
        private String title;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getCollectionNum() {
            return collectionNum;
        }

        public void setCollectionNum(int collectionNum) {
            this.collectionNum = collectionNum;
        }

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public int getSickCircleId() {
            return sickCircleId;
        }

        public void setSickCircleId(int sickCircleId) {
            this.sickCircleId = sickCircleId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
