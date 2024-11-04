package ei.shendelev.allAsOne.service;

import ei.shendelev.allAsOne.dto.TeamDto;
import ei.shendelev.allAsOne.model.Team;

import java.util.List;

public interface TeamService {

    TeamDto saveTeam(Team team);

    TeamDto addUserToTeam(Long userId);
}
