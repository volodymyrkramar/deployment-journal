package com.dev.deploymentjournal.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

@Service
public class ValidationService {

    public ResponseEntity<?> mapValidationErrorsFromBindingResult(BindingResult result) {
        if (result.hasErrors()) {

            var errorMap = new HashMap<String, String>();

            result.getFieldErrors().forEach(error -> {
                error.getField();
                error.getDefaultMessage();
                errorMap.put(error.getField(),
                        error.getDefaultMessage()
                );
            });

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
