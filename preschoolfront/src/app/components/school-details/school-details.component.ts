import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { Headers, Http } from '@angular/http';
import {Params, ActivatedRoute, Router} from '@angular/router';

//import { ToastsManager , ToastOptions} from 'ng2-toastr/ng2-toastr';

import {SchoolService } from '../../services/school.service';
import {RatingAndReviewService } from '../../services/rating-and-review.service';
import { LoginService } from '../../services/login.service';
import { UserService } from '../../services/user.service';
import { ToasterService } from '../../services/toaster.service';

import  {RatingAndReview} from '../../models/rating-and-review';
import  {School} from '../../models/school';
import { User } from '../../models/user';


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
  addedToWishList:boolean;

  user: User;

  buttonText: string = this.addedToWishList ? 'Remove From Wishlist' : 'Add To Wishlist';

	constructor(
		private router:Router,
		private http:Http,
		private route:ActivatedRoute,
    private schoolService: SchoolService,
    private userService: UserService,
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
          this.loginService.setLoggedIn(true);
          this.getCurrentUser();
        },
        err => {
          this.loggedIn =false;
          //this.toastr.info('You have logged out');
          
        }
      );

	}

  updateWishList(){

    if(this.addedToWishList){
      // remove from wishlist
      this.removeFromWishList();
    }else{
      // add to wishlist 
      this.addToWishList();
    }


    /*if(this.loggedIn){
      this.toastr.success('You have added this school to your wish list!');
    }else{
      this.router.navigate(['/my-account']);
    }*/
    
  }

  addToWishList(){
    if(this.user.wishList && this.user.wishList.length > 1){
      this.user.wishList += ',' + this.schoolId;
    }else{
      this.user.wishList = '' + this.schoolId;
    }
    
    this.userService.updateUserWishList(this.user).subscribe(
      res => {
        this.user = res.json();
        this.toastr.success('You have added this school to your wish list!');
        this.addedToWishList = true;
      },
      err => {
        console.log(err);
      });
  }

  removeFromWishList(){
    if(this.user.wishList && this.user.wishList.length > 1){
      //this.user.wishList.splice(this.schoolId + ',' ); 
    }else if(this.user.wishList.length == 1){
      this.user.wishList = '';
    }
    
    this.userService.updateUserWishList(this.user).subscribe(
      res => {
        this.user = res.json();
        this.toastr.success('You have removed this school from your wish list!');
        this.addedToWishList = false;
      },
      err => {
        console.log(err);
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
