package ei.shendelev.allAsOne.user.service;

import ei.shendelev.allAsOne.user.dto.UserDto;
import ei.shendelev.allAsOne.user.model.User;

import java.util.List;

public interface UserService {
    UserDto createUser(User user);

    void deleteUser(Long id);

    List<User> showUsers(List<Long> idList, int from, int size);
}
