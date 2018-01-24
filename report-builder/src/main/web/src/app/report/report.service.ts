import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import { Resource } from '../domain/Resource';
import { ReportDefinition } from '../domain/ReportDefinition';
import { QueryBuilderConfig } from '../../../lib/components/query-builder';

@Injectable()
export class ReportService {
    constructor(private _http: Http) { }

    getViewList() {
        return this._http.get('v1/resources?status=A')
            .toPromise()
            .then(res => <Resource[]>res.json())
            .then(data => data);
    }

    getAvailableColumn(resourceId: number) {
        return this._http.get('v1/datas/columns/' + resourceId)
            .toPromise()
            .then(res => <any>res.json())
            .then(data => data);
    }

    getReportDefinition(resourceId: number): Observable<any> {
        return this._http.get('v1/definitions/' + resourceId)
            .map(this.extractData);
    }

    getQueryDefinition(): Observable<any> {
        return this._http.get('assets/data/query.json')
            .map(this.extractData);
    }
    getFilterConfiguration(resourceId: number): Observable<any> {
        return this._http.get('v1/datas/fiters/config/' + resourceId)
            .map(this.extractData);
    }

    getDefinitionData(page: number, size: number): Observable<any> {
        return this._http.get('v1/definitions?page=' + page + '&size=' + size)
            .map(this.extractData);
    }

    getBasicQuery(): Observable<any> {
        return this._http.get('assets/data/query-base.json')
            .map(this.extractData);
    }
    getBasicFilterConfiguration(): Observable<any> {
        return this._http.get('assets/data/filter-config-base.json')
            .map(this.extractData);
    }

    saveReportDefinition(data: any): Observable<any> {
        return this._http.post('v1/definitions', data)
            .map(this.extractData);
    }

    updateReportDefinition(definitionId: number, data: any): Observable<any> {
        return this._http.put('v1/definitions/' + definitionId, data).map(this.extractData);
    }

    extractData(result: Response) {
        return result.json();
    }
}
