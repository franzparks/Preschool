import { Component, OnInit } from '@angular/core';

import { AddRatingService } from '../../services/add-rating.service';

import{RatingAndReview} from '../../models/rating-and-review';

@Component({
  selector: 'app-rating',
  templateUrl: './rating.component.html',
  styleUrls: ['./rating.component.css']
})
export class RatingComponent implements OnInit {

	private ratingAdded: boolean;
	private newRatingAndReview: RatingAndReview = new RatingAndReview();

  	constructor(
  		private ratingAndReview:RatingAndReview
  	) { }

  	onSubmit(){

  	}

  	ngOnInit() {
  	}

}
