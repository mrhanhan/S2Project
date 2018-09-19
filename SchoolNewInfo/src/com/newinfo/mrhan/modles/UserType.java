package com.newinfo.mrhan.modles;

import com.mrhan.database.allrounddaos.ColumentType;
import com.mrhan.database.allrounddaos.DaoColument;
import com.mrhan.database.allrounddaos.DaoTable;

@DaoTable(entityClass = UserType.class,table = "usertype",forginClass = {UserInfo.class})
public class UserType {
    @DaoColument(col = "typeid",colType = ColumentType.PIRMARYKEY,isGrowth = true)
    private int typeId;
    @DaoColument(col = "typeName",colType = ColumentType.UNIQUE)
    private String typeName;
    @DaoColument(col = "typeLevar")
    private int typeLever;

    public String getTypeName() {
        return typeName;
    }

    public int getTypeId() {
        return typeId;
    }

    public int getTypeLever() {
        return typeLever;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public void setTypeLever(int typeLever) {
        this.typeLever = typeLever;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "UserType{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", typeLever=" + typeLever +
                '}';
    }

    public UserType() {
    }


    public UserType(String typeName, int typeLever) {

        this.typeName = typeName;
        this.typeLever = typeLever;
    }

    public UserType(int typeId, String typeName, int typeLever) {

        this.typeId = typeId;
        this.typeName = typeName;
        this.typeLever = typeLever;
    }
}
