package com.dev.deploymentjournal.web;

import com.dev.deploymentjournal.domain.User;
import com.dev.deploymentjournal.service.UserService;
import com.dev.deploymentjournal.service.ValidationService;
import com.dev.deploymentjournal.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private ValidationService mapValidationErrorService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody User user, BindingResult result) {
        userValidator.validate(user, result);
        ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationErrorsFromBindingResult(result);
        if (errorMap != null) {
            return errorMap;
        }
        User newUser = userService.saveUser(user);

        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);

    }

}
