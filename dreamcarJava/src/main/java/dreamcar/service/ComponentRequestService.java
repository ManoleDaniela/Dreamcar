package dreamcar.service;

import dreamcar.domain.Bid;
import dreamcar.domain.ComponentRequests;
import dreamcar.dto.ComponentRequestDto;
import dreamcar.repository.ComponentRequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import dreamcar.domain.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class ComponentRequestService {

    private static final Logger log = LoggerFactory.getLogger(ComponentRequestService.class);


    @Autowired
    private ComponentRequestRepository componentRequestRepository;

    @Lazy
    @Autowired BidService bidService;

    @Autowired
    private UserService userService;

    @Autowired
    private EmailSenderService emailSenderService;

    public ComponentRequests createAuctionRequest (ComponentRequests componentRequests){
        return componentRequestRepository.save(componentRequests);
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void reportCurrentTime() {
        List<ComponentRequests> componentRequestsList = componentRequestRepository.findAll();
        for(ComponentRequests c: componentRequestsList){
            if(c.getLimitTime().before(new Date()) && c.getIdWinner() == null){
                if(bidService.findMinimumBidByComponent(c.getIdReq()) != null)
                {
                    Bid bid = bidService.findMinimumBidByComponent(c.getIdReq());
                    log.info("MinimumBidPrice " + bid.getBidPrice().toString());
                    log.info("User " + bid.getIdUser().toString());

                    componentRequestRepository.updateWinner(bid.getIdUser(), bid.getIdComponentRequest());
                    Optional<User> userWinner = userService.getById(bid.getIdUser());
                    log.info("Winner " + userWinner.get().getName());
                    if(userWinner.isPresent()){
                        emailSenderService.sendSimpleEmail(userWinner.get().getEmail(), "Congratulations! You've won the auction for the component " + c.getComponentName(),"Dreamcar auction winner announcement");
                    }
                }
            }
        }
    }

    public List<ComponentRequestDto> getAuctions (){
        List<ComponentRequests> componentRequests = componentRequestRepository.findAll();
        List<ComponentRequestDto> componentRequestDtos = new ArrayList<>();
        Date currentTime = new Date();
        for(ComponentRequests componentRequests1 : componentRequests){
            Bid minimumBid = bidService.findMinimumBidByComponent(componentRequests1.getIdReq());

            if(componentRequests1.getLimitTime().before(currentTime)){
                continue;
            }


                ComponentRequestDto componentRequestDto = ComponentRequestDto.builder()
                        .idReq(componentRequests1.getIdReq())
                        .componentName(componentRequests1.getComponentName())
                        .quantity(componentRequests1.getQuantity())
                        .targetPrice(componentRequests1.getTargetPrice())
                        .limitTime(componentRequests1.getLimitTime())
                        .idWinner(componentRequests1.getIdWinner())
                        .isClosed(componentRequests1.getIsClosed())
                        .minimumBid(minimumBid.getBidPrice())
                        .build();
             componentRequestDtos.add(componentRequestDto);

        }
        return componentRequestDtos;


    }


    public List<ComponentRequestDto> getClosedAuctions (){
        List<ComponentRequests> componentRequests = componentRequestRepository.findAll();
        List<ComponentRequestDto> componentRequestDtos = new ArrayList<>();
        Date currentTime = new Date();
        for(ComponentRequests componentRequests1 : componentRequests){
            if(componentRequests1.getLimitTime().after(currentTime) && componentRequests1.getIdWinner() == null){
                continue;
            }
            Optional<User> user = userService.getById(componentRequests1.getIdWinner());

            Bid minimumBid = bidService.findMinimumBidByComponent(componentRequests1.getIdReq());
            if(minimumBid.getBidPrice() == null){
                continue;
            }


            ComponentRequestDto componentRequestDto = ComponentRequestDto.builder()
                    .idReq(componentRequests1.getIdReq())
                    .componentName(componentRequests1.getComponentName())
                    .quantity(componentRequests1.getQuantity())
                    .targetPrice(componentRequests1.getTargetPrice())
                    .limitTime(componentRequests1.getLimitTime())
                    .idWinner(componentRequests1.getIdWinner())
                    .winnerName(user.get().getName())
                    .isClosed(componentRequests1.getIsClosed())
                    .minimumBid(minimumBid.getBidPrice())
                    .build();
            componentRequestDtos.add(componentRequestDto);

        }
        return componentRequestDtos;


    }

    public Optional<ComponentRequests> getAuction (Long id){
        return componentRequestRepository.findById(id);

    }


}
