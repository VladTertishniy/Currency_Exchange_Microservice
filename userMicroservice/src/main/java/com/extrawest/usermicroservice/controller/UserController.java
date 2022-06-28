package com.extrawest.usermicroservice.controller;

import com.extrawest.usermicroservice.dto.request.UserRequestDTO;
import com.extrawest.usermicroservice.dto.response.UserResponseDTO;
import com.extrawest.usermicroservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final Environment environment;

    @PostMapping("/createUser")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserRequestDTO userRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.createUser(userRequestDTO));
    }

    @PostMapping("/updateUser/{id}")
    public ResponseEntity<UserResponseDTO> updateUser (@PathVariable Long id, @RequestBody @Valid UserRequestDTO userRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(id, userRequestDTO));
    }

    @GetMapping("/deleteUser/{id}")
    public void deleteUser (@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<UserResponseDTO> getUserById (@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers () {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @GetMapping("/getPort")
    public ResponseEntity<String> getPortNumber() {
        return ResponseEntity.status(HttpStatus.OK).body(environment.getProperty("local.server.port"));
    }
}
