import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AddRatingService } from '../../services/add-rating.service';
import { UserService } from '../../services/user.service';

import { User } from '../../models/user';

import{RatingAndReview} from '../../models/rating-and-review';

@Component({
  selector: 'app-rating',
  templateUrl: './rating.component.html',
  styleUrls: ['./rating.component.css']
})
export class RatingComponent implements OnInit {

	private ratingAdded: boolean;
	private newRatingAndReview: RatingAndReview = new RatingAndReview();
	private user: User = new User();
	private schoolId: number;

  	constructor(
  		private addRatingService:AddRatingService,
  		private userService: UserService,
  		private router: Router
  	) { }

  	onSubmit(){
  		this.newRatingAndReview.schoolId = this.schoolId;
  		this.newRatingAndReview.user = this.user.username;
  		this.addRatingService.sendReview(this.newRatingAndReview).subscribe(
  		res => {
  			this.ratingAdded=true;
  			this.newRatingAndReview = new RatingAndReview();
  		},
  		error => {
  			console.log(error);
  		});
  	}

  	ngOnInit() {
  		this.ratingAdded=false;
  		this.userService.getCurrentUser().subscribe(
  		res => {
  			this.user = res.json();
  		},
  		err => {
  			console.log(err);
  		});
  		this.route.params.forEach((params: Params) => {
  			this.schoolId = Number.parseInt(params['id']);
  		});
  	}

}
