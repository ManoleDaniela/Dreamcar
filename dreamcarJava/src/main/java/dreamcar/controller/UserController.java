package dreamcar.controller;

import dreamcar.domain.ComponentRequests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dreamcar.domain.User;
import dreamcar.domain.UserLogin;
import dreamcar.service.UserService;

import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<User> userLogin(@RequestBody UserLogin userLogin) {
        return ResponseEntity
                .ok()
                .body(userService.loginUser(userLogin.getName(), userLogin.getPassword()));
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getById(@PathVariable Long id){
        return ResponseEntity.ok().body(userService.getById(id));
    }


}
