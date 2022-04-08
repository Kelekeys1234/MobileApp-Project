package com.mobile.mobileAppTest.action;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mobile.mobileAppTest.appUser.AppUser;
import com.mobile.mobileAppTest.post.Post;
@Entity
@Table(name="action")
public class Actions {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long actionId;
	
	private Long isLike;
	
	private Long isShared;
	
	private String isCommented;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn( name = "post_id", referencedColumnName="postId")
	  private Post post;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn( name = "app_user_id", referencedColumnName="userId")
	  private AppUser appUser;

	public Actions(Long isLike, Long isShared, String isCommented, Post post, AppUser appUser) {
		super();
		this.isLike = isLike;
		this.isShared = isShared;
		this.isCommented = isCommented;
		this.post = post;
		this.appUser = appUser;
	}

	public Actions() {
		super();
	}

	public Long getActionId() {
		return actionId;
	}

	public void setActionId(Long actionId) {
		this.actionId = actionId;
	}

	public Long getIsLike() {
		return isLike;
	}

	public void setIsLike(Long isLike) {
		this.isLike = isLike;
	}

	public Long getIsShared() {
		return isShared;
	}

	public void setIsShared(Long isShared) {
		this.isShared = isShared;
	}

	public String getIsCommented() {
		return isCommented;
	}

	public void setIsCommented(String isCommented) {
		this.isCommented = isCommented;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	@Override
	public String toString() {
		return "Actions [actionId=" + actionId + ", isLike=" + isLike + ", isShared=" + isShared + ", isCommented="
				+ isCommented + ", post=" + post + ", appUser=" + appUser + "]";
	}
	 
	 

}
