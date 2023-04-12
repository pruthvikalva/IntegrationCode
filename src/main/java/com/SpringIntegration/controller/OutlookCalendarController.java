package com.SpringIntegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.SpringIntegration.Model.OutlookIntegration;

import com.SpringIntegration.service.SpringIntegrationServiceImplementation;

@RestController
@RequestMapping("/oauth/outlook")
public class OutlookCalendarController {
	@Autowired
	private SpringIntegrationServiceImplementation springIntegrationServiceImplementation;

	@GetMapping("/authorize")
	public String authorize() {
		String redirect = "https://login.microsoftonline.com/{tenant}/oauth2/v2.0/authorize?"
				+ "client_id = ae0e9cc9-1037-4a6a-b708-175a68bcd082" + "&response_type=code"
				+ "&redirect_uri=https://localhost:9090/oauth/callback" + "&response_mode=query"
				+ "&scope=https://graph.microsoft.com/Calendars.ReadWrite "
				+ "https://graph.microsoft.com/offline_access " + "https://graph.microsoft.com/User.Read";

		return redirect;

	}

	@GetMapping("/callback")
	public String callback(@RequestParam("code") String code) {
		
		String accessTokenUrl = "https://login.microsoftonline.com/{tenant}/oauth2/v2.0/token"
				+ "client_id = ae0e9cc9-1037-4a6a-b708-175a68bcd082" + "&grant_type=authorization_code"
				+ "&redirect_uri=https://localhost:9090/oauth/callback" + "&response_mode=query"
				+ "&scope=https://graph.microsoft.com/Calendars.ReadWrite "
				+ "https://graph.microsoft.com/offline_access " + "https://graph.microsoft.com/User.Read"
				+ "client_secret=7fc6f375-35b5-4e3b-9a4d-dd6b8117486b";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<OutlookIntegration> response = restTemplate.postForEntity(accessTokenUrl, new Object(),
				OutlookIntegration.class);

		OutlookIntegration outlookIntegration = response.getBody();
		springIntegrationServiceImplementation.save(outlookIntegration);
		return "";

	}

}
