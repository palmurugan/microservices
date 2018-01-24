import { Component, ViewChild, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Message } from 'primeng/components/common/api';

import { QueryBuilderConfig } from '../../../lib/components/query-builder';
import { Observable } from 'rxjs/Observable';
import { ReportService } from './report.service';
import { Resource } from '../domain/Resource';
@Component({
    templateUrl: './report-create.component.html'
})
export class ReportCreateComponent implements OnInit {

    definitionId: number;
    msgs: Message[] = [];
    isLinear = true;
    public: boolean = true;
    resources: Resource[];
    firstFormGroup: FormGroup;
    secondFormGroup: FormGroup;
    name: string;
    description: string;
    resource: number;
    available: any[];
    selected: any[];
    public query: any;
    public config: any;
    constructor(private reportService: ReportService, private _formBuilder: FormBuilder) {

    }
    ngOnInit() {
        this.firstFormGroup = this._formBuilder.group({
            name: ['', Validators.required],
            resourceView: '',
            description: '',
            public: ''
        });
        this.firstFormGroup.patchValue({
            public: true
        });

        this.selected = [];

        this.reportService.getViewList().then(resources => this.resources = resources);

        this.query = this.reportService.getBasicQuery();
        this.query.subscribe(data => {
            this.query = data;
        });

        this.config = this.reportService.getBasicFilterConfiguration();
         this.config.subscribe(data => {
             this.config = data;
         });
    }

    loadColumnFilter(event) {
        this.reportService.getAvailableColumn(event.value).then(availableColumn => this.available = availableColumn);
        this.config = this.reportService.getFilterConfiguration(event.value);
        this.config.subscribe(data => {
            this.config = data;
        });
    }

    saveDefinition() {
        const definition = {
            'resource': {
                'resourceId': this.firstFormGroup.get('resourceView').value
            },
            'name': this.firstFormGroup.get('name').value,
            'description': this.firstFormGroup.get('description').value,
            'internal': this.firstFormGroup.get('public').value,
            'status': 'A'
        };
        this.reportService.saveReportDefinition(definition).subscribe(result => {
            this.definitionId = result.definitionId;
        });
        this.msgs.push({ severity: 'success', summary: 'Success Message', detail: 'Report Created' });
    }
    saveColumns() {
        let i = 1;
        const selectedColumns = [];
        this.selected.forEach(column => {
            selectedColumns.push({
                'name': column.name,
                'sequence': i,
                'status': 'A'
            });
            i++;
        });
        const columnData = {
            'resource': {
                'resourceId': this.firstFormGroup.get('resourceView').value
            },
            'reportColumns': selectedColumns,
            'reportFilter': {
                'filterQuery': JSON.stringify(this.query)
            },
            'name': this.firstFormGroup.get('name').value,
            'description': this.firstFormGroup.get('description').value,
            'internal': this.firstFormGroup.get('public').value,
            'status': 'A'
        };
        this.reportService.updateReportDefinition(this.definitionId, columnData).subscribe(result => {
            this.definitionId = result.definitionId;
        });
        this.msgs.push({ severity: 'success', summary: 'Success Message', detail: 'Report Created' });
    }
    saveReportFilter() {
        let i = 1;
        const selectedColumns = [];
        this.selected.forEach(column => {
            selectedColumns.push({
                'name': column.name,
                'sequence': i,
                'status': 'A'
            });
            i++;
        });
        const columnData = {
            'resource': {
                'resourceId': this.firstFormGroup.get('resourceView').value
            },
            'reportColumns': selectedColumns,
            'reportFilter': {
                'filterQuery': JSON.stringify(this.query)
            },
            'name': this.firstFormGroup.get('name').value,
            'description': this.firstFormGroup.get('description').value,
            'internal': this.firstFormGroup.get('public').value,
            'status': 'A'
        };
        this.reportService.updateReportDefinition(this.definitionId, columnData).subscribe(result => {
            this.definitionId = result.definitionId;
        });
        this.msgs.push({ severity: 'success', summary: 'Success Message', detail: 'Report Created' });
    }
}
