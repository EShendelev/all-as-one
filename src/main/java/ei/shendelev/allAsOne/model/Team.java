package ei.shendelev.allAsOne.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "teams")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<User> users;

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userList=" + users +
                '}';
    }
}
