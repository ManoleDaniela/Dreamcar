import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ComponentRequests } from '../models/componentRequests';
import { RequestsServiceService } from '../service/requests-service.service';

@Component({
  selector: 'app-active-auctions',
  templateUrl: './active-auctions.component.html',
  styleUrls: ['./active-auctions.component.css']
})
export class ActiveAuctionsComponent implements OnInit {

  constructor(private requestService: RequestsServiceService, private route: Router) { }
  public componentsAuctions:ComponentRequests[] =[];
  ngOnInit(): void {
    this.requestService.getOpenAuctions().subscribe((data: ComponentRequests[])=>{
      this.componentsAuctions = data;
      console.log(data);
    });
  }

  details(idComponent: number){ 
  console.log(idComponent);
 this.route.navigate(["/active-auction-details/", idComponent])
  
}

}
