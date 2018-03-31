import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import {Params, ActivatedRoute, Router} from '@angular/router';

import { School } from '../../models/school';
//import  {RatingAndReview} from '../../models/rating-and-review';

import {SchoolService } from '../../services/school.service';
//import {RatingAndReviewService } from '../../services/rating-and-review.service';

@Component({
  selector: 'app-school-list',
  templateUrl: './school-list.component.html',
  styleUrls: ['./school-list.component.css']
})
export class SchoolListComponent implements OnInit {

	Math: any;
	
	starsCount : number = 3;

	imageNumber : number = Math.floor((Math.random() * 20) + 1);

	schools: School[] = [];
	

	constructor(
	  	private schoolService : SchoolService,
	  	//private ratingAndReviewService: RatingAndReviewService,
		private router:Router,
		private http:Http,
		private route:ActivatedRoute
	) { }

  	ngOnInit() {
  		this.Math = Math;
  		this.schoolService.getSchoolList().subscribe(
			res => {
				this.schools = JSON.parse(JSON.parse(JSON.stringify(res))._body);
        		//this.schools = JSON.parse(JSON.parse(JSON.stringify(res))._body);
        		//console.log(JSON.parse(JSON.stringify(res))._body);
        		console.log(this.schools);
      		},
      		error => console.log(error)
		)
  	}

  	getSchoolDetails(id: String){
		this.router.navigate(['/school/', id]);
	}

	getImageNumber(){
		this.imageNumber = Math.floor((Math.random() * 20) + 1);
		return this.imageNumber;
	}

}
