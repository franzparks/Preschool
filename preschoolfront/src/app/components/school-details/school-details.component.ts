import { Component, OnInit } from '@angular/core';
import { Headers, Http } from '@angular/http';
import {Params, ActivatedRoute, Router} from '@angular/router';

import {SchoolService } from '../../services/school.service';
import  {RatingAndReview} from '../../models/rating-and-review';
import  {School} from '../../models/school';


@Component({
  selector: 'app-school-details',
  templateUrl: './school-details.component.html',
  styleUrls: ['./school-details.component.css']
})
export class SchoolDetailsComponent implements OnInit {

	private schoolId : number;
	private school: School = new School();
  /*ratingAndReviewsList: RatingAndReview;
  private school.title: string;
  private school.subTitle: string;
  private school.snippet: string;
  private school.summary: string;
  private school.address: string;
  private school.phone: string;
  private school.averageRating: number;
  private school.schoolImage: string;*/

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
        this.school = JSON.parse(JSON.stringify(res))._body);
        /*this.school.subTitle = JSON.parse(JSON.stringify(res))._body["subTitle"];
        this.school.snippet = JSON.parse(JSON.stringify(res))._body["snippet"];
        this.school.summary = JSON.parse(JSON.stringify(res))._body["summary"];
        this.school.address = JSON.parse(JSON.stringify(res))._body["address"];
        this.school.phone = JSON.parse(JSON.stringify(res))._body["phone"];
        this.school.averageRating = JSON.parse(JSON.stringify(res))._body["averageRating"];
        this.school.schoolImage = JSON.parse(JSON.stringify(res))._body["schoolImage"];*/
  		},
  		error => {
  			console.log(error);
  		}
  	);

	}

}
