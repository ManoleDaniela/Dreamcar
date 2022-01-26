import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pagina-user',
  templateUrl: './pagina-user.component.html',
  styleUrls: ['./pagina-user.component.css']
})
export class PaginaUserComponent implements OnInit {

  constructor(private route: Router) { }

  ngOnInit(): void {
    
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

  myAuctions(){    
  //  this.requestService.loginUser(this.username,this.password).subscribe((data: User) =>{
     
        this.route.navigate(["/my-auctions"])
      //  sessionStorage.setItem("username", String(data.id));
      
     
  }

}
