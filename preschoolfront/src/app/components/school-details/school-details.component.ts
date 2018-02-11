import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { Headers, Http } from '@angular/http';
import {Params, ActivatedRoute, Router} from '@angular/router';

//import { ToastsManager , ToastOptions} from 'ng2-toastr/ng2-toastr';

import {SchoolService } from '../../services/school.service';
import {RatingAndReviewService } from '../../services/rating-and-review.service';
import { LoginService } from '../../services/login.service';
import { ToasterService } from '../../services/toaster.service';

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
    private loginService: LoginService,
    private toastr : ToasterService,
   
    
	) {}

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
          //this.toastr.success('You have successfully logged in!');
        },
        err => {
          this.loggedIn =false;
          //this.toastr.info('You have logged out');
          
        }
      );

	}

  addToWishList(){
    this.toastr.success('You have added this school to your wish list!');
  }



}
