package ei.shendelev.allAsOne.mapper;

import ei.shendelev.allAsOne.dto.UserDto;
import ei.shendelev.allAsOne.dto.UserReceivedDto;
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

    public User toUser(UserReceivedDto userDto) {
        return User.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .build();
    }

    public User toUser(UserTeamDto userTeamDto) {
        return User.builder()
                .id(userTeamDto.getId())
                .name(userTeamDto.getName())
                .surname(userTeamDto.getSurname())
                .email(userTeamDto.getEmail())
                .team(userTeamDto.getTeam())
                .build();
    }

    public UserTeamDto toUserTeamDto(User user) {
        return UserTeamDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .team(user.getTeam())
                .build();
    }
}
