package com.newinfo.mrhan.modles;

import com.mrhan.database.allrounddaos.ColumentType;
import com.mrhan.database.allrounddaos.DaoColument;
import com.mrhan.database.allrounddaos.DaoTable;

/**
 * 新闻关键字关联表
 */
@DaoTable(table = "newinfo_key",entityClass = NewInfoKey.class)
public class NewInfoKey {
    @DaoColument(col="id",isGrowth = true,colType = ColumentType.PIRMARYKEY)
    private int id;//关联编号
    @DaoColument(col = "keyid",colType = ColumentType.FORGINKEY,forginClass = KeyWord.class,forginKey = "keyid")
    private KeyWord keyWord;//关键字对象
    @DaoColument(col = "infoid",colType = ColumentType.FORGINKEY,forginClass = NewInfo.class,forginKey = "infoid")
    private NewInfo newinfo;//新闻关键字

    public NewInfoKey(KeyWord keyWord, NewInfo newinfo) {

        this.keyWord = keyWord;
        this.newinfo = newinfo;
    }
    public NewInfoKey(){}
    public NewInfoKey(int id, KeyWord keyWord, NewInfo newinfo) {
        this.id = id;
        this.keyWord = keyWord;
        this.newinfo = newinfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public KeyWord getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(KeyWord keyWord) {
        this.keyWord = keyWord;
    }

    public NewInfo getNewinfo() {
        return newinfo;
    }

    public void setNewinfo(NewInfo newinfo) {
        this.newinfo = newinfo;
    }

    @Override
    public String toString() {
        return "NewInfoKey{" +
                "id=" + id +
                ", keyWord=" + keyWord +
                ", newinfo=" + newinfo +
                '}';
    }
}
