import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ComponentRequests } from '../models/componentRequests';
import { RequestsServiceService } from '../service/requests-service.service';

@Component({
  selector: 'app-closed-auctions',
  templateUrl: './closed-auctions.component.html',
  styleUrls: ['./closed-auctions.component.css']
})
export class ClosedAuctionsComponent implements OnInit {

  constructor(private requestService: RequestsServiceService, private route: Router) { }
  public componentsAuctions:ComponentRequests[] =[];

  ngOnInit(): void {
    this.requestService.getClosedAuctions().subscribe((data: ComponentRequests[])=>{
      this.componentsAuctions = data;
      console.log(data);
    });

  }


  details(idComponent: number){ 
    console.log(idComponent);
   this.route.navigate(["/active-auction-details/", idComponent])
    
  }
  

}
