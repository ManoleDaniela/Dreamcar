package dreamcar.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "component_requests")
public class ComponentRequests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_req")
    private Long idReq;

    @Column(name = "component_name")
    private String componentName;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "target_price")
    private Integer targetPrice;

    @Column(name = "limit_time")
    private Date limitTime;

    @Column(name = "id_winner")
    private Long idWinner;

    @Column(name = "is_closed")
    private Boolean isClosed;
}
