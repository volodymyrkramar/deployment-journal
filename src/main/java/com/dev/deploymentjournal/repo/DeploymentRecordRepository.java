package com.dev.deploymentjournal.repo;

import com.dev.deploymentjournal.domain.DeploymentRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeploymentRecordRepository extends CrudRepository<DeploymentRecord, Long> {

    List<DeploymentRecord> findAllByProject(String projectName);

}
