package com.newinfo.mrhan.modles;

import com.mrhan.database.allrounddaos.ColumentType;
import com.mrhan.database.allrounddaos.DaoColument;
import com.mrhan.database.allrounddaos.DaoTable;

/**
 * 新闻附加信息类
 */
@DaoTable(table = "infomsg",entityClass = NewInfoMsg.class)
public class NewInfoMsg {
    @DaoColument(col = "msgid",colType = ColumentType.PIRMARYKEY,isGrowth = true)
    private int msgId;//新闻内容编号
    @DaoColument(col = "infoid",colType = ColumentType.FORGINKEY,forginClass = NewInfo.class,forginKey = "infoid")
    private NewInfo info;//新闻对象
    @DaoColument(col = "userid",colType = ColumentType.FORGINKEY,forginClass = UserInfo.class,forginKey = "userid")
    private UserInfo user;//用户对象
    @DaoColument(col = "infoDate")
    private String date;//发布时间
    @DaoColument(col = "infowatch")
    private int watch;
    @DaoColument(col = "infolike")
    private int like;

    public NewInfoMsg(int msgId, NewInfo info, UserInfo user, String date) {
        this.msgId = msgId;
        this.info = info;
        this.user = user;
        this.date = date;
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public NewInfo getInfo() {
        return info;
    }

    public void setInfo(NewInfo info) {
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
        return "NewInfoMsg{" +
                "msgId=" + msgId +
                ", info=" + info +
                ", user=" + user +
                ", date='" + date + '\'' +
                ", watch=" + watch +
                ", like=" + like +
                '}';
    }

    public NewInfoMsg(NewInfo info, UserInfo user, String date) {
        this.info = info;
        this.user = user;
        this.date = date;
    }

    public NewInfoMsg() {

    }

    public NewInfoMsg(int msgId, NewInfo info, UserInfo user, String date, int watch, int like) {
        this.msgId = msgId;
        this.info = info;
        this.user = user;
        this.date = date;
        this.watch = watch;
        this.like = like;
    }
}
