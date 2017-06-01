import { Injectable } from '@angular/core';
import {Http, Headers} from '@angular/http';

import {RatingAndReview} from '../models/rating-and-review';

@Injectable()
export class AddRatingService {

  constructor(private http:Http) { }

}
