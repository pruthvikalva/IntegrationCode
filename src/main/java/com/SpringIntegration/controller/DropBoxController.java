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

import com.SpringIntegration.Model.DropBoxIntegrationModel;
import com.SpringIntegration.service.DropboxServiceImplementation;


@RestController
@RequestMapping("/oauth/dropbox")
public class DropBoxController {

	private static final String API_ENDPOINT = "https://api.dropboxapi.com/oauth2/token";
    private static final String CLIENT_ID = "9kG8YdzoRl3QSDpfb4QQ";
    private static final String CLIENT_SECRET = "qpspTvLXor3F6uirQFgpxSpjscx8p2Oc";
    private static final String REDIRECT_URI = "https://localhost:9090/oauth/dropbox/callback";
    @Autowired
    private DropboxServiceImplementation dropboxServiceImplementation;
	
	@GetMapping("/authorize")
	public String authorize() {
		String redirect = "//www.dropbox.com/oauth2/authorize?"
				+ "client_id ="+CLIENT_ID +"&response_type=code"
				+ "&redirect_uri="+REDIRECT_URI + "&token_access_type=offline"
				+ "&scope= account_info.read files.content.read files.content.write files.metadata.read "+
				"&prompt=consent";

		return redirect;

	}
	
	@GetMapping("/callback")
	public String callback(@RequestParam("code") String code) {
		// Set request headers
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        
        // Set request body
        String requestBody = "grant_type=authorization_code&code=" + code 
        		+ "&redirect_uri=" + REDIRECT_URI
        		+"&client_id="+CLIENT_ID;
		
        
     
       
     // Create request entity with headers and body
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody,headers);
        RestTemplate restTemplate = new RestTemplate();
        
        ResponseEntity<DropBoxIntegrationModel> response = restTemplate.exchange(API_ENDPOINT, HttpMethod.POST, requestEntity,
        		DropBoxIntegrationModel.class);

        DropBoxIntegrationModel dropboxIntegrationModel = response.getBody();
		dropboxServiceImplementation.save(dropboxIntegrationModel);
		return "";
		
		
	}

}
