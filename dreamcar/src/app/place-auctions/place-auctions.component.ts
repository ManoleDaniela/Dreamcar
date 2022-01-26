import { Component, OnInit } from '@angular/core';
import { ComponentRequests } from '../models/componentRequests';
import { RequestsServiceService } from '../service/requests-service.service';

@Component({
  selector: 'app-place-auctions',
  templateUrl: './place-auctions.component.html',
  styleUrls: ['./place-auctions.component.css']
})
export class PlaceAuctionsComponent implements OnInit {
  component: string = '';
  quantity: number;
  targetPrice: number;
  limitTime = new Date();
  
  successMessage = '';

  constructor(private requestService: RequestsServiceService) { }

  ngOnInit(): void {
  }

  placeAuction(){   
    const component: ComponentRequests = {
      idReq: 0,
      componentName: this.component,
      quantity: this.quantity,
      targetPrice: this.targetPrice,
      limitTime: this.limitTime,
      idWinner: undefined,
      isClosed: false
    } 
    this.requestService.createComponentRequest(component).subscribe((componentRequests: ComponentRequests)=>{
      console.log(componentRequests);

      if(componentRequests){
        this.successMessage = 'The Auction was successuly created!'
        setTimeout(()=>{
          this.successMessage = ''
          this.component = '';
          this.quantity = null;
          this.targetPrice = null;
          this.limitTime = null; 
        },3000)
      }
    });
  }

}
