package ei.shendelev.all_as_one.user.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    @Email(message = "Email must have the form: example@example.domen")
    private String email;

    @Column(name = "games_count")
    private Integer gamesCount;

    @Column(name = "winrate")
    private Double winrate;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", gamesCount=" + gamesCount +
                ", winrate=" + winrate +
                '}';
    }
}
