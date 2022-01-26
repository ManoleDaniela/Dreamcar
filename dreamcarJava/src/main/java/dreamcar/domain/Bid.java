package dreamcar.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bids")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bid")
    private Long idBid;

    @Column(name = "bid_price")
    private Integer bidPrice;

    @Column(name = "id_comp_req")
    private Long idComponentRequest;

    @Column(name = "id_user")
    private Long idUser;

    @ManyToOne()
    @JoinColumn(name="id_user", referencedColumnName = "id", insertable=false, updatable = false)
    @JsonIgnore
    private User user;
}
