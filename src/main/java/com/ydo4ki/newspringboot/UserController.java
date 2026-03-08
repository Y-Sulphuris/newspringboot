package com.ydo4ki.newspringboot;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final List<User> users = new ArrayList<>(List.of(
            new User(1L, "Rapier", "rapier::example.org"),
            new User(2L, "Captain Despair", "despair221::example.org")
    ));

    @GetMapping
    @Operation(summary = "Получить всех пользователей")
    public List<User> getAllUsers() {
        return users;
    }

    @PostMapping
    @Operation(summary = "Добавить нового пользователя без регистрации и смс")
    public User addUser(@RequestBody User user) {
        user.setId((long) (users.size() + 1));
        users.add(user);
        return user;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить персонально одного пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "User not found D:"),
            @ApiResponse(responseCode = "200", description = "User found :D")})
    public User getUserById(@PathVariable Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }
}
