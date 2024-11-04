package ei.shendelev.allAsOne.controller;

import ei.shendelev.allAsOne.dto.TeamDto;
import ei.shendelev.allAsOne.dto.UserDto;
import ei.shendelev.allAsOne.mapper.TeamMapper;
import ei.shendelev.allAsOne.model.User;
import ei.shendelev.allAsOne.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/teams")
public class TeamController {

    private final TeamService teamService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeamDto save(@RequestBody TeamDto teamDto) {
        log.info("Team controller: POST request to /teams");
        return teamService.saveTeam(TeamMapper.toTeam(teamDto));
    }
}
