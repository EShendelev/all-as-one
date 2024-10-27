package ei.shendelev.allAsOne.controller;

import ei.shendelev.allAsOne.dto.UserDto;
import ei.shendelev.allAsOne.dto.UserDtoReceived;
import ei.shendelev.allAsOne.mapper.UserMapper;
import ei.shendelev.allAsOne.model.User;
import ei.shendelev.allAsOne.service.UserService;
import ei.shendelev.allAsOne.util.validator.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/users")
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserDto> createUser(@RequestBody @Validated({Validator.Create.class})
                                              UserDtoReceived userDto) {
        log.info("POST request to /users");
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(UserMapper.toUser(userDto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> showUser(@PathVariable Long id) {
        log.info("GET request to /users/id, id = {}", id);
        UserDto user = UserMapper.toUser(userService.showUser(id));
        return ResponseEntity.ok(user);
    }
}
