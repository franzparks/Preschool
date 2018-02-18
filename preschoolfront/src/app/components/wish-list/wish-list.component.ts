import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';

import { School } from '../../models/school';
import {SchoolService } from '../../services/school.service';

@Component({
  selector: 'app-wish-list',
  templateUrl: './wish-list.component.html',
  styleUrls: ['./wish-list.component.css']
})
export class WishListComponent implements OnInit {

	Math: any;

	imageNumber : number = Math.floor((Math.random() * 20) + 1);

	schools: School[] = [];

  	constructor(
	  	private schoolService : SchoolService,
		private http:Http

  	) { }

  	ngOnInit() {
  		this.Math = Math;
  		this.schoolService.getSchoolList().subscribe(
			res => {
				this.schools = JSON.parse(JSON.parse(JSON.stringify(res))._body);
        		//this.schools = JSON.parse(JSON.parse(JSON.stringify(res))._body);
        		//console.log(JSON.parse(JSON.stringify(res))._body);
      		},
      		error => console.log(error)
		)
  	}

}
