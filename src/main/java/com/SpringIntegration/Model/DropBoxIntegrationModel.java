package com.SpringIntegration.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "Dropbox_Authorization_Values")
public class DropBoxIntegrationModel {
	
		
			/*@Id
			@GeneratedValue(strategy = GenerationType.AUTO)*/
			private String uid;
			private String access_token;
			private String refresh_token;
			private String token_type;
			private String scope;
			private int expires_in;
			private String account_id;
			public DropBoxIntegrationModel() {
				super();
			}
			public DropBoxIntegrationModel(String uid, String access_token, String refresh_token, String token_type,
					String scope, int expires_in, String account_id) {
				
				this.uid = uid;
				this.access_token = access_token;
				this.refresh_token = refresh_token;
				this.token_type = token_type;
				this.scope = scope;
				this.expires_in = expires_in;
				this.account_id = account_id;
			}
			@Override
			public String toString() {
				return "DropBoxIntegrationModel [uid=" + uid + ", access_token=" + access_token + ", refresh_token="
						+ refresh_token + ", token_type=" + token_type + ", scope=" + scope + ", expires_in="
						+ expires_in + ", account_id=" + account_id + "]";
			}
			public String getUid() {
				return uid;
			}
			public void setUid(String uid) {
				this.uid = uid;
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
			public String getToken_type() {
				return token_type;
			}
			public void setToken_type(String token_type) {
				this.token_type = token_type;
			}
			public String getScope() {
				return scope;
			}
			public void setScope(String scope) {
				this.scope = scope;
			}
			public int getExpires_in() {
				return expires_in;
			}
			public void setExpires_in(int expires_in) {
				this.expires_in = expires_in;
			}
			public String getAccount_id() {
				return account_id;
			}
			public void setAccount_id(String account_id) {
				this.account_id = account_id;
			}
			
			
}
