package ei.shendelev.all_as_one.user.mapper;

import ei.shendelev.all_as_one.user.dto.UserDto;
import ei.shendelev.all_as_one.user.dto.UserDtoReceived;
import ei.shendelev.all_as_one.user.model.User;
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
