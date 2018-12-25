import { Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-purchase-component',
  templateUrl: './purchase-component.component.html',
  styleUrls: ['./purchase-component.component.scss']
})
export class PurchaseComponentComponent implements OnInit {

  displayedColumns: string[] = ['id', 'name', 'tax', 'amount', 'status'];
  dataSource = new MatTableDataSource<any>(ELEMENT_DATA);

  @ViewChild(MatPaginator) paginator: MatPaginator;

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
  }
}

const ELEMENT_DATA: any[] = [
  {id: 1, name: 'S.K.S Modern Rice Mill', tax: 12.56, amount: 12000, status: 'Pending'},
  {id: 2, name: 'A1 Modern Rice Mill', tax: 45.5, amount: 17000, status: 'Pending'},
  {id: 3, name: 'Motor Generators', tax: 34.7, amount: 34500, status: 'Pending'}
];