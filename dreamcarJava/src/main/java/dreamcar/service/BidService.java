package dreamcar.service;

import dreamcar.domain.Bid;
import dreamcar.domain.ComponentRequests;
import dreamcar.domain.User;
import dreamcar.dto.BidDto;
import dreamcar.dto.ComponentRequestDto;
import dreamcar.repository.BidRepository;
import dreamcar.repository.ComponentRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BidService {

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ComponentRequestService componentRequestService;

    public Bid placeBid (Bid bid){
        return bidRepository.save(bid);
    }

    public List<Bid> getBids (Long componentId){
        return bidRepository.findAllByComponentId(componentId);
    }

    public List<BidDto> getBidsWithUsername (Long componentId){
        List<Bid> bids = bidRepository.findAllByComponentId(componentId);
        List<BidDto> bidDtos = new ArrayList<>();
                for(Bid bid : bids){
                    Optional<User> user = userService.getById(bid.getIdUser());
                    Optional<ComponentRequests> componentRequests =componentRequestService.getAuction(bid.getIdComponentRequest());
                    if(user.isPresent() || componentRequests.isPresent()){
                        BidDto bidDto = BidDto.builder()
                                .idBid(bid.getIdBid())
                                .bidUsername(user.get().getName())

                                .idUser(bid.getIdUser())
                                .bidPrice(bid.getBidPrice())
                                .idComponentRequest(bid.getIdComponentRequest())
                                .componentName(componentRequests.get().getComponentName())
                        .build();
                bidDtos.add(bidDto);
            }
        }
        return bidDtos;
    }

    public List<BidDto> getBidsByUserId(Long userId){
        List<Bid> bids = bidRepository.findByUserId(userId);
        List<BidDto> bidDtos = new ArrayList<>();
        for(Bid bid : bids){
            Optional<User> user = userService.getById(bid.getIdUser());
            Optional<ComponentRequests> componentRequests =componentRequestService.getAuction(bid.getIdComponentRequest());
            if(user.isPresent() || componentRequests.isPresent()){
                BidDto bidDto = BidDto.builder()
                        .idBid(bid.getIdBid())
                        .bidUsername(user.get().getName())
                        .idUser(bid.getIdUser())
                        .bidPrice(bid.getBidPrice())
                        .idComponentRequest(bid.getIdComponentRequest())
                        .componentName(componentRequests.get().getComponentName())
                        .build();
                bidDtos.add(bidDto);
            }
        }
        return bidDtos;
    }
    //public Optional<ComponentRequests> getAuction (Long id){return componentRequestRepository.findById(id);}
    public List<Bid> getAllBidsByComponent(Long idReq){
        return bidRepository.findAllByComponentId(idReq);
    }

    public Bid findMinimumBidByComponent(Long idReq){
        List<Bid> bids = getAllBidsByComponent(idReq);

        if(bids.size() > 0){
            Collections.sort(bids, Comparator.comparingInt(Bid::getBidPrice));
            Bid minimumBid = bids.get(0);
            return minimumBid;
        }
        else {
            return new Bid();
        }

    }
}