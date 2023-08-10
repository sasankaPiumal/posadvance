package com.sasstack.posadvance.api;

import com.sasstack.posadvance.dto.request.RequestUserDto;
import com.sasstack.posadvance.service.UserService;
import com.sasstack.posadvance.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/register",params = "role")
    public ResponseEntity<StandardResponse> createUser(@RequestBody RequestUserDto requestUserDto,
                                                       @RequestParam String role) {
        userService.createUser(requestUserDto, role);
        return new ResponseEntity<>(
                new StandardResponse(201, "Customer saved",
                        null),
                HttpStatus.CREATED

        );

    }


}
