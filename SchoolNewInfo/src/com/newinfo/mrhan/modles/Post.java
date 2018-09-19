package com.newinfo.mrhan.modles;

import com.mrhan.database.allrounddaos.ColumentType;
import com.mrhan.database.allrounddaos.DaoColument;
import com.mrhan.database.allrounddaos.DaoTable;

@DaoTable(table = "post",entityClass = PostType.class)
public class Post {
    @DaoColument(col = "postid",isGrowth = true,colType = ColumentType.PIRMARYKEY)
    private int postId;//帖子编号
    @DaoColument(col = "postTitle")
    private String postTitle;//帖子
    @DaoColument(col = "postContent")
    private String postContent;//帖子内容
    @DaoColument(col = "posttypeid",colType = ColumentType.FORGINKEY,forginClass = PostType.class,forginKey = "posttypeId")
    private PostType type;//帖子编号

    public Post(String postTitle, String postContent, PostType type) {
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.type = type;
    }

    public Post() {
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", postContent='" + postContent + '\'' +
                ", type=" + type +
                '}';
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public PostType getType() {
        return type;
    }

    public void setType(PostType type) {
        this.type = type;
    }

    public Post(int postId, String postTitle, String postContent, PostType type) {

        this.postId = postId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.type = type;
    }
}
