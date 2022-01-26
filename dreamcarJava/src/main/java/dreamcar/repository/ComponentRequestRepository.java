package dreamcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import dreamcar.domain.ComponentRequests;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ComponentRequestRepository extends JpaRepository<ComponentRequests, Long> {

    @Transactional
    @Modifying
    @Query("update ComponentRequests c set c.idWinner = :idWinner WHERE c.idReq = :componentId")
    void updateWinner(Long idWinner, Long componentId);
}

