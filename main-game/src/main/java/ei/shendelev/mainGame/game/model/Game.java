package ei.shendelev.mainGame.game.model;

import ei.shendelev.mainGame.team.model.Team;
import ei.shendelev.mainGame.user.model.User;
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
