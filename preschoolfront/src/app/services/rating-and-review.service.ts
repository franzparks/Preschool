import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import {AppConst} from '../constants/app-consts';

@Injectable()
export class RatingAndReviewService {

  	constructor(
  		private http: Http
  	) { }

  	getReviewsList(id: number) {

  	let url = AppConst.serverPath+"/reviews/"+id+"/all";

  	let tokenHeader = new Headers({
  		'Content-Type' : 'application/json',
  		'x-auth-token' : localStorage.getItem("xAuthToken")
  	});
  	return this.http.get(encodeURI(url), {headers: tokenHeader});
  }

}
