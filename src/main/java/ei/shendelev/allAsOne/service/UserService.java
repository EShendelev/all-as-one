package ei.shendelev.allAsOne.service;

import ei.shendelev.allAsOne.dto.UserDto;
import ei.shendelev.allAsOne.model.User;

import java.util.List;

public interface UserService {
    UserDto createUser(User user);

    void deleteUser(Long id);

    List<UserDto> showUsers(List<Long> idList, int from, int size);

    UserDto showUser(Long id);
}
