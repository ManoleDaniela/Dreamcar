import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../models/user';
import { RequestsServiceService } from '../service/requests-service.service';

@Component({
  selector: 'app-pagina-principala',
  templateUrl: './pagina-principala.component.html',
  styleUrls: ['./pagina-principala.component.css']
})
export class PaginaPrincipalaComponent implements OnInit {

  constructor(private requestService: RequestsServiceService, private route: Router) { }
  username: string = '';
  password: string = '';

  ngOnInit(): void {
   
  }

  login(){    
    this.requestService.loginUser(this.username,this.password).subscribe((userFound: User) =>{
      console.log(userFound);
      
      if(userFound.id == 1){
        this.route.navigate(["/pagina-dreamcar"])
        sessionStorage.setItem("activeUser", JSON.stringify(userFound));
      } 
      else 
      {
        this.route.navigate(["/pagina-user"])
        sessionStorage.setItem("activeUser", JSON.stringify(userFound));
      } 

     })
  }

}
