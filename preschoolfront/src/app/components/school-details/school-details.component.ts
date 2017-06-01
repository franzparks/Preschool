import { Component, OnInit } from '@angular/core';
import { Headers, Http } from '@angular/http';
import {Params, ActivatedRoute, Router} from '@angular/router';

import {SchoolService } from '../../services/school.service';
import  {RatingAndReview} from '../../models/rating-and-review';


@Component({
  selector: 'app-school-details',
  templateUrl: './school-details.component.html',
  styleUrls: ['./school-details.component.css']
})
export class SchoolDetailsComponent implements OnInit {

	private schoolId : number;
	
  ratingAndReviewsList: RatingAndReview;
  private title: string;
  private subTitle: string;
  private snippet: string;
  private summary: string;
  private address: string;
  private phone: string;
  private averageRating: number;
  private schoolImage: string;

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
        this.title = JSON.parse(JSON.stringify(res))._body["title"];
        this.subTitle = JSON.parse(JSON.stringify(res))._body["subTitle"];
        this.snippet = JSON.parse(JSON.stringify(res))._body["snippet"];
        this.summary = JSON.parse(JSON.stringify(res))._body["summary"];
        this.address = JSON.parse(JSON.stringify(res))._body["address"];
        this.phone = JSON.parse(JSON.stringify(res))._body["phone"];
        this.averageRating = JSON.parse(JSON.stringify(res))._body["averageRating"];
        this.schoolImage = JSON.parse(JSON.stringify(res))._body["schoolImage"];
  		},
  		error => {
  			console.log(error);
  		}
  	);

	}

}
