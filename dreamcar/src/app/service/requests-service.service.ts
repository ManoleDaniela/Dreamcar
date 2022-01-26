import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Bid } from '../models/bid';
import { ComponentRequests } from '../models/componentRequests';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class RequestsServiceService {


  constructor(private http: HttpClient) { }

  public url = 'http://localhost:8099/'
  
  header = new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': '*',
    'Access-Control-Allow-Credentials': 'true',
    'Access-Control-Allow-Headers': 'Content-Type',
    'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE',
     });

  loginUser(name: string, password: string){
    return this.http.post<User>('http://localhost:8099/users/login', {name, password}, {headers: this.header});
  }

  createComponentRequest(componentRequests: ComponentRequests){
    return this.http.post<ComponentRequests>('http://localhost:8099/components/create', componentRequests, {headers: this.header});

  }

  getOpenAuctions() {
    return this.http.get<ComponentRequests[]>(`${this.url}components/getAll`);
  }

  getClosedAuctions() {
    return this.http.get<ComponentRequests[]>(`${this.url}components/getAllClosed`);
  }

  getAuctionDetails(id: number) {
    return this.http.get<ComponentRequests>(`${this.url}components/`+id);
  }

  placeBid(bid: Bid){
    return this.http.post<Bid>('http://localhost:8099/bids/create', bid, {headers: this.header});

  }

  getBidsWithUsername(componentId: number) {
    return this.http.get<Bid[]>(`${this.url}bids/getWithUsername/`+componentId);
  }

  getByUserId(id: number) {
    return this.http.get<Bid[]>(`${this.url}bids/getByUserId/`+id);
  }
}
