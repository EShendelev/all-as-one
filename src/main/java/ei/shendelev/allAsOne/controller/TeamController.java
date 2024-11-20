package ei.shendelev.allAsOne.controller;

import ei.shendelev.allAsOne.dto.TeamDto;
import ei.shendelev.allAsOne.service.TeamService;
import ei.shendelev.allAsOne.util.validator.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@Validated
@RequestMapping("/teams")
public class TeamController {
    private TeamService teamService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeamDto saveTeam(
            @RequestBody @Validated({Validator.Create.class}) TeamDto teamDto) {
        log.info("POST request to /teams");
        return teamService.saveTeam(teamDto);
    }
}
