package ei.shendelev.allAsOne.mapper;

import ei.shendelev.allAsOne.dto.TeamDto;
import ei.shendelev.allAsOne.model.Team;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TeamMapper {
    public Team toTeam(TeamDto teamDto) {
        return Team.builder()
                .id(teamDto.getId())
                .name(teamDto.getName())
                .users(teamDto.getUserDtoList().stream().map(UserMapper::toUser).toList())
                .build();
    }

    public TeamDto toTeamDto(Team team) {
        return TeamDto.builder()
                .id(team.getId())
                .name(team.getName())
                .userDtoList(team.getUsers().stream().map(UserMapper::toUserDto).toList())
                .build();
    }
}
