package com.newinfo.mrhan.modles;

import com.mrhan.database.allrounddaos.ColumentType;
import com.mrhan.database.allrounddaos.DaoColument;
import com.mrhan.database.allrounddaos.DaoTable;

/**
 * 用户信息
 */
@DaoTable(entityClass = UserMsg.class,table = "userMsg")
public class UserMsg {
    @DaoColument(col = "id",isGrowth = true,colType = ColumentType.PIRMARYKEY)
    private int id;//编号
    @DaoColument(col = "userid",colType = ColumentType.FORGINKEY,forginClass = UserInfo.class,forginKey = "userid")
    private UserInfo userid;//用户编号
    @DaoColument(col = "userImg")
    private String userImg;//用户头像
    @DaoColument(col = "userSex")
    private String sex;//用户性别
    @DaoColument(col = "userAge")
    private int userAge;//用户年龄
    @DaoColument(col = "userPhone")
    private String userPhone;//联系电话
    @DaoColument(col = "userAddress")
    private String userAddress;//用户地址

    public UserMsg(int id, UserInfo userid, String userImg, String sex, int userAge, String userPhone, String userAddress) {
        this.id = id;
        this.userid = userid;
        this.userImg = userImg;
        this.sex = sex;
        this.userAge = userAge;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
    }

    public UserMsg(int id, UserInfo userid, String userImg, String sex, int userAge) {
        this.id = id;
        this.userid = userid;
        this.userImg = userImg;
        this.sex = sex;
        this.userAge = userAge;
    }

    public UserMsg() {
    }

    public UserMsg(UserInfo userid, String userImg, String sex, int userAge) {
        this.userid = userid;
        this.userImg = userImg;
        this.sex = sex;
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "UserMsg{" +
                "id=" + id +
                ", userid=" + userid +
                ", userImg='" + userImg + '\'' +
                ", sex='" + sex + '\'' +
                ", userAge=" + userAge +
                ", userPhone='" + userPhone + '\'' +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserInfo getUserid() {
        return userid;
    }

    public void setUserid(UserInfo userid) {
        this.userid = userid;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public UserMsg(UserInfo userid, String userImg, String sex, int userAge, String userPhone, String userAddress) {
        this.userid = userid;
        this.userImg = userImg;
        this.sex = sex;
        this.userAge = userAge;

        this.userPhone = userPhone;
        this.userAddress = userAddress;
    }
}
