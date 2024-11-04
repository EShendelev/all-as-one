package ei.shendelev.allAsOne.dto;

import ei.shendelev.allAsOne.util.validator.Validator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserReceivedDto {

    @Email(groups = {Validator.Create.class})
    @Size(min = 6, max = 250, groups = {Validator.Create.class})
    @NotBlank(groups = {Validator.Create.class})
    private String email;

    @Size(min = 2, max = 100, groups = {Validator.Create.class})
    @NotBlank(groups = {Validator.Create.class})
    private String name;

    @Size(min = 2, max = 100, groups = {Validator.Create.class})
    @NotBlank(groups = {Validator.Create.class})
    private String surname;
}
