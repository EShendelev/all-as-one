package ei.shendelev.allAsOne.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDtoForTeam {
    private Long id;
    private String name;
    private String surname;
}
