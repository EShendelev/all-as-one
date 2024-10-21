package ei.shendelev.all_as_one.user.model;

import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    private Long id;
    private String name;
    private String surname;
    @Email(message = "Email must have the form: example@example.domen")
    private String email;
    private Double winrate;
}
