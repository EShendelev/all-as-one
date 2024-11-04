package ei.shendelev.allAsOne.mapper;

import ei.shendelev.allAsOne.dto.TeamDto;
import ei.shendelev.allAsOne.model.Team;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TeamMapper {

    public TeamDto toTeamDto(Team team) {
        return TeamDto.builder()
                .id(team.getId())
                .name(team.getName())
                .userList(team.getUsers().stream().map(UserMapper::toUserDtoForTeam).toList())
                .build();
    }

    public Team toTeam(TeamDto teamDto) {
        return Team.builder()
                .id(teamDto.getId())
                .name(teamDto.getName())
                .build();
    }
}
