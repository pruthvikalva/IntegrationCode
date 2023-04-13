package com.SpringIntegration.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringIntegration.Model.ZoomIntegrationModel;

public interface ZoomIntegrationRepo extends JpaRepository<ZoomIntegrationModel, Long> {

}
