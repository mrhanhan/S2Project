package com.newinfo.mrhan.service;

import com.mrhan.database.allrounddaos.EntityDaos;
import com.mrhan.database.allrounddaos.SQLWhere;
import com.newinfo.mrhan.ApplictionConfig;
import com.newinfo.mrhan.modles.UserInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManager {
    /**
     * 静态集合！存储当前网站所有登陆的用户
     */
    private static volatile Map<String,UserInfo> allLoignUser = new HashMap<String,UserInfo>();

    private EntityDaos<UserInfo> userDao ;


    public UserManager(){
        ApplictionConfig config = ApplictionConfig.getConfig();//获取配置类
        userDao = new EntityDaos<>(config.getDatabaseConnnect(),config.getUseDatabase(),UserInfo.class);
    }


    /**
     * 用户登录
     * @param user
     * @param pwd
     * @return
     */
    public boolean userLogin(String user,String pwd){
        SQLWhere sl = new SQLWhere("user",user);
        List<UserInfo> users = userDao.selectDate(sl,new SQLWhere("",pwd));
        return false;
    }

}
