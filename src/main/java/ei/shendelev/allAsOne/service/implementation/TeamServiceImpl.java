package ei.shendelev.allAsOne.service.implementation;

import ei.shendelev.allAsOne.dto.TeamDto;
import ei.shendelev.allAsOne.mapper.TeamMapper;
import ei.shendelev.allAsOne.model.Team;
import ei.shendelev.allAsOne.repository.TeamRepository;
import ei.shendelev.allAsOne.repository.UserRepository;
import ei.shendelev.allAsOne.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class TeamServiceImpl implements TeamService {
    private TeamRepository teamRepository;
    private UserRepository userRepository;


    @Override
    public TeamDto saveTeam(TeamDto teamDto) {
        log.info("Team service: invoke saveTeam");
        Team team = TeamMapper.toTeam(teamDto);
        return null;
    }
}
