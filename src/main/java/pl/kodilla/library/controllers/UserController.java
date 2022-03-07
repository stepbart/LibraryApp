package pl.kodilla.library.controllers;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.UserDatabase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kodilla.library.domain.User;
import pl.kodilla.library.dto.UserDto;
import pl.kodilla.library.mappers.UserMapper;
import pl.kodilla.library.services.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1.0/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        User user = userMapper.mapUserDtoToUser(userDto);
        User savedUser = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.mapUserDtoToUser(savedUser));
    }
}
