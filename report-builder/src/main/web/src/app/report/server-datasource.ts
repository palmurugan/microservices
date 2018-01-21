import { DataSource } from '@angular/cdk/collections';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import { ReportDefinition } from '../domain/ReportDefinition';

export class ServerDatasource extends DataSource<any> {

    constructor(private _reportDefinitions: ReportDefinition[]) {
        super();
    }

    connect(): Observable<ReportDefinition[]> {
        return Observable.of(this._reportDefinitions);
    }

    disconnect() { }
}