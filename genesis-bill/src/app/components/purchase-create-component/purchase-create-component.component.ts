import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-purchase-create-component',
  templateUrl: './purchase-create-component.component.html',
  styleUrls: ['./purchase-create-component.component.scss']
})
export class PurchaseCreateComponentComponent implements OnInit {

  ELEMENT_DATA: any[] = [];
  editMode : boolean = false;

  units: any[];
  taxes: any[];

  date1: Date;
  product : string;
  unit : string;
  quantity : number;
  price : number;
  discount : number = 0;
  tax : number = 0;
  id : number = 0;

  displayedColumns: string[] = ['id','product', 'quantity', 'unit', 'price', 'discount', 'cgst','sgst','total', 'edit', 'remove'];
  dataSource = new MatTableDataSource(this.ELEMENT_DATA);
  constructor() { 
    this.units = [
    {label:'Kg', value:'Kg'},
    {label:'Bundle', value:'Bundle'},
    {label:'Pocket', value:'Pocket'},
    {label:'Count', value:'Count'}
    ]

    this.taxes = [
    {label:'2%', value:2},
    {label:'6%', value:6},
    {label:'12%', value:12},
    {label:'18%', value:18}
    ]
  }

  ngOnInit() {
    this.unit = 'Bundle';
  }

  addItem = function() {
    console.log();
    this.ELEMENT_DATA.push({ 
      id : this.getId(),
      product : this.product, 
      unit : this.unit, 
      quantity : this.quantity,  
      price : this.price, 
      discountPercentage : this.discount,
      discount : this.getDiscount(),
      tax : this.tax,
      cgst : this.getGST(),
      sgst : this.getGST(),
      total : this.getTotal()
    });
    this.dataSource = new MatTableDataSource(this.ELEMENT_DATA);
    this.clear();
  }

  getItem = function(id : number) {
    var dataObj = this.ELEMENT_DATA.find(item => item.id === id);
    if(dataObj !== undefined || dataObj != '') {
      this.id = dataObj.id;
      this.product = dataObj.product; 
      this.unit = dataObj.unit;
      this.quantity = dataObj.quantity;
      this.price = dataObj.price; 
      this.discount = dataObj.discountPercentage;
      this.tax = dataObj.tax;
    }
    this.editMode = true;
  }

  updateItem = function() {
    this.ELEMENT_DATA = this.ELEMENT_DATA.map((item, index) => {
      if(item.id === this.id) {  
        item.id = this.id;
        item.product = this.product; 
        item.unit = this.unit;
        item.quantity = this.quantity;
        item.price = this.price;
        item.discount = this.getDiscount();
        item.tax = this.tax;
        item.cgst = this.getGST();
        item.sgst = this.getGST();
        item.total = this.getTotal();
        return item;
      }
    });
    this.dataSource = new MatTableDataSource(this.ELEMENT_DATA);
    this.clear();
    this.editMode = false;
  }

  removeItem = function(id : number) {
    console.log(id);
    this.ELEMENT_DATA.map((item, index) => {
      if(item.id === id) { 
        console.log(item);
        this.ELEMENT_DATA.splice(index,1);
      }
    });
    this.dataSource = new MatTableDataSource(this.ELEMENT_DATA);
  }

  clear = function() {
    this.product = ''; 
    this.unit = '';
    this.quantity = '';
    this.price = ''; 
    this.discount = '';
    this.tax = '';
  }

  getId = function() {
    return (this.id !== undefined) ? this.id += 1 : 1;
  }

  getGST() {
    return (((this.price * this.quantity)*(+this.tax / 100)) /2 );
  }

  getDiscount() {
    return ((this.price * this.quantity) * (this.discount/100));
  }

  getTotal() {
    return (((this.price * this.quantity) + this.getGST() + this.getGST()) - this.getDiscount())
  }
}