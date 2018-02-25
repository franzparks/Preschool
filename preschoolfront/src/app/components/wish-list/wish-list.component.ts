import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';

import {Params, ActivatedRoute, Router} from '@angular/router';

import { School } from '../../models/school';
import {SchoolService } from '../../services/school.service';
import { UserService } from '../../services/user.service';
import { LoginService } from '../../services/login.service';
import { User } from '../../models/user';

@Component({
  selector: 'app-wish-list',
  templateUrl: './wish-list.component.html',
  styleUrls: ['./wish-list.component.css']
})
export class WishListComponent implements OnInit {

	Math: any;

	imageNumber : number = Math.floor((Math.random() * 20) + 1);

	schools: School[] = [];
	user: User
	wishList: string
	updateSuccess: boolean;

  	constructor(
	  	private schoolService : SchoolService,
	  	private userService: UserService,
		private router:Router,
		private http:Http,
		private route:ActivatedRoute

  	) { }

  	ngOnInit() {
  		this.Math = Math;

  		this.userService.getCurrentUser().subscribe(
	  		res => {
	  			this.user = res.json();

	  			this.schoolService.getWishList(this.user.wishList).subscribe(
				res => {
					this.schools = JSON.parse(JSON.parse(JSON.stringify(res))._body);
	      		},
	      		error => console.log(error)
		)

  		},
  		err => {
  			console.log(err);
  		})
	    
  	}

  	updateWishList(){
  		this.userService.updateUserWishList(this.user, this.wishList).subscribe(
	  		res => {
	  			console.log(res.text());
	  			this.updateSuccess=true;
	  		},
	  		error => {
	  			console.log(error.text());
	  			//let errorMessage = error.text();
	  		});
  	}


  	getSchoolDetails(id: String){
		this.router.navigate(['/school/', id]);
	}

}
