package com.mobile.mobileAppTest.registration;

import java.util.Objects;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mobile.mobileAppTest.appUser.AppUserRole;
import com.mobile.mobileAppTest.post.Post;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
	@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Id ;
    private String username;
    private String mobile;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    
    private Post post;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getUserName() {
		return username;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public void setUserName(String userName) {
		this.username = userName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AppUserRole getAppUserRole() {
		return appUserRole;
	}
	public void setAppUserRole(AppUserRole appUserRole) {
		this.appUserRole = appUserRole;
	}
	public RegistrationRequest(String userName, String mobile, String email, String password,Post post) {
		super();
		this.username = userName;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.post =post;
	}
	
	
	
   
}
