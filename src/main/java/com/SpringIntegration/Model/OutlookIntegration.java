package com.SpringIntegration.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Outlook_Authorization_Table")
public class OutlookIntegration {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	private String accessToken;
	private String refreshToken;
	private int expiryTime;

	public OutlookIntegration() {
		super();
	}

	public OutlookIntegration(String accessToken, String refreshToken, int expiryTime) {

		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.expiryTime = expiryTime;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public int getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(int expiryTime) {
		this.expiryTime = expiryTime;
	}

	@Override
	public String toString() {
		return "OutlookIntegration [userId=" + userId + ", accessToken=" + accessToken + ", refreshToken="
				+ refreshToken + ", expiryTime=" + expiryTime + "]";
	}

}
