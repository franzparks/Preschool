import { Component, OnInit } from '@angular/core';

import { School } from '../../models/school';
import {SchoolService } from '../../services/school.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

	starsCount : number = 3;

	schools: School[] = [];

	constructor(private schoolService : SchoolService) { }

	ngOnInit() {
		this.schoolService.getSchoolList().subscribe(
			res => {
				this.schools = JSON.parse(JSON.stringify(res))._body.data;
        		//this.schools = JSON.parse(JSON.parse(JSON.stringify(res))._body);
        		console.log(JSON.parse(JSON.stringify(res))._body.data);	
      		},
      		error => console.log(error)
		)
	}
	  

}
