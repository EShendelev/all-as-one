package ei.shendelev.allAsOne.service.implementation;

import ei.shendelev.allAsOne.dto.TeamDto;
import ei.shendelev.allAsOne.exception.NotFoundException;
import ei.shendelev.allAsOne.exception.NotUniqueException;
import ei.shendelev.allAsOne.mapper.TeamMapper;
import ei.shendelev.allAsOne.model.Team;
import ei.shendelev.allAsOne.repository.TeamRepository;
import ei.shendelev.allAsOne.repository.UserRepository;
import ei.shendelev.allAsOne.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final UserRepository userRepository;

    @Transactional
    @Override
    public TeamDto saveTeam(Team team) {
        log.info("Team service: invoke create team");
        if (teamRepository.existsByName(team.getName())) {
            throw new NotUniqueException("Team with name " + team.getName() + " already exist");
        }
        TeamDto teamDto = TeamMapper.toTeamDto(teamRepository.save(team));
        log.info("Team service: Team {} created", teamDto);
        return teamDto;
    }

    @Override
    public TeamDto addUserToTeam(Long userId) {
        return null;
    }

    private Boolean checkUserIdList(List<Long> userIds) {
        boolean isChecked = true;
        for (Long i : userIds) {
            if (!userRepository.existsById(i)) {
                isChecked = false;
                log.info("User with id {} not exist", i);
                throw new NotFoundException("User id " + i + " not found");
            }
        }
        return isChecked;
    }
}
