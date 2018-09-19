package com.newinfo.mrhan.modles;

import com.mrhan.database.allrounddaos.ColumentType;
import com.mrhan.database.allrounddaos.DaoColument;
import com.mrhan.database.allrounddaos.DaoTable;

@DaoTable(entityClass = NewInfoType.class,table = "newinfotype")
public class NewInfoType {
    @DaoColument(col = "infotypeid",colType = ColumentType.PIRMARYKEY,isGrowth = true)
    private int typeId;
    @DaoColument(col = "infotypetitle",colType = ColumentType.UNIQUE)
    private String typeName;
    @DaoColument(col = "infotype")
    private String type;//类型说明

    public NewInfoType(int typeId, String typeName, String type) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.type = type;
    }

    public NewInfoType() {

    }

    public NewInfoType(String typeName, String type) {
        this.typeName = typeName;
        this.type = type;
    }

    public int getTypeId() {
        return typeId;
    }

    @Override
    public String toString() {
        return "NewInfoType{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
