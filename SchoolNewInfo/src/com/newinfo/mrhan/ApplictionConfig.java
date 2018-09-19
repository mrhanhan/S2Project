package com.newinfo.mrhan;

import com.mrhan.database.IDatabaseConnnect;
import com.mrhan.database.connection.MySQLDBConnnect;

/**
 * 应用程序配置类
 */
public class ApplictionConfig {
    private static ApplictionConfig applictionConfig=null;
    private static boolean isLoad = true;//是否需要加载
    public static ApplictionConfig getConfig() {
        if(applictionConfig==null)
            applictionConfig = new ApplictionConfig();
        return applictionConfig;
    }
    // -----------------------------------------------------------------------------------
    private IDatabaseConnnect databaseConnnect;//数据库连接类
    /**
     * 使用的数据库
     */
    private String useDatabase="newinfo";
    private ApplictionConfig(){
        if(isLoad){
            isLoad=false;
            _config();
        }
    }
    private void _config() {
        //介入的数据库
        databaseConnnect = new MySQLDBConnnect("sa","123465");
    }

    /**
     * 获取数据库连接类
     * @return
     */
    public IDatabaseConnnect getDatabaseConnnect() {
        return databaseConnnect;
    }
    /**
     * 设置数据库连接
     * @param databaseConnnect
     */
    public void setDatabaseConnnect(IDatabaseConnnect databaseConnnect) {
        this.databaseConnnect = databaseConnnect;
    }
    /**
     * 获取使用的数据库
     * @return
     */
    public String getUseDatabase() {
        return useDatabase;
    }
}
