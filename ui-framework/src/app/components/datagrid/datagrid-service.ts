import {Injectable} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import {Observable,of, from } from 'rxjs';

@Injectable()
export class DataGridService {

	constructor(private _http:HttpClient  ) {

	}

	getData (apiURL) :Observable<any> {
		return this._http.get('http://jsonplaceholder.typicode.com/users').pipe(map(data => data));
	}

	private extractData() {

	}
}
