import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { MaterialModule } from './material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { routing } from './app.routes';

import { PickListModule, GrowlModule } from 'primeng/primeng';

import { QueryBuilderModule } from '../../lib';

import { AppComponent } from './app.component';
import { ReportCreateComponent } from './report/report-create.component';
import { ReportUpdateComponent } from './report/report-update.component';
import { ReportListComponent } from './report/report-list.component';

import { ReportService } from './report/report.service';

@NgModule({
  declarations: [
    AppComponent,
    ReportCreateComponent,
    ReportUpdateComponent,
    ReportListComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    MaterialModule,
    BrowserAnimationsModule,
    routing,
    PickListModule,
    GrowlModule,
    QueryBuilderModule,
    ReactiveFormsModule

  ],
  providers: [ReportService],
  bootstrap: [AppComponent]
})
export class AppModule { }
