import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule , } from '@angular/common/http';
import { MaterialModule } from './material.module';

import { AppComponent } from './app.component';
import { TextFieldComponent } from './components/text-field/textfield.component';

import {DataGridComponent, DialogContentExampleDialog} from './components/datagrid/datagrid-component';

import {DataGridService} from './components/datagrid/datagrid-service';

@NgModule({
  declarations: [
  AppComponent,
  TextFieldComponent,
  DataGridComponent,
  DialogContentExampleDialog
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MaterialModule,
    FormsModule
  ],
  entryComponents: [DialogContentExampleDialog],
  providers: [DataGridService],
  bootstrap: [AppComponent]
})
export class AppModule { }
