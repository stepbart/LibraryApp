package pl.kodilla.library.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kodilla.library.domain.User;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody User user){
        System.out.println("User added");
        return new ResponseEntity(user, HttpStatus.OK);
    }
}
