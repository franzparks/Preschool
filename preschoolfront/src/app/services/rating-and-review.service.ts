import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import {AppConst} from '../constants/app-consts';

@Injectable()
export class RatingAndReviewService {

  	constructor(
  		private http: Http
  	) { }

}
