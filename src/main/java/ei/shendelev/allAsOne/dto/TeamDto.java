package ei.shendelev.allAsOne.dto;

import ei.shendelev.allAsOne.util.validator.Validator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamDto {
    private Long id;

    @Size(min = 6, max = 250, groups = {Validator.Create.class})
    @NotBlank(groups = {Validator.Create.class})
    private String name;
    @NotBlank(groups = {Validator.Create.class})
    private List<UserDto> userDtoList;
}
