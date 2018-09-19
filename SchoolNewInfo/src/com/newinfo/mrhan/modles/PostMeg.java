package com.newinfo.mrhan.modles;

import com.mrhan.database.allrounddaos.ColumentType;
import com.mrhan.database.allrounddaos.DaoColument;
import com.mrhan.database.allrounddaos.DaoTable;

/**
 * 帖子内容
 */
@DaoTable(table = "postmsg",entityClass = PostMeg.class)
public class PostMeg {
    @DaoColument(col = "msgid",colType = ColumentType.PIRMARYKEY,isGrowth = true)
    private int msgId;//新闻内容编号
    @DaoColument(col = "postid",colType = ColumentType.FORGINKEY,forginClass = Post.class,forginKey = "postid")
    private Post info;//新闻对象
    @DaoColument(col = "userid",colType = ColumentType.FORGINKEY,forginClass = UserInfo.class,forginKey = "userid")
    private UserInfo user;//用户对象
    @DaoColument(col = "postDate")
    private String date;//发布时间
    @DaoColument(col = "postwatch")
    private int watch;//查看人数
    @DaoColument(col = "postlike")
    private int like;//喜欢人数

    public PostMeg(int msgId, Post info, UserInfo user, String date) {
        this.msgId = msgId;
        this.info = info;
        this.user = user;
        this.date = date;
    }

    public PostMeg(Post info, UserInfo user, String date) {
        this.info = info;
        this.user = user;
        this.date = date;
    }

    public PostMeg() {

    }

    public PostMeg(int msgId, Post info, UserInfo user, String date, int watch, int like) {
        this.msgId = msgId;
        this.info = info;
        this.user = user;
        this.date = date;
        this.watch = watch;
        this.like = like;
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public Post getInfo() {
        return info;
    }

    public void setInfo(Post info) {
        this.info = info;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getWatch() {
        return watch;
    }

    public void setWatch(int watch) {
        this.watch = watch;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    @Override
    public String toString() {
        return "PostMeg{" +
                "msgId=" + msgId +
                ", info=" + info +
                ", user=" + user +
                ", date='" + date + '\'' +
                ", watch=" + watch +
                ", like=" + like +
                '}';
    }
}
