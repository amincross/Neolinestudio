package com.neolinestudio.app.models;

public class MyData {
    private final int avatar;
    private final String username;
    private final String onlineTime;
    private final String longText;
    private final int bigImage;

    private final int viewCount;
    private final int likeCount;
    private final int commentCount;
    private final int retweetCount;

    private final String createDate;
    private final boolean canBid;

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
