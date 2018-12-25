import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-purchase-create-component',
  templateUrl: './purchase-create-component.component.html',
  styleUrls: ['./purchase-create-component.component.scss']
})
export class PurchaseCreateComponentComponent implements OnInit {

  date1: Date;
  
  constructor() { }

  ngOnInit() {
  }

}
