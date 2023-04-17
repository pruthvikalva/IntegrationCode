package com.SpringIntegration.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringIntegration.Model.WebexIntegrationModel;

@Repository
public interface WebexIntegrationRepo extends JpaRepository<WebexIntegrationModel, Long> {

}
