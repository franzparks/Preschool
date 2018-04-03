import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';

import {Params, ActivatedRoute, Router} from '@angular/router';

import { Center } from '../../models/center';

import { User } from '../../models/user';

import {CenterService } from '../../services/center.service';
import { UserService } from '../../services/user.service';
import { LoginService } from '../../services/login.service';



@Component({
  selector: 'app-wish-list',
  templateUrl: './wish-list.component.html',
  styleUrls: ['./wish-list.component.css']
})
export class WishListComponent implements OnInit {

	Math: any;

	imageNumber : number = Math.floor((Math.random() * 20) + 1);

	centers: Center[] = [];
	//reviewsList: RatingAndReview[] = [];
	user: User
	wishList: string
	updateSuccess: boolean;

  	constructor(
	  	private centerService : CenterService,
	  	private userService: UserService,
	  	//private ratingAndReviewService: RatingAndReviewService,
		private router:Router,
		private http:Http,
		private route:ActivatedRoute

  	) { }

  	ngOnInit() {
  		this.Math = Math;

  		this.userService.getCurrentUser().subscribe(
	  		res => {
	  			this.user = res.json();

	  			this.centerService.getWishList(this.user.wishList).subscribe(
				res => {
					this.centers = JSON.parse(JSON.parse(JSON.stringify(res))._body);
	      		},
	      		error => console.log(error)
		)

  		},
  		err => {
  			console.log(err);
  		})

 

	    
  	}

  	/*updateWishList(){
  		this.userService.updateUserWishList(this.user, this.wishList).subscribe(
	  		res => {
	  			console.log(res.text());
	  			this.updateSuccess=true;
	  		},
	  		error => {
	  			console.log(error.text());
	  			//let errorMessage = error.text();
	  		});
  	}*/


  	getCenterDetails(id: String){
		this.router.navigate(['/center/', id]);
	}

}
