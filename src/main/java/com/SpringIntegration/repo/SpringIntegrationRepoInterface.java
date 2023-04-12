package com.SpringIntegration.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringIntegration.Model.OutlookIntegration;

public interface SpringIntegrationRepoInterface extends JpaRepository<OutlookIntegration,Long> {

}
