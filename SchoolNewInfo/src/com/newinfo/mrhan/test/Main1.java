package com.newinfo.mrhan.test;

import com.mrhan.database.allrounddaos.EntityDaos;
import com.mrhan.database.allrounddaos.exception.EntityException;
import com.mrhan.database.connection.MySQLDBConnnect;
import com.newinfo.mrhan.modles.UserInfo;
import com.newinfo.mrhan.modles.UserMsg;
import com.newinfo.mrhan.modles.UserType;

import java.util.List;

public class Main1 {
    public static void main(String args[]){
       test2();
    }

    private static void test2() {
        MySQLDBConnnect msc =new MySQLDBConnnect("root","123456");
        EntityDaos<UserType> ut = new EntityDaos<>(msc,"newinfo",UserType.class);
        EntityDaos<UserMsg> msg = new EntityDaos<>(msc,"newinfo",UserMsg.class);
        EntityDaos<UserInfo> info = new EntityDaos<>(msc,"newinfo",UserInfo.class);
        msg.clearTableDate();
        info.clearTableDate();

        for(int i=3;i<10;i++){
            boolean insert=false;
            try {
                 insert = ut.insert(new UserType(i < 7 ? "用户" + i : "管理" + i, i));
            }catch(EntityException ee){
                ut.clearTableDate();
            }
            System.out.println(insert);

        }
        List<UserType> all = ut.selectAll();
        for(UserType u :all){
            System.out.println(u);
        }

    }

    private static void test1() {
        MySQLDBConnnect msc =new MySQLDBConnnect("root","123456");
        EntityDaos<UserType> ut = new EntityDaos<>(msc,"newinfo",UserType.class);
        UserType o =ut.get("typeName","游客");
        o.setTypeId(5);
        System.out.println(  ut.insert(o));
    }
}
