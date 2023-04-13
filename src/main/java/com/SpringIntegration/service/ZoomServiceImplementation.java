package com.SpringIntegration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringIntegration.Model.ZoomIntegrationModel;
import com.SpringIntegration.repo.ZoomIntegrationRepo;

@Service
public class ZoomServiceImplementation {
@Autowired
	private ZoomIntegrationRepo zoomIntegrationRepo;
public Boolean save(ZoomIntegrationModel zoomIntegrationModel) {
	zoomIntegrationRepo.save(zoomIntegrationModel);
	return null;
	
}
}
