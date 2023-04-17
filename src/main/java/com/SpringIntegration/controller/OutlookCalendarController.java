package com.SpringIntegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.SpringIntegration.Model.OutlookIntegration;

import com.SpringIntegration.service.OutlookIntegrationServiceImplementation;

@RestController
@RequestMapping("/oauth/outlook")
public class OutlookCalendarController {
	@Autowired
	private OutlookIntegrationServiceImplementation outlookIntegrationServiceImplementation;

	private static final String API_ENDPOINT = "https://login.microsoftonline.com/{tenant}/oauth2/v2.0/token";
	private static final String AUTHORIZATION_URI = "https://login.microsoftonline.com/{tenant}/oauth2/v2.0/authorize?";
    private static final String CLIENT_ID = "ae0e9cc9-1037-4a6a-b708-175a68bcd082";
    private static final String CLIENT_SECRET = "7fc6f375-35b5-4e3b-9a4d-dd6b8117486b";
    private static final String REDIRECT_URI = "https://localhost:9090/oauth/outlook/callback";
	
	@GetMapping("/authorize")
	public String authorize() {
		String redirect = AUTHORIZATION_URI
				+ "client_id ="+CLIENT_ID + "&response_type=code"
				+ "&redirect_uri="+REDIRECT_URI+ "&response_mode=query"
				+ "&scope=https://graph.microsoft.com/Calendars.ReadWrite "
				+ "https://graph.microsoft.com/offline_access " 
				+ "https://graph.microsoft.com/User.Read";

		return redirect;

	}

	@GetMapping("/callback")
	public String callback(@RequestParam("code") String code) {
		
		String accessTokenUrl = API_ENDPOINT
				+ "client_id ="+CLIENT_ID + "&grant_type=authorization_code"
				+ "&redirect_uri="+REDIRECT_URI 
				+ "&scope=https://graph.microsoft.com/Calendars.ReadWrite offline_access User.Read"
				+ "https://graph.microsoft.com/offline_access " 
				+ "https://graph.microsoft.com/User.Read"
				+ "client_secret="+CLIENT_SECRET
				+"&code="+code;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<OutlookIntegration> response = restTemplate.postForEntity(accessTokenUrl, new Object(),
				OutlookIntegration.class);

		OutlookIntegration outlookIntegration = response.getBody();
		outlookIntegrationServiceImplementation.save(outlookIntegration);
		return "";

	}

}
