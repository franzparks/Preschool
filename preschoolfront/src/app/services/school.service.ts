import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import  {School} from '../models/school';

@Injectable()
export class SchoolService {

	private schoolsUrl = 'app/schools';

  	constructor(private http: Http) { }

  	getSchoolList() {
    	return this.http.get(this.schoolsUrl, { withCredentials: true });
  	}

  	getSchool(id: number): Promise<School> {
	  	return this.getSchools()
	  		.then(schools => schools.find(school => school.id === id));
	}

}
