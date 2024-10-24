package ei.shendelev.all_as_one.user.controller;

import ei.shendelev.all_as_one.user.dto.UserDto;
import ei.shendelev.all_as_one.user.dto.UserDtoReceived;
import ei.shendelev.all_as_one.user.mapper.UserMapper;
import ei.shendelev.all_as_one.user.model.User;
import ei.shendelev.all_as_one.user.service.UserService;
import ei.shendelev.all_as_one.util.validator.Validator;
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
}
