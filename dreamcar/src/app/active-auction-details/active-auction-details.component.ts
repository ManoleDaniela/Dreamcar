import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Bid } from '../models/bid';
import { ComponentRequests } from '../models/componentRequests';
import { User } from '../models/user';
import { RequestsServiceService } from '../service/requests-service.service';

@Component({
  selector: 'app-active-auction-details',
  templateUrl: './active-auction-details.component.html',
  styleUrls: ['./active-auction-details.component.css']
})
export class ActiveAuctionDetailsComponent implements OnInit {
  message = '';

  constructor(private route: ActivatedRoute, private requestService: RequestsServiceService) { }

  public componentId: number;
  public component = new ComponentRequests();
  public bids: Bid[] = [];
  price: number;
  user = new User();
  bidUser = new User();
  ngOnInit(): void {
    this.user = JSON.parse(sessionStorage.getItem('activeUser'));
    this.componentId = +this.route.snapshot.paramMap.get('id');
    this.requestService.getAuctionDetails(this.componentId).subscribe((componentRequest: ComponentRequests) => {
      this.component = componentRequest;
    });

    this.getAllBids();


  }

  getAllBids() {
    this.requestService.getBidsWithUsername(this.componentId).subscribe((data: Bid[]) => {
      this.bids = data;
      this.bids.sort((a, b) => {
        return a.bidPrice - b.bidPrice;
      })
      console.log(this.bids)
    });
  }

  placeBid() {

    if (this.price >= this.bids[0].bidPrice) {
      this.message = 'The bid price should be lower than the minimum bid '
      setTimeout(() => {
        this.message = ''
      }, 3000)
    }
    else{

      const component: Bid = {
        idBid: 0,
        idUser: this.user.id,
        bidPrice: this.price,
        idComponentRequest: this.componentId
  
      }
      console.log(component)
  
      this.requestService.placeBid(component).subscribe((bid: Bid) => {
        console.log(bid);
  
        if (bid) {
          this.message = 'The bid was placed succesfuly!'
          this.getAllBids();
          setTimeout(() => {
            this.message = ''
          }, 3000)
        }
      });
    }


  }


}
