package com.newinfo.mrhan.modles;

import com.mrhan.database.allrounddaos.ColumentType;
import com.mrhan.database.allrounddaos.DaoColument;
import com.mrhan.database.allrounddaos.DaoTable;

@DaoTable(table = "post_key",entityClass = PostKey.class)
public class PostKey {
    @DaoColument(col="id",isGrowth = true,colType = ColumentType.PIRMARYKEY)
    private int id;//关联编号
    @DaoColument(col = "keyid",colType = ColumentType.FORGINKEY,forginClass = KeyWord.class,forginKey = "keyid")
    private KeyWord keyWord;//关键字对象
    @DaoColument(col = "postid",colType = ColumentType.FORGINKEY,forginClass = Post.class,forginKey = "postid")
    private Post post;//帖子对象


    public PostKey(int id, KeyWord keyWord, Post post) {
        this.id = id;
        this.keyWord = keyWord;
        this.post = post;
    }
    public PostKey( KeyWord keyWord, Post post) {
        this.id = id;
        this.keyWord = keyWord;
        this.post = post;
    }
    public PostKey(){}
    public int getId() {
        return id;
    }

    public KeyWord getKeyWord() {
        return keyWord;
    }

    public Post getPost() {
        return post;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKeyWord(KeyWord keyWord) {
        this.keyWord = keyWord;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "PostKey{" +
                "id=" + id +
                ", keyWord=" + keyWord +
                ", post=" + post +
                '}';
    }
}
