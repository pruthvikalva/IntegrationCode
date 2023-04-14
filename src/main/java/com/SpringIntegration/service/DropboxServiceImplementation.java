package com.SpringIntegration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringIntegration.Model.DropBoxIntegrationModel;
import com.SpringIntegration.repo.DropboxIntegrationRepo;


@Service
public class DropboxServiceImplementation {
	@Autowired
	private DropboxIntegrationRepo dropboxIntegrationRepo ;
	
	public Boolean save(DropBoxIntegrationModel dropboxIntegrationModel) {
		dropboxIntegrationRepo.save(dropboxIntegrationModel);
		return null;
	
	}
	
}
