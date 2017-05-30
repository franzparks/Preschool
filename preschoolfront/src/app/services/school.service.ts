import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import  {School} from '../models/school';
import {AppConst} from '../constants/app-consts';

@Injectable()
export class SchoolService {

	private schoolsUrl = AppConst.serverPath+"/schools";

  	constructor(private http: Http) { }

  	getSchoolList() {
    	return this.http.get(this.schoolsUrl, { withCredentials: true });
  	}

  	getSchool(id: number) {

  	let url = AppConst.serverPath+"/school/"+id;

  	let tokenHeader = new Headers({
  		'Content-Type' : 'application/json',
  		'x-auth-token' : localStorage.getItem("xAuthToken")
  	});
  	return this.http.get(url, {headers: tokenHeader});
  }

}
