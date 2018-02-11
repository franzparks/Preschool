import { Component, OnInit, ViewContainerRef } from '@angular/core';

import { Http } from '@angular/http';
import {Params, ActivatedRoute, Router} from '@angular/router';

import { ToasterService } from '../../services/toaster.service';

import { School } from '../../models/school';
import {SchoolService } from '../../services/school.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

	isClassVisible = false;

	starsCount : number = 3;

	topSchools: School[] = [];

	loggedIn:boolean;

	constructor(
		private schoolService : SchoolService,
		private router:Router,
		private http:Http,
		private route:ActivatedRoute,
		private toastr : ToasterService,
	) { }

	ngOnInit() {
		this.schoolService.getSchoolList().subscribe(
			res => {
				console.log(res);
				this.loggedIn = true;
				this.topSchools = JSON.parse(JSON.parse(JSON.stringify(res))._body);
        		//this.schools = JSON.parse(JSON.parse(JSON.stringify(res))._body);
        		
      		},
      		error => console.log(error)
		)
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