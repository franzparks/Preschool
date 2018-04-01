import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { Headers, Http } from '@angular/http';
import {Params, ActivatedRoute, Router} from '@angular/router';

//import { ToastsManager , ToastOptions} from 'ng2-toastr/ng2-toastr';

import {CenterService } from '../../services/center.service';
import {RatingAndReviewService } from '../../services/rating-and-review.service';
import { LoginService } from '../../services/login.service';
import { UserService } from '../../services/user.service';
import { ToasterService } from '../../services/toaster.service';

import  {RatingAndReview} from '../../models/rating-and-review';
import  {Center} from '../../models/center';
import { User } from '../../models/user';


@Component({
  selector: 'app-center-details',
  templateUrl: './center-details.component.html',
  styleUrls: ['./center-details.component.css']
})
export class CenterDetailsComponent implements OnInit {

	centerId : number;
	center: Center = new Center();
  reviewsList: RatingAndReview[] = [];
  loggedIn:boolean;
  addedToWishList:boolean;

  user: User;

  buttonText: string = 'Add To Wishlist';

	constructor(
		private router:Router,
		private http:Http,
		private route:ActivatedRoute,
    private centerService: CenterService,
    private userService: UserService,
    private ratingAndReviewService: RatingAndReviewService,
    private loginService: LoginService,
    private toastr : ToasterService,
   
    
	) {}

	ngOnInit() {
    console.log(":::on init called!:::::");
		this.route.params.forEach((params: Params) => {
			this.centerId = Number.parseInt(params['id']);
		});

		this.centerService.getCenter(this.centerId).subscribe(
  		res => {
  			this.center = res.json(); 
  		},
  		error => {
  			console.log(error);
  		}
    );

    this.ratingAndReviewService.getReviewsList(this.centerId).subscribe(
      res => {
        this.reviewsList=res.json(); 
        console.log(this.reviewsList);
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
    let currentCenterId = '' + this.centerId;
    if(this.user.wishList &&  this.user.wishList.length >= 1){
      this.user.wishList += ',' + currentCenterId;
    }else{
      this.user.wishList = currentCenterId;
    }
    
    this.userService.updateUserWishList(this.user).subscribe(
      res => {
        this.user = res.json();
        console.log(res);
        console.log("new wishlist : "+this.user.wishList);
        this.toastr.success('Center added to your wish list!');
        this.addedToWishList = true;
        this.buttonText = 'Remove From Wishlist';
      },
      err => {
        this.toastr.error('Error occured, center could not be added to your wish list');
        console.log(err);
      });
  }
 
  removeFromWishList(){
    if(this.user.wishList && this.user.wishList.length > 1){
      let wishlist = this.user.wishList;
      let index = wishlist.indexOf(''+this.centerId);

      if(index === 0){ //if id is at the beginning
        wishlist = wishlist.replace(this.centerId + ',', '');
      }else{
        wishlist = wishlist.replace(','+this.centerId, '');
      }
      
      this.user.wishList = wishlist;
    }else if(this.user.wishList.length === 1){
      this.user.wishList = '';
    }
    console.log("new wishlist : "+this.user.wishList);
    this.userService.updateUserWishList(this.user).subscribe(
      res => {
        this.user = res.json();
        this.toastr.success('Center removed from your wish list!');
        this.addedToWishList = false;
        this.buttonText = 'Add To Wishlist';
      },
      err => {
        console.log(err);
      });
  }

  getCurrentUser() {
    //console.log(":::get current user called!:::::");
    this.userService.getCurrentUser().subscribe(
      res => {
        this.user = res.json();
        this.checkUserWishlist();
      },
      err => {
        console.log(err);
      });

    console.log("::: addedToWishList ::::: "+this.addedToWishList);
    console.log(":::button text::::: "+this.buttonText);
  }

  checkUserWishlist(){
    let id = ''+this.centerId;
    let index; 

    if(this.user.wishList){
      index = this.user.wishList.indexOf(id);
    }

    if(index >= 0){
      this.addedToWishList =  true;
    }else{
      this.addedToWishList = false;
    }
    this.buttonText = this.addedToWishList ? 'Remove From Wishlist' : 'Add To Wishlist';
  }



}
