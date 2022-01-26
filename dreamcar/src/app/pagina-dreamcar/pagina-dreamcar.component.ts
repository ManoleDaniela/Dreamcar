import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pagina-dreamcar',
  templateUrl: './pagina-dreamcar.component.html',
  styleUrls: ['./pagina-dreamcar.component.css']
})
export class PaginaDreamcarComponent implements OnInit {

  constructor(private route: Router) { }

  ngOnInit(): void {
    
  }


  placeAuctions(){    
    // this.requestService.loginUser(this.username,this.password).subscribe((data: User) =>{
 
         this.route.navigate(["/place-auctions"])
       //  sessionStorage.setItem("username", String(data.id));
       
      
   }

  activeAuctions(){    
    // this.requestService.loginUser(this.username,this.password).subscribe((data: User) =>{
 
         this.route.navigate(["/active-auctions"])
       //  sessionStorage.setItem("username", String(data.id));
       
      
   }
 
   closedAuctions(){    
    // this.requestService.loginUser(this.username,this.password).subscribe((data: User) =>{
      
         this.route.navigate(["/closed-auctions"])
        // sessionStorage.setItem("username", String(data.id));
      
   }

}
