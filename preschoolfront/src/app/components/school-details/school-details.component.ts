import { Component, OnInit } from '@angular/core';
import { Headers, Http } from '@angular/http';
import {Params, ActivatedRoute, Router} from '@angular/router';

import {SchoolService } from '../../services/school.service';
import  {School} from '../../models/school';


@Component({
  selector: 'app-school-details',
  templateUrl: './school-details.component.html',
  styleUrls: ['./school-details.component.css']
})
export class SchoolDetailsComponent implements OnInit {

	private schoolId : number;
	
  ratingAndReviewsList: RatingAndReview;
  title: string;
  subTitle: string;
  snippet: string;
  summary: string;
  address: string;
  phone: string;
  averageRating: number;
  schoolImage: string;

	constructor(
		private schoolService: SchoolService,
		private router:Router,
		private http:Http,
		private route:ActivatedRoute
	) { }

	ngOnInit() {

		this.route.params.forEach((params: Params) => {
  			this.schoolId = Number.parseInt(params['id']);
  		});

  		this.schoolService.getSchool(this.schoolId).subscribe(
  		res => {
  			//this.school=res.json();
        this.school = JSON.parse(JSON.stringify(res))._body;
        this.averageRating = JSON.parse(JSON.stringify(res))._body["averageRating"];
        console.log("single results : "+this.school);
  		},
  		error => {
  			console.log(error);
  		}
  	);

	}

}
