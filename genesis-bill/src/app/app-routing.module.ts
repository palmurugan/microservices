import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { DashBoardComponentComponent } from './components/dash-board-component/dash-board-component.component';
import { PurchaseComponentComponent } from './components/purchase-component/purchase-component.component';
import { PurchaseCreateComponentComponent } from './components/purchase-create-component/purchase-create-component.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashBoardComponentComponent },
  { path: 'purchase', component: PurchaseComponentComponent },
  { path: 'createpurchase', component: PurchaseCreateComponentComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
