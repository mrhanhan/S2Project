package com.newinfo.mrhan.views;

import com.mrhan.database.allrounddaos.EntityDaos;
import com.newinfo.mrhan.ApplictionConfig;
import com.newinfo.mrhan.modles.NewInfo;

import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.util.List;

public class NewInfoView {
    private JspWriter out;//输出对象
    private List<NewInfo> allDate;
    private ApplictionConfig config;//配置信息类
    private EntityDaos<NewInfo> infoEntityDaos;//信息操作类
    public NewInfoView(JspWriter jw){
        this.out = jw;
        config = ApplictionConfig.getConfig();
        infoEntityDaos = new EntityDaos<>(config.getDatabaseConnnect(),config.getUseDatabase(),NewInfo.class);
        allDate = infoEntityDaos.selectAll();
    }

    public void show(){
        for(NewInfo ni : allDate){
            try {
                out.println(ni);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
