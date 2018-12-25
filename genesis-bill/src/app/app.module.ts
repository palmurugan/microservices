import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

/* Modules */
import { AppRoutingModule } from './app-routing.module';
import { MaterialModule } from './material.module';
import { PrimeNgModule } from './primeng.module';

/* Components */
import { AppComponent } from './app.component';
import { HeaderMenuComponentComponent } from './components/header-menu-component/header-menu-component.component';
import { CustomerComponentComponent } from './components/customer-component/customer-component.component';
import { VendorComponentComponent } from './components/vendor-component/vendor-component.component';
import { PurchaseComponentComponent } from './components/purchase-component/purchase-component.component';
import { SalesComponentComponent } from './components/sales-component/sales-component.component';
import { ReceiptComponentComponent } from './components/receipt-component/receipt-component.component';
import { DashBoardComponentComponent } from './components/dash-board-component/dash-board-component.component';
import { PurchaseCreateComponentComponent } from './components/purchase-create-component/purchase-create-component.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderMenuComponentComponent,
    CustomerComponentComponent,
    VendorComponentComponent,
    PurchaseComponentComponent,
    SalesComponentComponent,
    ReceiptComponentComponent,
    DashBoardComponentComponent,
    PurchaseCreateComponentComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    MaterialModule,
    PrimeNgModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
