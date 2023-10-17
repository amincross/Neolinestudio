package com.neolinestudio.app.models;

public class MyData {
    private int avatar;
    private String username;
    private String onlineTime;
    private String longText;
    private int bigImage;

    private int viewCount;
    private int likeCount;
    private int commentCount;
    private int retweetCount;

    private String createDate;
    private boolean canBid;

    public MyData(int avatar, String username, String onlineTime, String longText, int bigImage, int viewCount, int likeCount, int commentCount, int retweetCount, String createDate, boolean canBid) {
        this.avatar = avatar;
        this.username = username;
        this.onlineTime = onlineTime;
        this.longText = longText;
        this.bigImage = bigImage;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.retweetCount = retweetCount;
        this.createDate = createDate;
        this.canBid = canBid;
    }

    public int getAvatar() {
        return avatar;
    }

    public String getUsername() {
        return username;
    }

    public String getOnlineTime() {
        return onlineTime;
    }

    public String getLongText() {
        return longText;
    }

    public int getBigImage() {
        return bigImage;
    }

    public int getViewCount() {
        return viewCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public int getRetweetCount() {
        return retweetCount;
    }

    public String getCreateDate() {
        return createDate;
    }

    public boolean isCanBid() {
        return canBid;
    }
}
