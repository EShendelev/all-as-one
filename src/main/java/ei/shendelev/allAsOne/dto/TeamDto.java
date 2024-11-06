package ei.shendelev.allAsOne.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank(message = "Not have user in team")
    private List<UserDto> userList;
}
