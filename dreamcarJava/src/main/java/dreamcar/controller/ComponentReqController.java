package dreamcar.controller;

import dreamcar.domain.ComponentRequests;
import dreamcar.domain.User;
import dreamcar.domain.UserLogin;
import dreamcar.dto.ComponentRequestDto;
import dreamcar.service.ComponentRequestService;
import dreamcar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/components")
public class ComponentReqController {

    @Autowired
    private ComponentRequestService componentRequestService;

    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<ComponentRequests> createComponentRequest(@RequestBody ComponentRequests componentRequests) {
        return ResponseEntity
                .ok()
                .body(componentRequestService.createAuctionRequest(componentRequests));
    }

    @CrossOrigin
    @GetMapping("/getAll")
    public ResponseEntity<List<ComponentRequestDto>> getAll(){
        return ResponseEntity.ok().body(componentRequestService.getAuctions());
    }

    @CrossOrigin
    @GetMapping("/getAllClosed")
    public ResponseEntity<List<ComponentRequestDto>> getAllClosed(){
        return ResponseEntity.ok().body(componentRequestService.getClosedAuctions());
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ComponentRequests>> getById(@PathVariable Long id){
        return ResponseEntity.ok().body(componentRequestService.getAuction(id));
    }
}
