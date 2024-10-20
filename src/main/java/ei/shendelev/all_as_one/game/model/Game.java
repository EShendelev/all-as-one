package ei.shendelev.all_as_one.game.model;

import ei.shendelev.all_as_one.team.model.Team;
import ei.shendelev.all_as_one.user.model.User;
import lombok.Data;

import java.util.List;

@Data
public class Game {
    private Integer id;
    private User moderator;
    private Integer teamCount;
    private Integer tourCount;
    private List<Team> teamList;
}
