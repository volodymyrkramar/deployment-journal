package com.dev.deploymentjournal.service;

import com.dev.deploymentjournal.domain.DeploymentRecord;
import com.dev.deploymentjournal.repo.DeploymentRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeploymentRecordService {

    @Autowired
    DeploymentRecordRepository deploymentRecordRepository;

    public DeploymentRecord saveOrUpdate(DeploymentRecord deploymentRecord) {

        //update

        return deploymentRecordRepository.save(deploymentRecord);
    }

    public List<DeploymentRecord> findAll() {
        return ((List<DeploymentRecord>) deploymentRecordRepository.findAll()).stream().sorted(Comparator.comparing(DeploymentRecord :: getDeploymentDate)).collect(Collectors.toList());
    }

    public void updateDeletedFlag(Long id) {
        DeploymentRecord toUpdate = deploymentRecordRepository.findById(id).orElse(null);
        if (toUpdate != null) {
            toUpdate.setDeleted(true);
            deploymentRecordRepository.save(toUpdate);
        }
    }

    public DeploymentRecord findById(Long id) {
        return deploymentRecordRepository.findById(id).orElse(null);
    }


}
