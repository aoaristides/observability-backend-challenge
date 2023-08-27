package br.com.makersweb.picpay.simplified.application.adapters.controllers;

import br.com.makersweb.picpay.simplified.domain.adapters.services.converter.UserApiConverter;
import br.com.makersweb.picpay.simplified.domain.dto.UserDTO;
import br.com.makersweb.picpay.simplified.domain.ports.interfaces.UserServicePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author aaristides
 */
@RestController
@RequestMapping("/users")
@Slf4j
@AllArgsConstructor
public class UserController {

    private final UserServicePort userServicePort;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDTO request) {
        final var user = this.userServicePort.createUser(UserApiConverter.toCreateCommand(request));
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        var users = this.userServicePort.findUsers();
        return ResponseEntity.ok(users);
    }

}
