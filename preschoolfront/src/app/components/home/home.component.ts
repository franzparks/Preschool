import { Component, OnInit, ViewContainerRef } from '@angular/core';

import { Http } from '@angular/http';
import {Params, ActivatedRoute, Router} from '@angular/router';

import { ToasterService } from '../../services/toaster.service';

import { School } from '../../models/school';
import {SchoolService } from '../../services/school.service';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

	isClassVisible = false;

	starsCount : number = 3;

	topSchools: School[] = [];

	schools: School[] = [];

	searchTerms: string = 'title,address, summary, ageRange, priceRange, schedule, website, phone, averageRating';

	loggedIn = false;

	searchText:string = 'hello';

	constructor(
		private schoolService : SchoolService,
		private router:Router,
		private http:Http,
		private route:ActivatedRoute,
		private toastr : ToasterService,
		private loginService: LoginService
	) { }

	ngOnInit() {

		this.schoolService.getSchoolList().subscribe(
			res => {
				console.log(res);
				//this.topSchools = JSON.parse(JSON.parse(JSON.stringify(res))._body);
        		this.schools = JSON.parse(JSON.parse(JSON.stringify(res))._body);

        		if(this.schools.length > 0){
					this.topSchools = this.schools;
					//sort by rating
					// then get top 3
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

	searchUpdated(val) {
		console.log("here");
    	console.log(val);
	}

	getSchoolDetails(id: String){
		this.router.navigate(['/school/', id]);
	}

	addToWishList(){
		if(this.loggedIn){
	      this.toastr.success('You have added this school to your wish list!');
	    }else{
	      this.router.navigate(['/my-account']);
		}

	}
}