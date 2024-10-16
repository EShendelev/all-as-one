package ei.shendelev.mainGame.user.model;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String surname;
    @Email(message = "Email must have the form: example@example.domen")
    private String email;
    private Double winrate;
}
