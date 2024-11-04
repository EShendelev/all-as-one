package ei.shendelev.allAsOne.service;

import ei.shendelev.allAsOne.dto.UserDto;
import ei.shendelev.allAsOne.model.User;

import java.util.List;

public interface UserService {
    UserDto saveUser(User user);

    void deleteUser(Long id);

    List<UserDto> findUsersByIdList(List<Long> idList, int from, int size);

    UserDto findUser(Long id);


}
