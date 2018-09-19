package com.newinfo.mrhan.modles;

import com.mrhan.database.allrounddaos.ColumentType;
import com.mrhan.database.allrounddaos.DaoColument;
import com.mrhan.database.allrounddaos.DaoTable;
import javafx.geometry.Pos;

@DaoTable(table = "posttype",entityClass = PostType.class,forginClass = {Post.class})
public class PostType {
    @DaoColument(col = "posttypeId",isGrowth = true,colType = ColumentType.PIRMARYKEY)
    private int postypeId;//帖子类型
    @DaoColument(col = "postTitle",colType = ColumentType.UNIQUE)
    private String postTitle;//帖子类型标题
    @DaoColument(col = "post")
    private String typeAuto;//帖子类型说明

    public PostType(int postypeId, String postTitle, String typeAuto) {
        this.postypeId = postypeId;
        this.postTitle = postTitle;
        this.typeAuto = typeAuto;
    }

    public int getPostypeId() {
        return postypeId;
    }

    public void setPostypeId(int postypeId) {
        this.postypeId = postypeId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getTypeAuto() {
        return typeAuto;
    }

    public void setTypeAuto(String typeAuto) {
        this.typeAuto = typeAuto;
    }

    @Override
    public String toString() {
        return "PostType{" +
                "postypeId=" + postypeId +
                ", postTitle='" + postTitle + '\'' +
                ", typeAuto='" + typeAuto + '\'' +
                '}';
    }

    public PostType(String postTitle, String typeAuto) {
        this.postTitle = postTitle;
        this.typeAuto = typeAuto;
    }

    public PostType() {

    }
}
