package com.newinfo.mrhan.modles;

import com.mrhan.database.allrounddaos.ColumentType;
import com.mrhan.database.allrounddaos.DaoColument;
import com.mrhan.database.allrounddaos.DaoTable;

@DaoTable(table = "newinfo",entityClass = NewInfo.class)
public class NewInfo {
    @DaoColument(col = "infoId",colType = ColumentType.PIRMARYKEY,isGrowth = true)
    private int id;//新闻编号
    @DaoColument(col = "infoTitle")
    private String infoTitle;//新闻内容
    @DaoColument(col = "infoContent")
    private String infoContent;//新闻内容
    @DaoColument(col = "infotypeid",colType = ColumentType.FORGINKEY,forginClass = NewInfoType.class,forginKey = "infotypeid")
    private NewInfoType newinfoType;
    public NewInfo(){}
    public NewInfo(int id, String infoTitle, String infoContent, NewInfoType newinfoType) {
        this.id = id;
        this.infoTitle = infoTitle;
        this.infoContent = infoContent;
        this.newinfoType = newinfoType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent;
    }

    public NewInfoType getNewinfoType() {
        return newinfoType;
    }

    public void setNewinfoType(NewInfoType newinfoType) {
        this.newinfoType = newinfoType;
    }

    @Override
    public String toString() {
        return "NewInfo{" +
                "id=" + id +
                ", infoTitle='" + infoTitle + '\'' +
                ", infoContent='" + infoContent + '\'' +
                ", newinfoType=" + newinfoType +
                '}';
    }

    public NewInfo(String infoTitle, String infoContent, NewInfoType newinfoType) {
        this.infoTitle = infoTitle;
        this.infoContent = infoContent;
        this.newinfoType = newinfoType;
    }
}
