import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import {Params, ActivatedRoute, Router} from '@angular/router';

import { Center } from '../../models/center';

import {CenterService } from '../../services/center.service';

@Component({
  selector: 'app-center-list',
  templateUrl: './center-list.component.html',
  styleUrls: ['./center-list.component.css']
})
export class CenterListComponent implements OnInit {

	Math: any;
	
	starsCount : number = 3;

	imageNumber : number = Math.floor((Math.random() * 20) + 1);

	centers: Center[] = [];
	

	constructor(
	  	private centerService : CenterService,
	  	//private ratingAndReviewService: RatingAndReviewService,
		private router:Router,
		private http:Http,
		private route:ActivatedRoute
	) { }

  	ngOnInit() {
  		this.Math = Math;
  		this.centerService.getCenterList().subscribe(
			res => {
				this.centers = JSON.parse(JSON.parse(JSON.stringify(res))._body);
        		//this.centers = JSON.parse(JSON.parse(JSON.stringify(res))._body);
        		//console.log(JSON.parse(JSON.stringify(res))._body);
        		console.log(this.centers);
      		},
      		error => console.log(error)
		)
  	}

  	getCenterDetails(id: String){
		this.router.navigate(['/center/', id]);
	}

	getImageNumber(){
		this.imageNumber = Math.floor((Math.random() * 20) + 1);
		return this.imageNumber;
	}

}
