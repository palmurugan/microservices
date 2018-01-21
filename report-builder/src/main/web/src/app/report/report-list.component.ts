import { Component, ViewChild, OnInit } from '@angular/core';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { ServerDatasource } from './server-datasource';

import { ReportDefinition } from '../domain/ReportDefinition';
import { ReportService } from './report.service';

@Component({
    templateUrl: './report-list.component.html'
})
export class ReportListComponent implements OnInit {
    definitions: any;
    displayedColumns = ['id', 'name', 'description', 'internal', 'status', 'action'];
    dataSource: ServerDatasource | null;

    length: number;
    pageIndex: number = 0;
    pageSize: number = 5;
    pageSizeOptions: number[] = [5, 10, 25, 50, 100];

    constructor(private reportService: ReportService) {
    }

    ngOnInit() {
        this.loadData();
    }

    loadData() {
        this.definitions = this.reportService.getDefinitionData(this.pageIndex, this.pageSize);
        this.definitions.subscribe(data => {
            this.setPagination(data['totalElements'], data['number'], data['size']);
            this.dataSource = new ServerDatasource(data['content']);
        });
    }

    setPagination(length, startIndex, pageSize) {
        this.length = length;
        this.pageIndex = startIndex;
        this.pageSize = pageSize;
    }

    onPaginateChange(event) {
        this.pageIndex = event.pageIndex;
        this.pageSize = event.pageSize;
        this.loadData();
    }

    /*    applyFilter(filterValue: string) {
            filterValue = filterValue.trim(); // Remove whitespace
            filterValue = filterValue.toLowerCase(); // Datasource defaults to lowercase matches
            this.dataSource.filter = filterValue;
        }*/
}