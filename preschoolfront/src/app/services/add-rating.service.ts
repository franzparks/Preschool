import { Injectable } from '@angular/core';
import {Http, Headers} from '@angular/http';
import {AppConst} from '../constants/app-consts';
import {RatingAndReview} from '../models/rating-and-review';

@Injectable()
export class AddRatingService {

	private serverPath:string = AppConst.serverPath;

  	constructor(private http:Http) { }

  	sendReview(review:RatingAndReview) {
	  	let url = this.serverPath + '/reviews/add';
	    
	    let headers = new Headers ({
	      'Content-Type': 'application/json',
	      'x-auth-token' : localStorage.getItem('xAuthToken')
	    });

	    return this.http.post(url, JSON.stringify(review), {headers: headers});
  	}

}
