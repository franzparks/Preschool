import { Component, OnInit } from '@angular/core';
import { Params, ActivatedRoute,Router } from '@angular/router';
import {Location} from '@angular/common';

import { AddRatingService } from '../../services/add-rating.service';
import { LoginService } from '../../services/login.service';
import { ToasterService } from '../../services/toaster.service';
import { UserService } from '../../services/user.service';

import{RatingAndReview} from '../../models/rating-and-review';
import { User } from '../../models/user';


@Component({
  selector: 'app-rating',
  templateUrl: './rating.component.html',
  styleUrls: ['./rating.component.css']
})
export class RatingComponent implements OnInit {

	  ratingAdded: boolean;
    reviewAnonymously: boolean = true;
	  newRatingAndReview: RatingAndReview = new RatingAndReview();
	  centerId: number;

    user: User;

  	constructor(
  		private addRatingService:AddRatingService,
  		private router: Router,
  		private route:ActivatedRoute,
      private loginService: LoginService,
      private userService: UserService,
      private toastr : ToasterService,
      private _location: Location
   
  	) { }

  	onSubmit(){

  		this.newRatingAndReview.givenCenterId = this.centerId;
      this.newRatingAndReview.reviewer = this.reviewAnonymously ? 'Anonymous' : this.user.firstName + " " + this.user.lastName;
  		this.addRatingService.sendReview(this.newRatingAndReview).subscribe(
  		res => {
  			this.ratingAdded=true;
  			this.newRatingAndReview = new RatingAndReview();
  			this.router.navigate(['/center/', this.centerId]);
  		},
  		error => {
  			console.log(error);
  		});
  	}

    onCancel(){
      this._location.back();
    }

  	ngOnInit() {
  		this.ratingAdded=false;
  		this.route.params.forEach((params: Params) => {
  			this.centerId = Number.parseInt(params['id']);

        //check if user is logged in
      this.loginService.checkSession().subscribe(
        res => {
          this.loginService.setLoggedIn(true);
          //this.loggedIn = true;
          //this.toastr.success('You have successfully logged in!');
        },
        err => {
          
          this.router.navigate(['/my-account/']);
        }
      );

      this.getCurrentUser();

  		});
  	}

    getCurrentUser() {
    this.userService.getCurrentUser().subscribe(
      res => {
        this.user = res.json();
      },
      err => {
        console.log(err);
      });
    }


}
