import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Bid } from '../models/bid';
import { ComponentRequests } from '../models/componentRequests';
import { User } from '../models/user';
import { RequestsServiceService } from '../service/requests-service.service';

@Component({
  selector: 'app-my-auctions',
  templateUrl: './my-auctions.component.html',
  styleUrls: ['./my-auctions.component.css']
})
export class MyAuctionsComponent implements OnInit {

  constructor(private route: ActivatedRoute, private requestService: RequestsServiceService) { }

  public componentId: number;
  public component = new ComponentRequests();
  public bids: Bid[] = [];
  price: number;
  user = new User();
  bid2: Bid;
  
  ngOnInit(): void {
    this.user = JSON.parse(sessionStorage.getItem('activeUser'));
    this.componentId = +this.route.snapshot.paramMap.get('id');
    this.requestService.getByUserId(this.user.id).subscribe((bid: Bid[]) => {
      console.log(bid)
      this.bids = bid;
    });

    

  }

  // getAllBids() {
  //   this.requestService.getByUserId().subscribe((data: Bid[]) => {
  //     this.bids = data;
      
  //     console.log(this.bids)
  //   });
  // }


}
