package com.projeto.ecommerce.controllers;
import java.io.IOException;
import java.util.List;

import com.projeto.ecommerce.DTOs.response.UserResponseDTO;
import com.projeto.ecommerce.entities.UserService;
import com.projeto.ecommerce.services.PhotoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final PhotoService photoService;

    public UserController(UserService userService, PhotoService photoService) {
        this.userService = userService;
        this.photoService = photoService;
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestParam String name, @RequestParam String email, @RequestParam MultipartFile photo) throws IOException {

        String pathPhoto = photoService.savePhoto(photo);
        return ResponseEntity.ok(userService.saveUser(name, email, pathPhoto));

    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> listAllUsers() {
        return ResponseEntity.ok(userService.listAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> listUserById(@PathVariable Long userId) {
        try {
            return ResponseEntity.ok(userService.listUserById(userId));
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(
            @RequestBody @Valid UserRequestDTO userRequestDTO) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.createUser(userRequestDTO));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long userId,
                                                      @RequestBody @Valid UserRequestDTO userRequestDTO) {

        try {
            return ResponseEntity.ok()
                    .body(userService.updateUser(userId, userRequestDTO));
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        if (userService.deleteUser(userId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.internalServerError().build();
    }

}