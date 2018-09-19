package com.mrhan.project.moduls;

import java.util.Date;

/**
 * 公告信息类
 * @author MrHanHao
 */
public class BulletinInfo {
	private int bulletId;
	private String title;//标题
	private String content;//内容
	private UserInfo userId;//用户
	private Date createTime;//创建时间
	public BulletinInfo(int bulletId, String title, String content, UserInfo user,
			Date createTime) {
		
		this.bulletId = bulletId;
		this.title = title;
		this.content = content;
		this.userId = user;
		this.createTime = createTime;
	}
	public BulletinInfo(String title, String content, UserInfo user,
			Date createTime) {
		
	
		this.title = title;
		this.content = content;
		this.userId = user;
		this.createTime = createTime;
	}
	
	public int getBulletId() {
		return bulletId;
	}
	public void setBulletId(int bulletId) {
		this.bulletId = bulletId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取发布者
	 * @return
	 */
	public UserInfo getUserInfo() {
		return userId;
	}
	/**
	 * 设置发布者
	 * @param userId
	 */
	public void setUserInfo(UserInfo user) {
		this.userId = user;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "BulletinInfo [bulletId=" + bulletId + ", title=" + title
				+ ", content=" + content + ", user=" + userId
				+ ", createTime=" + createTime + "]";
	}
	
	
}
