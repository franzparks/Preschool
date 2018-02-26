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

  buttonText: string = 'Add To Wishlist';

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
    console.log(":::on init called!:::::");
		this.route.params.forEach((params: Params) => {
			this.schoolId = Number.parseInt(params['id']);
		});

		this.schoolService.getSchool(this.schoolId).subscribe(
  		res => {
  			this.school = res.json(); 
  		},
  		error => {
  			console.log(error);
  		}
    );

    this.ratingAndReviewService.getReviewsList(this.schoolId).subscribe(
      res => {
        this.reviewsList=res.json(); 
      },
      error => {
        console.log(error);
      }
    );

    //check if user is logged in
    this.loginService.checkSession().subscribe(
      res => {
        this.loggedIn = true;
        this.loginService.setLoggedIn(true);
      },
      err => {
        this.loggedIn = false;
        //this.toastr.info('You have logged out');
      }
    );

    // get current user 
    this.getCurrentUser();

    //this.buttonText = this.addedToWishList ? 'Remove From Wishlist' : 'Add To Wishlist';
    //console.log(this.addedToWishList);
	}

  updateWishList(){

    if(!this.loggedIn){
      this.router.navigate(['/my-account']);
      return;
    }

    if(this.addedToWishList){
      // remove from wishlist
      this.removeFromWishList();
    }else{
      // add to wishlist 
      this.addToWishList();
    }

    this.getCurrentUser();
    
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
        console.log(res);
        console.log("new wishlist : "+this.user.wishList);
        this.toastr.success('You have added this school to your wish list!');
        this.addedToWishList = true;
        this.buttonText = 'Remove From Wishlist';
      },
      err => {
        this.toastr.error('Error occured, school could not be added to your wish list');
        console.log(err);
      });
  }

  removeFromWishList(){
    if(this.user.wishList && this.user.wishList.length > 1){
      let wishlist = this.user.wishList;
      wishlist = wishlist.replace(this.schoolId + ',', '');
      this.user.wishList = wishlist;
    }else if(this.user.wishList.length === 1){
      this.user.wishList = '';
    }
    console.log("new wishlist : "+this.user.wishList);
    this.userService.updateUserWishList(this.user).subscribe(
      res => {
        this.user = res.json();
        this.toastr.success('You have removed this school from your wish list!');
        this.addedToWishList = false;
        this.buttonText = 'Add To Wishlist';
      },
      err => {
        console.log(err);
      });
  }

  getCurrentUser() {
    console.log(":::get current user called!:::::");
    this.userService.getCurrentUser().subscribe(
      res => {
        this.user = res.json();
        //this.checkUserWishlist();

        let id = ''+this.schoolId;
        let index = -1; 

        if(this.user.wishList){
          index = this.user.wishList.indexOf(id);
        }

        if(index >= 0){
          this.addedToWishList =  true;
        }else{
          this.addedToWishList = false;
        }
        this.buttonText = this.addedToWishList ? 'Remove From Wishlist' : 'Add To Wishlist';
        console.log("::: index ::::: "+index);
      },
      err => {
        console.log(err);
      });

    console.log("::: addedToWishList ::::: "+this.addedToWishList);
    console.log(":::button text::::: "+this.buttonText);
  }

  checkUserWishlist(){
    let id = ''+this.schoolId;
    let index; 

    if(this.user.wishList){
      index = this.user.wishList.indexOf(id);
    }

    if(index && index >= 0){
      this.addedToWishList =  true;
    }else{
      this.addedToWishList = false;
    }
    this.buttonText = this.addedToWishList ? 'Remove From Wishlist' : 'Add To Wishlist';
  }



}
