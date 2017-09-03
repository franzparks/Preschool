import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import  {School} from '../models/school';
import {AppConst} from '../constants/app-consts';

@Injectable()
export class SchoolService {

  private serverPath = AppConst.serverPath;


	constructor(private http: Http) { }

	getSchoolList() {
  	//return this.http.get(this.serverPath+ '/school/schoolList', { withCredentials: true });
    let url = this.serverPath+ '/school/schoolList';

    let tokenHeader = new Headers({
      'Content-Type' : 'application/json',
      'Access-Control-Allow-Origin': '*'
      //'x-auth-token' : localStorage.getItem("xAuthToken")
    });
    return this.http.get(url, {headers: tokenHeader});
	}

	getSchool(id: number) {

  	let url = this.serverPath+'/school/'+id;

  	let tokenHeader = new Headers({
  		'Content-Type' : 'application/json',
  		'x-auth-token' : localStorage.getItem("xAuthToken")
  	});
  	return this.http.get(url, {headers: tokenHeader});
  }

  sendSchool(school:School) {

    let url = this.serverPath+ '/school/add';
    
    let headers = new Headers ({
      'Content-Type': 'application/json',
      'x-auth-token' : localStorage.getItem('xAuthToken')
    });

    return this.http.post(url, JSON.stringify(school), {headers: headers});
  }

}
