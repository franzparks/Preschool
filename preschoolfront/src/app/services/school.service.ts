import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import  {School} from '../models/school';

@Injectable()
export class SchoolService {

	private schoolsUrl = './mock-schools.ts';

  	constructor(private http: Http) { }

  	getSchoolList() {
    	return this.http.get(this.schoolsUrl, { withCredentials: true });
  	}

}
