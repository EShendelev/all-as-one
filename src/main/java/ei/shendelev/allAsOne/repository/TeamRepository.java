package ei.shendelev.allAsOne.repository;

import ei.shendelev.allAsOne.model.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query("SELECT t " +
            "FROM Team t " +
            "WHERE t.id IN (?1)")
    List<Team> findAllByIds(List<Long> ids, Pageable pageable);


    @Query("SELECT t " +
            "FROM Team t")
    List<Team> findAllTeam(Pageable pageable);

    Boolean existsByName(String name);


}
