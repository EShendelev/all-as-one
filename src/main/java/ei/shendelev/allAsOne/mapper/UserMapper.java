package ei.shendelev.allAsOne.mapper;

import ei.shendelev.allAsOne.dto.TeamDto;
import ei.shendelev.allAsOne.dto.UserDto;
import ei.shendelev.allAsOne.dto.UserReceivedDto;
import ei.shendelev.allAsOne.model.Team;
import ei.shendelev.allAsOne.model.User;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class UserMapper {

    public UserDto toUserDto(User user) {
        UserDto userDto = UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .build();
        if (user.getTeam() == null) {
            TeamDto teamDto = new TeamDto(0L, "No team", new ArrayList<>());
                userDto.setTeamDto(teamDto);
        } else {
            userDto.setTeamDto(TeamMapper.toTeamDto(user.getTeam()));
        }

        return userDto;
    }

    public User toUser(UserDto userDto) {
        User user = User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .build();
        if (userDto.getTeamDto() == null) {
            Team team = new Team(0L, "No team", new ArrayList<>());
            user.setTeam(team);
        } else {
            user.setTeam(TeamMapper.toTeam(userDto.getTeamDto()));
        }
        return user;
    }

    public User toUser(UserReceivedDto userDto) {
        return User.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .build();
    }
}
