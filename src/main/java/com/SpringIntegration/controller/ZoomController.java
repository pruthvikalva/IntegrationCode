package com.SpringIntegration.controller;

import java.awt.PageAttributes.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.SpringIntegration.Model.ZoomIntegrationModel;
import com.SpringIntegration.service.ZoomServiceImplementation;
import com.nimbusds.jose.util.Base64;





@RestController
@RequestMapping("/oauth/zoom")
public class ZoomController {
	@Autowired
	private ZoomServiceImplementation zoomServiceImplementation;
	
	private static final String API_ENDPOINT = "https://zoom.us/oauth/token";
    private static final String CLIENT_ID = "9kG8YdzoRl3QSDpfb4QQ";
    private static final String CLIENT_SECRET = "qpspTvLXor3F6uirQFgpxSpjscx8p2Oc";
    private static final String REDIRECT_URI = "https://localhost:9090/oauth/zoom/callback";
 
	
	@GetMapping("/authorize")
	public String authorize() {
		String redirect = "https://zoom.us/oauth/authorize?"
				+ "client_id = 9kG8YdzoRl3QSDpfb4QQ" + "&response_type=code"
				+ "&redirect_uri="+REDIRECT_URI + "&response_mode=query"
				+ "&scope= meeting:master meeting:write:admin ";

		return redirect;

	}
	
	@GetMapping("/callback")
	public String callback(@RequestParam("code") String code) {
		// Set request headers
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        
        // Set request body
        String requestBody = "grant_type=authorization_code&code=" + code + "&redirect_uri=" + REDIRECT_URI;
		
        
     // Set client credentials for basic authentication
        String clientCredentials = CLIENT_ID + ":" + CLIENT_SECRET;
        Base64 encodedCredentials=Base64.encode(clientCredentials);
        headers.set("Authorization", "Basic " + encodedCredentials);
        
       
     // Create request entity with headers and body
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
        RestTemplate restTemplate = new RestTemplate();
        
        ResponseEntity<ZoomIntegrationModel> response = restTemplate.exchange(API_ENDPOINT, HttpMethod.POST, requestEntity,
				ZoomIntegrationModel.class);

		ZoomIntegrationModel zoomIntegrationModel = response.getBody();
		zoomServiceImplementation.save(zoomIntegrationModel);
		return "";
		
		
	}

}
