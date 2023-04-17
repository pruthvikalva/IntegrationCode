package com.SpringIntegration.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringIntegration.Model.OutlookIntegration;
@Repository
public interface OutlookIntegrationRepoInterface extends JpaRepository<OutlookIntegration,Long> {

}
