package com.newinfo.mrhan.modles;

import com.mrhan.database.allrounddaos.ColumentType;
import com.mrhan.database.allrounddaos.DaoColument;
import com.mrhan.database.allrounddaos.DaoTable;

/**
 * 关键字实体
 */
@DaoTable(table = "keyword",entityClass = KeyWord.class)
public class KeyWord {
    @DaoColument(col="keyid",isGrowth = true,colType = ColumentType.PIRMARYKEY)
    private int keyid;//关键字编号
    @DaoColument(col = "key",colType = ColumentType.UNIQUE)
    private String key;//关键字
    @DaoColument(col = "content")
    private String keyAuto;//说明

    public KeyWord(int keyid, String key, String keyAuto) {
        this.keyid = keyid;
        this.key = key;
        this.keyAuto = keyAuto;
    }
    public KeyWord(){}
    public KeyWord(String key, String keyAuto) {
        this.key = key;
        this.keyAuto = keyAuto;
    }

    public int getKeyid() {
        return keyid;
    }

    public void setKeyid(int keyid) {
        this.keyid = keyid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKeyAuto() {
        return keyAuto;
    }

    public void setKeyAuto(String keyAuto) {
        this.keyAuto = keyAuto;
    }

    @Override
    public String toString() {
        return "KeyWord{" +
                "keyid=" + keyid +
                ", key='" + key + '\'' +
                ", keyAuto='" + keyAuto + '\'' +
                '}';
    }
}
