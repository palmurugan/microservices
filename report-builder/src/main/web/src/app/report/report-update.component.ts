import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { QueryBuilderConfig } from '../../../lib/components/query-builder';
import { Observable } from "rxjs/Observable";
import { ReportService } from './report.service';
import { Resource } from '../domain/Resource';
@Component({
    templateUrl: './report-update.component.html'
})
export class ReportUpdateComponent implements OnInit {
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
        this.reportService.getAvailableColumn(1).then(availableColumn => this.available = availableColumn);
        this.reportService.getViewList().then(resources => this.resources = resources);

        this.firstFormGroup = this._formBuilder.group({
            name: ['', Validators.required],
            resourceView: '',
            description: '',
            public: ''
        });
        this.reportDefinition = this.reportService.getReportDefinition(1);
        this.reportDefinition.subscribe(data => {
            this.firstFormGroup.patchValue({
                public: data.public,
                name: data.name,
                description: data.description,
                resourceView: data.resource.resourceId
            });
            this.selected = data.reportColumns;
        });

        this.query = this.reportService.getReportDefinition(1);
        this.query.subscribe(data => {
            this.query = JSON.parse(data.reportFilter.filterQuery);
        });

        this.config = this.reportService.getFilterConfiguration(1);
        this.config.subscribe(data => {
            this.config = data;
        });
    }

    saveReport() {
        var data = {
            "resource": {
                "resourceId": this.resource
            },
            "reportColumns": [{
                "name": "lastname",
                "sequence": 1,
                "status": "A"
            }],
            "reportFilter": {
                "filterQuery": JSON.stringify(this.query)
            },
            "name": this.name,
            "description": this.description,
            "internal": this.isChecked,
            "status": "A"
        }
        console.log("Result Value :", data);
    }
}

