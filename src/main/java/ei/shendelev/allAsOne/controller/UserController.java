package ei.shendelev.allAsOne.controller;

import ei.shendelev.allAsOne.dto.UserDto;
import ei.shendelev.allAsOne.dto.UserReceivedDto;
import ei.shendelev.allAsOne.mapper.UserMapper;
import ei.shendelev.allAsOne.service.UserService;
import ei.shendelev.allAsOne.util.validator.Validator;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/users")
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto saveUser(@RequestBody @Validated({Validator.Create.class})
                              UserReceivedDto userDto) {
        log.info("POST request to /users");
        return userService.saveUser(UserMapper.toUser(userDto));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> findUserList(@RequestParam(defaultValue = "") List<Long> ids,
                                      @RequestParam(defaultValue = "0") @PositiveOrZero int from,
                                      @RequestParam(defaultValue = "10") @Positive int size) {
        log.info("GET request to /users");
        return userService.findUsersByIdList(ids, from, size);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto findUser(@PathVariable Long id) {
        log.info("GET request to /users/id, id = {}", id);
        return userService.findUser(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable Long id) {
        log.info("DELETE request to /users/id, id = {}", id);
        userService.deleteUser(id);
    }
}
