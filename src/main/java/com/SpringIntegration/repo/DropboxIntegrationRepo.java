package com.SpringIntegration.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringIntegration.Model.DropBoxIntegrationModel;
@Repository
public interface DropboxIntegrationRepo extends JpaRepository<DropBoxIntegrationModel, Integer> {

}
