import { Component, OnInit } from '@angular/core';
import { Params, ActivatedRoute,Router } from '@angular/router';

import { AddRatingService } from '../../services/add-rating.service';

import{RatingAndReview} from '../../models/rating-and-review';

@Component({
  selector: 'app-rating',
  templateUrl: './rating.component.html',
  styleUrls: ['./rating.component.css']
})
export class RatingComponent implements OnInit {

	  ratingAdded: boolean;
	  newRatingAndReview: RatingAndReview = new RatingAndReview();
	  schoolId: number;

  	constructor(
  		private addRatingService:AddRatingService,
  		private router: Router,
  		private route:ActivatedRoute
  	) { }

  	onSubmit(){
  		this.newRatingAndReview.givenSchoolId = this.schoolId;
  		this.addRatingService.sendReview(this.newRatingAndReview).subscribe(
  		res => {
  			this.ratingAdded=true;
  			this.newRatingAndReview = new RatingAndReview();
  			this.router.navigate(['/school/', this.schoolId]);
  		},
  		error => {
  			console.log(error);
  		});
  	}

  	ngOnInit() {
  		this.ratingAdded=false;
  		this.route.params.forEach((params: Params) => {
  			this.schoolId = Number.parseInt(params['id']);
  		});
  	}

}
