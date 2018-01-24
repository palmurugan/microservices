import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Message } from 'primeng/components/common/api';
import { QueryBuilderConfig } from '../../../lib/components/query-builder';
import { Observable } from "rxjs/Observable";
import { ReportService } from './report.service';
import { Resource } from '../domain/Resource';
@Component({
    templateUrl: './report-update.component.html'
})
export class ReportUpdateComponent implements OnInit {
    msgs: Message[] = [];
    reportId: number;
    isChecked: boolean = true;
    resources: Resource[];
    isLinear = true;
    firstFormGroup: FormGroup;
    secondFormGroup: FormGroup;
    name: string;
    description: string;
    resource: number;
    available: any[];
    selected: any[];
    public query: any;
    public config: any;
    public reportDefinition: any;
    private paramSub: any;

    constructor(private reportService: ReportService, private _formBuilder: FormBuilder, private route: ActivatedRoute) {

    }
    ngOnInit() {
        this.paramSub = this.route.params.subscribe(params => {
            this.reportId = params['reportId'];
        });
        this.selected = [];
        this.reportService.getViewList().then(resources => this.resources = resources);

        this.firstFormGroup = this._formBuilder.group({
            name: ['', Validators.required],
            resourceView: '',
            description: '',
            public: ''
        });
        this.reportDefinition = this.reportService.getReportDefinition(this.reportId);
        this.reportDefinition.subscribe(data => {
            this.firstFormGroup.patchValue({
                public: data.internal,
                name: data.name,
                description: data.description,
                resourceView: data.resource.resourceId
            });
            this.selected = data.reportColumns;
            this.loadFilter(data.resource.resourceId);
        });
        
        this.query = this.reportService.getBasicQuery();
        this.query.subscribe(data => {
            this.query = data;
        });

        this.config = this.reportService.getBasicFilterConfiguration();
         this.config.subscribe(data => {
             this.config = data;
         });
    }
    
    loadFilter(resourceId: number) {
        this.reportService.getAvailableColumn(resourceId).then(availableColumn => this.available = availableColumn);
        
        this.query = this.reportService.getReportDefinition(this.reportId);
        this.config = this.reportService.getFilterConfiguration(resourceId);
        this.config.subscribe(data => {
            this.config = data;
             this.query.subscribe(data => {
                this.query = JSON.parse(data.reportFilter.filterQuery);
            });
        });
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
        this.reportService.updateReportDefinition(this.reportId, columnData).subscribe(result => {
            // this.definitionId = result.definitionId;
        });
        this.msgs.push({ severity: 'success', summary: 'Success Message', detail: 'Report Updated' });
    }
}

