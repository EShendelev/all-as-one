package ei.shendelev.allAsOne.user.repository;

import ei.shendelev.allAsOne.user.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u " +
            "FROM User u " +
            "WHERE u.id IN ?1")
    List<User> findAllByIds(List<Long> ids, Pageable pageable);

    @Query("SELECT u " +
            "FROM User u")
    List<User> findAllUser(Pageable pageable);

    Boolean existsByEmail(String email);
}
