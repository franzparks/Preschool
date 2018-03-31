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
	  newRatingAndReview: RatingAndReview = new RatingAndReview();
	  schoolId: number;

    user: User;

  	constructor(
  		private addRatingService:AddRatingService,
  		private router: Router,
  		private route:ActivatedRoute,
      private loginService: LoginService,
      private toastr : ToasterService,
      private _location: Location
   
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

    onCancel(){
      this._location.back();
    }

  	ngOnInit() {
  		this.ratingAdded=false;
  		this.route.params.forEach((params: Params) => {
  			this.schoolId = Number.parseInt(params['id']);

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
  		});
  	}

}
