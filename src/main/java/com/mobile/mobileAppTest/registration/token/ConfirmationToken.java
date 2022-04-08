package com.mobile.mobileAppTest.registration.token;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mobile.mobileAppTest.appUser.AppUser;

import lombok.AllArgsConstructor;
@Entity
@Table(name="token_tab")
@AllArgsConstructor
public class ConfirmationToken {
	@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	@Column(nullable=false)
	private String token;
	@Column(nullable=false)
	private LocalDateTime  createdAt;
	@Column(nullable=false)
	private LocalDateTime  expiredAt;
	

    private LocalDateTime confirmedAt;
	@ManyToOne
	@JoinColumn(nullable=false , name = "app_user_id")
	private AppUser appuser;
	public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiredAt, AppUser appuser) {
		super();
		this.token = token;
		this.createdAt = createdAt;
		this.expiredAt = expiredAt;
		this.appuser = appuser;
	}
	
	

	public ConfirmationToken() {
		super();
	}



	public Long getId() {
		return Id;
	}
	
	
	public void setId(Long id) {
		Id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getExpiredAt() {
		return expiredAt;
	}
	public void setExpiredAt(LocalDateTime expiredAt) {
		this.expiredAt = expiredAt;
	}
	public LocalDateTime getConfirmedAt() {
		return confirmedAt;
	}
	public void setConfirmedAt(LocalDateTime confirmedAt) {
		this.confirmedAt = confirmedAt;
	}
	public AppUser getAppuser() {
		return appuser;
	}
	public void setAppuser(AppUser appuser) {
		this.appuser = appuser;
	}
	public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiredAt, LocalDateTime confirmedAt,
			AppUser appuser) {
		super();
		this.token = token;
		this.createdAt = createdAt;
		this.expiredAt = expiredAt;
		this.confirmedAt = confirmedAt;
		this.appuser = appuser;
	}
	
}
