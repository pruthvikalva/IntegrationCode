package com.SpringIntegration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringIntegration.Model.OutlookIntegration;
import com.SpringIntegration.repo.OutlookIntegrationRepoInterface;

@Service
public class OutlookIntegrationServiceImplementation {
	
	@Autowired
	private OutlookIntegrationRepoInterface outlookIntegrationRepoInterface;
	
	public String save(OutlookIntegration outlookInntegration) {
		outlookIntegrationRepoInterface.save(outlookInntegration);
		return null;
	}
	
	

}
