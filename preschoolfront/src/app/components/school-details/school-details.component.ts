import { Component, OnInit } from '@angular/core';
import { Headers, Http } from '@angular/http';
import {Params, ActivatedRoute, Router} from '@angular/router';

import { ToastsManager } from 'ng2-toastr/ng2-toastr';

import {SchoolService } from '../../services/school.service';
import {RatingAndReviewService } from '../../services/rating-and-review.service';
import { LoginService } from '../../services/login.service';

import  {RatingAndReview} from '../../models/rating-and-review';
import  {School} from '../../models/school';


@Component({
  selector: 'app-school-details',
  templateUrl: './school-details.component.html',
  styleUrls: ['./school-details.component.css']
})
export class SchoolDetailsComponent implements OnInit {

	schoolId : number;
	school: School = new School();
  reviewsList: RatingAndReview[];
  loggedIn:boolean;

	constructor(
		private router:Router,
		private http:Http,
		private route:ActivatedRoute,
    private schoolService: SchoolService,
    private ratingAndReviewService: RatingAndReviewService,
    private loginService: LoginService
	) { }

	ngOnInit() {

		this.route.params.forEach((params: Params) => {
  			this.schoolId = Number.parseInt(params['id']);
  		});

  		this.schoolService.getSchool(this.schoolId).subscribe(
  		res => {
  			this.school=res.json(); 
  		},
  		error => {
  			console.log(error);
  		});

      this.ratingAndReviewService.getReviewsList(this.schoolId).subscribe(
      res => {
        this.reviewsList=res.json(); 
      },
      error => {
        console.log(error);
      });

      //check if user is logged in
      this.loginService.checkSession().subscribe(
        res => {
          this.loggedIn = true;
        },
        err => {
          this.loggedIn =false;
        }
      );

	}

  addToWishList(){
    //use $mdToast if possible
  }

  showSuccess() {
        this.toastr.success('You are awesome!', 'Success!');
      }
    
      showError() {
        this.toastr.error('This is not good!', 'Oops!');
      }
    
      showWarning() {
        this.toastr.warning('You are being warned.', 'Alert!');
      }
    
      showInfo() {
        this.toastr.info('Just some information for you.');
      }

}
