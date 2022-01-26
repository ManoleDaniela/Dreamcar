import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PaginaPrincipalaComponent } from './pagina-principala/pagina-principala.component';
import {HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { PaginaUserComponent } from './pagina-user/pagina-user.component';
import { ActiveAuctionsComponent } from './active-auctions/active-auctions.component';
import { ClosedAuctionsComponent } from './closed-auctions/closed-auctions.component';
import { MyAuctionsComponent } from './my-auctions/my-auctions.component';
import { PaginaDreamcarComponent } from './pagina-dreamcar/pagina-dreamcar.component';
import { PlaceAuctionsComponent } from './place-auctions/place-auctions.component';
import { ActiveAuctionDetailsComponent } from './active-auction-details/active-auction-details.component';

@NgModule({
  declarations: [
    AppComponent,
    PaginaPrincipalaComponent,
    PaginaUserComponent,
    ActiveAuctionsComponent,
    ClosedAuctionsComponent,
    MyAuctionsComponent,
    PaginaDreamcarComponent,
    PlaceAuctionsComponent,
    ActiveAuctionDetailsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
