package dreamcar.repository;

import dreamcar.domain.Bid;
import dreamcar.domain.ComponentRequests;
import dreamcar.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BidRepository extends JpaRepository<Bid, Long> {

    List<Bid> findByUserId(Long userid);

    @Query(value = "SELECT b FROM Bid b WHERE b.idComponentRequest = :idComponentRequest")
    List<Bid> findAllBidsByComponent(Long idComponentRequest);

    @Query(value = "SELECT b FROM Bid b WHERE b.idComponentRequest = :idComponentRequest")
    List<Bid> findAllByComponentId(Long idComponentRequest);
}
