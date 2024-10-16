package ei.shendelev.mainGame.team.model;

import ei.shendelev.mainGame.user.model.User;
import lombok.Data;

import java.util.List;

@Data
public class Team {
    private Integer id;
    private String name;
    private List<User> teammateList;

}
