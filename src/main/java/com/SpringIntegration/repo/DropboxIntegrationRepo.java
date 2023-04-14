package com.SpringIntegration.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringIntegration.Model.DropBoxIntegrationModel;

public interface DropboxIntegrationRepo extends JpaRepository<DropBoxIntegrationModel, Integer> {

}
