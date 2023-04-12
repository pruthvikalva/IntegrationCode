package com.SpringIntegration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringIntegration.Model.OutlookIntegration;
import com.SpringIntegration.repo.SpringIntegrationRepoInterface;

@Service
public class SpringIntegrationServiceImplementation {
	@Autowired
	SpringIntegrationRepoInterface springIntegrationRepoInterace;
	
	public String save(OutlookIntegration outlookInntegration) {
		springIntegrationRepoInterace.save(outlookInntegration);
		return null;
	}
	
	

}
