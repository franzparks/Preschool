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
  		private addRatingService:AddRatingService
  	) { }

  	onSubmit(){
  		this.addRatingService.sendReview(this.newRatingAndReview).subscribe(
  		res => {
  			this.ratingAdded=true;
  			this.newRatingAndReview = new RatingAndReview();
  		},
  		error => {
  			console.log(error);
  		}
  	);
  	}

  	ngOnInit() {
  	}

}
