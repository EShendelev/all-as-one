package ei.shendelev.all_as_one.user.service;

import ei.shendelev.all_as_one.user.dto.UserDto;
import ei.shendelev.all_as_one.user.model.User;

import java.util.List;

public interface UserService {
    UserDto createUser(User user);

    void deleteUser(Long id);

    List<User> showUsers(List<Long> idList, int from, int size);
}
