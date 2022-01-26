package dreamcar.controller;

import dreamcar.domain.Bid;
import dreamcar.domain.ComponentRequests;
import dreamcar.dto.BidDto;
import dreamcar.service.BidService;
import dreamcar.service.ComponentRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bids")
public class BidController {

    @Autowired
    private BidService bidService;

    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<Bid> createBid(@RequestBody Bid bid) {
        return ResponseEntity
                .ok()
                .body(bidService.placeBid(bid));
    }

    @CrossOrigin
    @GetMapping("/getAll/{componentId}")
    public ResponseEntity<List<Bid>> getAll(@PathVariable Long componentId){
        return ResponseEntity.ok().body(bidService.getBids(componentId));
    }

    @CrossOrigin
    @GetMapping("/getWithUsername/{componentId}")
    public ResponseEntity<List<BidDto>> getWithUsername(@PathVariable Long componentId){
        return ResponseEntity.ok().body(bidService.getBidsWithUsername(componentId));
    }


    @CrossOrigin
    @GetMapping("/getByUserId/{userId}")
    public ResponseEntity<List<BidDto>> getByUserId(@PathVariable Long userId){
        return ResponseEntity.ok().body(bidService.getBidsByUserId(userId));
    }
//    @CrossOrigin
//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<ComponentRequests>> getById(@PathVariable Long id){
//        return ResponseEntity.ok().body(componentRequestService.getAuction(id));
//    }
}
