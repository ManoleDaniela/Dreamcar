package dreamcar.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BidDto {

    private Long idBid;
    private Integer bidPrice;
    private Long idComponentRequest;
    private Long idUser;
    private String bidUsername;
    private String componentName;

}
