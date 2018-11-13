import {Component, OnInit, ViewChild}  from '@angular/core';
import {MatDialog, MatPaginator, MatTableDataSource} from '@angular/material';
import { map } from 'rxjs/operators';
import {DataGridService} from './datagrid-service';

@Component({
	selector:'datagrid',
	templateUrl:'./datagrid-component.html'
})
export class DataGridComponent implements OnInit {
	displayedColumns: string[] = ['id', 'name', 'username','email'];
	dataSource:any;

	@ViewChild(MatPaginator) paginator: MatPaginator;

	constructor(public dialog: MatDialog, private _dataGridService: DataGridService) {

	}

	ngOnInit() {
		this._dataGridService.getData('apiURL').subscribe(result => {
			console.log('Result :', result);
			this.dataSource =  new MatTableDataSource<any>(result);
			this.dataSource.paginator = this.paginator;
		});
	}

	openDialog() {
		const dialogRef = this.dialog.open(DialogContentExampleDialog);

		dialogRef.afterClosed().subscribe(result => {
			console.log(`Dialog result: ${result}`);
		});
	}
}

export interface PeriodicElement {
	name: string;
	position: number;
	weight: number;
	symbol: string;
}

const ELEMENT_DATA: any[] = [
{position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H'},
{position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'}
];

@Component({
	selector: 'dialog-content-example-dialog',
	templateUrl: 'dialog-content.html',
})
export class DialogContentExampleDialog {

}