import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActiveAuctionDetailsComponent } from './active-auction-details/active-auction-details.component';
import { ActiveAuctionsComponent } from './active-auctions/active-auctions.component';
import { AppComponent } from './app.component';
import { ClosedAuctionsComponent } from './closed-auctions/closed-auctions.component';
import { MyAuctionsComponent } from './my-auctions/my-auctions.component';
import { PaginaDreamcarComponent } from './pagina-dreamcar/pagina-dreamcar.component';
import { PaginaPrincipalaComponent } from './pagina-principala/pagina-principala.component';
import { PaginaUserComponent } from './pagina-user/pagina-user.component';
import { PlaceAuctionsComponent } from './place-auctions/place-auctions.component';

const routes: Routes = [
  { path:"", component: PaginaPrincipalaComponent},
  { path:"pagina-user", component: PaginaUserComponent},
  { path:"active-auctions", component: ActiveAuctionsComponent},
  { path:"closed-auctions", component: ClosedAuctionsComponent},
  { path:"my-auctions", component: MyAuctionsComponent},
  { path:"pagina-dreamcar", component: PaginaDreamcarComponent},
  { path:"place-auctions", component: PlaceAuctionsComponent},
  { path:"active-auction-details/:id", component: ActiveAuctionDetailsComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
