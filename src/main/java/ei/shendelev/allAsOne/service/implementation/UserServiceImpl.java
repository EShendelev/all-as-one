package ei.shendelev.allAsOne.service.implementation;

import ei.shendelev.allAsOne.exception.NotFoundException;
import ei.shendelev.allAsOne.exception.NotUniqueException;
import ei.shendelev.allAsOne.dto.UserDto;
import ei.shendelev.allAsOne.mapper.UserMapper;
import ei.shendelev.allAsOne.model.User;
import ei.shendelev.allAsOne.repository.UserRepository;
import ei.shendelev.allAsOne.service.UserService;
import ei.shendelev.allAsOne.util.Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Transactional
    @Override
    public UserDto createUser(User user) {
        log.info("User service: invoke create user");

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new NotUniqueException("User with email " + user.getEmail() + " already exist");
        }
        UserDto userDto = UserMapper.toUserDto(userRepository.save(user));
        log.info("User service: User create: {}", userDto);
        return userDto;
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        log.info("User service: invoke delete user");
        if(!userRepository.existsById(id)) {
            log.error("User with id {} not exist", id);
            throw new NotFoundException("User id " + id + " not found");
        }
        log.info("User service: User id {} deleted", id);
        userRepository.deleteById(id);
    }

    @Override
    public List<User> showUsers(List<Long> idList, int from, int size) {
        log.info("User service: invoke show users");
        Pageable pageable = Util.createPageRequestAsc(from, size);
        if (idList.isEmpty()) {
            List<User> allUsers = userRepository.findAllUser(pageable);
            log.info("User service: idList is empty, return all users, size = {}", allUsers.size());
            return allUsers;
        }
        List<User> users = userRepository.findAllByIds(idList, pageable);
        if(users.isEmpty()) {
            return List.of();
        }
        log.info("User service: show list of users, size = {}", users.size());
        return users;
    }

    @Override
    public UserDto showUser(Long id) {
        log.info("User service: invoke show user by id");
        if(!userRepository.existsById(id)) {
            log.error("User with id {} not exist", id);
            throw new NotFoundException("User id " + id + " not found");
        }
        log.info("User id {} showed", id);
        UserDto userDto = UserMapper.toUserDto(userRepository.getById(id));
        return userDto;
    }
}