package com.newinfo.mrhan.modles;

import com.mrhan.database.allrounddaos.ColumentType;
import com.mrhan.database.allrounddaos.DaoColument;
import com.mrhan.database.allrounddaos.DaoTable;

/**
 * 用户信息类
 */
@DaoTable(entityClass = UserInfo.class,table = "userinfo",forginClass = {UserMsg.class,NewInfoMsg.class})
public class UserInfo {
    @DaoColument(col = "userid",isGrowth = true,colType = ColumentType.PIRMARYKEY)
    private int userid;//编号
    @DaoColument(col = "userCode",colType = ColumentType.UNIQUE)
    private int userCode;//识别码
    @DaoColument(col = "userName")
    private int userName;//用户名
    @DaoColument(col = "userPwd")
    private int userPwd;//密码
    @DaoColument(col = "userAcc")
    private int userAcc;//账号
    @DaoColument(col = "userType",colType = ColumentType.FORGINKEY,forginClass = UserType.class,forginKey = "typeid")
    private UserType userType;//用户名

    public UserInfo(int userCode, int userName, int userPwd, int userAcc, UserType userType) {
        this.userCode = userCode;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userAcc = userAcc;
        this.userType = userType;
    }

    public UserInfo() {

    }

    public UserInfo(int userid, int userCode, int userName, int userPwd, int userAcc, UserType userType) {

        this.userid = userid;
        this.userCode = userCode;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userAcc = userAcc;
        this.userType = userType;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public int getUserName() {
        return userName;
    }

    public void setUserName(int userName) {
        this.userName = userName;
    }

    public int getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(int userPwd) {
        this.userPwd = userPwd;
    }

    public int getUserAcc() {
        return userAcc;
    }

    public void setUserAcc(int userAcc) {
        this.userAcc = userAcc;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userid=" + userid +
                ", userCode=" + userCode +
                ", userName=" + userName +
                ", userPwd=" + userPwd +
                ", userAcc=" + userAcc +
                ", userType=" + userType +
                '}';
    }
}
