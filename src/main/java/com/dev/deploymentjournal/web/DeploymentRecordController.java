package com.dev.deploymentjournal.web;

import com.dev.deploymentjournal.domain.DeploymentRecord;
import com.dev.deploymentjournal.service.DeploymentRecordService;
import com.dev.deploymentjournal.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/deployment-record")
@CrossOrigin
public class DeploymentRecordController {

    @Autowired
    private DeploymentRecordService deploymentRecordService;

    @Autowired
    private ValidationService vadationService;

    @RequestMapping("")
    public ResponseEntity<?> createDeploymentRecord(@Valid @RequestBody DeploymentRecord deploymentRecord, BindingResult result) {

        ResponseEntity<?> errorMapResponse = vadationService.mapValidationErrorsFromBindingResult(result);
        if (errorMapResponse != null) {

            return errorMapResponse;
        }

        deploymentRecordService.saveOrUpdate(deploymentRecord);

        return new ResponseEntity<>(deploymentRecord, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getDeploymentRecordsAll() {

        List<DeploymentRecord> records = deploymentRecordService.findAll();

        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDeploymentRecordById(@PathVariable Long id) {

        DeploymentRecord record = deploymentRecordService.findById(id);

        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDeploymentRecord(@PathVariable Long id) {

        deploymentRecordService.updateDeletedFlag(id);

        return new ResponseEntity<>("record deleted!", HttpStatus.OK);
    }

}

