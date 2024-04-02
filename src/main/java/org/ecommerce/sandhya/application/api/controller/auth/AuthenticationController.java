package org.ecommerce.sandhya.application.api.controller.auth;

import jakarta.validation.Valid;
import org.ecommerce.sandhya.application.api.RegistrationBody;
import org.ecommerce.sandhya.application.exception.UserExistsException;
import org.ecommerce.sandhya.application.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private UserService userService;

    public AuthenticationController(UserService service){
        userService=service;
    }

    @PostMapping("register")
    public ResponseEntity requestUser(@Valid @RequestBody RegistrationBody registrationBody){
        try {
            userService.registerUser(registrationBody);
            return ResponseEntity.ok().build();
        } catch (UserExistsException e){
            return (ResponseEntity) ResponseEntity.status(HttpStatus.CONFLICT);
        }
    }
}
