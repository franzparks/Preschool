import { Component, OnInit } from '@angular/core';
import{RatingAndReview} from '../../models/rating-and-review';

@Component({
  selector: 'app-rating',
  templateUrl: './rating.component.html',
  styleUrls: ['./rating.component.css']
})
export class RatingComponent implements OnInit {

	private ratingAdded: boolean;
	private ratingAndReview: RatingAndReview = new RatingAndReview();

  	constructor() { }

  	ngOnInit() {
  	}

}
