import { Component, OnInit, ViewContainerRef } from '@angular/core';

import { Http } from '@angular/http';
import {Params, ActivatedRoute, Router} from '@angular/router';

import { ToasterService } from '../../services/toaster.service';

import { Center } from '../../models/center';
import {CenterService } from '../../services/center.service';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

	isClassVisible = false;

	starsCount : number = 3;

	topCenters: Center[] = [];

	centers: Center[] = [];

	searchResults: Center[] = [];

	searchTerms: string = 'title,address, summary, ageRange, priceRange, schedule, website, phone, averageRating';

	loggedIn = false;

	searchText:string;

	constructor(
		private centerService : CenterService,
		private router:Router,
		private http:Http,
		private route:ActivatedRoute,
		private toastr : ToasterService,
		private loginService: LoginService
	) { }

	ngOnInit() {

		this.centerService.getCenterList().subscribe(
			res => {
				//console.log(res);
				//this.topCenters = JSON.parse(JSON.parse(JSON.stringify(res))._body);
        		this.centers = JSON.parse(JSON.parse(JSON.stringify(res))._body);

        		if(this.centers.length > 0){
					//sort by rating
					// then get top 3

					this.centers.sort(function (center1, center2) {
					  return center2.averageRating - center1.averageRating;
					});
					console.log("centers : " + this.centers);
					this.topCenters = Object.assign([], this.centers.slice(0,3));
        		}
      		},
      		error => console.log(error)
		)

		//check if user is logged in
      this.loginService.checkSession().subscribe(
        res => {
          this.loggedIn = true;
          this.loginService.setLoggedIn(true);
          //this.toastr.success('You have successfully logged in!');
        },
        err => {
          this.loggedIn =false;
          //this.toastr.info('You have logged out');
          
        }
      );
	}

	//listen for changes to the search term
	searchUpdated(searchTerm) {
    	//console.log(searchTerm);
    	if(searchTerm.length > 0 &&  this.searchResults.length === 0){
    		this.searchResults = Object.assign([], this.centers); 
    	}else if(searchTerm.length === 0 &&  this.searchResults.length > 0){
    		this.searchResults = [];
    	}else{
    		return;
    	}

    	//console.log(this.searchResults);
	}

	getCenterDetails(id: String){
		this.router.navigate(['/center/', id]);
	}

	addToWishList(){
		if(this.loggedIn){
	      this.toastr.success('You have added this center to your wish list!');
	    }else{
	      this.router.navigate(['/my-account']);
		}

	}
}