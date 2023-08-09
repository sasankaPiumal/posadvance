package com.sasstack.posadvance.api;

import com.sasstack.posadvance.dto.request.RequestUserDto;
import com.sasstack.posadvance.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService userService;

    @PostMapping(params = "role")
    public ResponseEntity<StackOverflowError> createUser(@RequestBody RequestUserDto requestUserDto,
                                                         @RequestParam String role) {
userService.createUser(requestUserDto,role);

    }


}
