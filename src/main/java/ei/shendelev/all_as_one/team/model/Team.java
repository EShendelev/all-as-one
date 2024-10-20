package ei.shendelev.all_as_one.team.model;

import ei.shendelev.all_as_one.user.model.User;
import lombok.Data;

import java.util.List;

@Data
public class Team {
    private Integer id;
    private String name;
    private List<User> teammateList;

}
