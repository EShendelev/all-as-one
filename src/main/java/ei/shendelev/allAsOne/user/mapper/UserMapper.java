package ei.shendelev.allAsOne.user.mapper;

import ei.shendelev.allAsOne.user.dto.UserDto;
import ei.shendelev.allAsOne.user.dto.UserDtoReceived;
import ei.shendelev.allAsOne.user.model.User;
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
                .id(userDto.getId())
                .email(userDto.getEmail())
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .build();
    }
}
