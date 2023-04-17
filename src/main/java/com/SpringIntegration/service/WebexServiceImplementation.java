package com.SpringIntegration.service;

import org.springframework.stereotype.Service;


import com.SpringIntegration.Model.WebexIntegrationModel;
import com.SpringIntegration.repo.WebexIntegrationRepo;

@Service
public class WebexServiceImplementation {
	
	private WebexIntegrationRepo webexIntegrationRepo;
	
	public Boolean save(WebexIntegrationModel webexIntegrationModel) {
		webexIntegrationRepo.save(webexIntegrationModel);
		return null;
	
	}
}
