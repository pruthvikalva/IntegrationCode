package com.SpringIntegration.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringIntegration.Model.ZoomIntegrationModel;

@Repository
public interface ZoomIntegrationRepo extends JpaRepository<ZoomIntegrationModel, Long> {

}
