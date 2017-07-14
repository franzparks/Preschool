import { Injectable } from '@angular/core';
import {Http, Headers} from '@angular/http';

import {RatingAndReview} from '../models/rating-and-review';

@Injectable()
export class AddRatingService {

  constructor(private http:Http) { }

  sendReview(review:RatingAndReview) {
  	let url = "http://localhost:8080/reviews/add";
    
    let headers = new Headers ({
      'Content-Type': 'application/json',
      'x-auth-token' : localStorage.getItem('xAuthToken')
    });

    return this.http.post(url, JSON.stringify(review), {headers: headers});
  }

}
