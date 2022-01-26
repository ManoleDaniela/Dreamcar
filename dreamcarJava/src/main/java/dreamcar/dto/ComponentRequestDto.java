package dreamcar.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComponentRequestDto {

    private Long idReq;
    private String componentName;
    private Integer quantity;
    private Integer targetPrice;
    private Date limitTime;
    private Long idWinner;
    private String winnerName;
    private boolean isClosed;
    private Integer minimumBid;

}