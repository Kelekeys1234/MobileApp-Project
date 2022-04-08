package com.mobile.mobileAppTest.post;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mobile.mobileAppTest.appUser.AppUser;

import lombok.NonNull;
@Entity
@Table(name="postApp")
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long postId;
	
	private String postUrl;
	
	private LocalDateTime createdDate;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn( name = "app_user_id", referencedColumnName="userId")
	  private AppUser appUser;
	 

	public Post( String postUrl, LocalDateTime createdDate, AppUser appUser) {
		super();
		
		this.postUrl = postUrl;
		this.createdDate = createdDate;
		this.appUser = appUser;
	}

	public Post() {
		super();
	}
	

	public AppUser getUser() {
		return appUser;
	}

	public void setUser(AppUser user) {
		this.appUser = user;
	}

	



	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public String getPostUrl() {
		return postUrl;
	}

	public void setPostUrl(String postUrl) {
		this.postUrl = postUrl;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
