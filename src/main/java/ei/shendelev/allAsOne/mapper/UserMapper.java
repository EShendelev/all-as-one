package ei.shendelev.allAsOne.mapper;

import ei.shendelev.allAsOne.dto.UserDto;
import ei.shendelev.allAsOne.dto.UserDtoReceived;
import ei.shendelev.allAsOne.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public UserDto toUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .build();
    }

    public static User toUser(UserDtoReceived userDto) {
        return User.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .build();
    }
}