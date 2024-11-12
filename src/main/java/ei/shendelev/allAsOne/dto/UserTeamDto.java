package ei.shendelev.allAsOne.dto;

import ei.shendelev.allAsOne.model.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserTeamDto {
    private Long id;
    private String name;
    private String surname;
    private Team team;
    private String email;
}
