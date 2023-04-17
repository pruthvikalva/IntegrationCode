package com.SpringIntegration.Model;

public class WebexIntegrationModel {
	private String access_token;
	private String refresh_token;
	private int expires_in;
	private int refresh_token_expires_in;
	
	public WebexIntegrationModel() {
		super();
	}

	public WebexIntegrationModel(String access_token, String refresh_token, int expires_in,
			int refresh_token_expires_in) {
		super();
		this.access_token = access_token;
		this.refresh_token = refresh_token;
		this.expires_in = expires_in;
		this.refresh_token_expires_in = refresh_token_expires_in;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	public int getRefresh_token_expires_in() {
		return refresh_token_expires_in;
	}

	public void setRefresh_token_expires_in(int refresh_token_expires_in) {
		this.refresh_token_expires_in = refresh_token_expires_in;
	}

	@Override
	public String toString() {
		return "WebexIntegrationModel [access_token=" + access_token + ", refresh_token=" + refresh_token
				+ ", expires_in=" + expires_in + ", refresh_token_expires_in=" + refresh_token_expires_in + "]";
	}
	
}
