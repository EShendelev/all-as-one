package ei.shendelev.allAsOne.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeamUserListDto {
    private Long id;
    private String name;
    private List<UserTeamDto> userList;
}
