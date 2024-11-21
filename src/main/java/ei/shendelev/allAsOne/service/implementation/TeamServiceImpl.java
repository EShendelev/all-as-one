package ei.shendelev.allAsOne.service.implementation;

import ei.shendelev.allAsOne.dto.TeamDto;
import ei.shendelev.allAsOne.exception.NotFoundException;
import ei.shendelev.allAsOne.exception.NotUniqueException;
import ei.shendelev.allAsOne.mapper.TeamMapper;
import ei.shendelev.allAsOne.model.Team;
import ei.shendelev.allAsOne.model.User;
import ei.shendelev.allAsOne.repository.TeamRepository;
import ei.shendelev.allAsOne.repository.UserRepository;
import ei.shendelev.allAsOne.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
        if (!teamRepository.existsByName(team.getName())) {
            throw new NotUniqueException("Team with name " + team.getName() + " exists");
        }
        List<User> users = team.getUsers();
        if (!checkUsers(users)) {
            throw new NotFoundException("Users not found. Check log for more information");
        }
        addTeamToUsers(users);
        teamRepository.save(team);

        return teamDto;
    }

    private boolean checkUsers(List<User> users) {
        List<Long> wrongIds = new ArrayList<>();
        for (User user : users) {
            Long id = user.getId();
            if (!userRepository.existsById(id)) {
                log.info("User with id {} not found", id);
                wrongIds.add(id);
            }
        }
        return wrongIds.isEmpty();
    }

    private void addTeamToUsers(List<User> users) {
        userRepository.saveAll(users);
        log.info("For users {} updated team information", users);
    }
}
