import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import {Params, ActivatedRoute, Router} from '@angular/router';

import { School } from '../../models/school';
import {SchoolService } from '../../services/school.service';

@Component({
  selector: 'app-school-list',
  templateUrl: './school-list.component.html',
  styleUrls: ['./school-list.component.css']
})
export class SchoolListComponent implements OnInit {

	Math: any;
	
	starsCount : number = 3;

	schools: School[] = [];

	constructor(
	  	private schoolService : SchoolService,
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
      		},
      		error => console.log(error)
		)
  	}

  	getSchoolDetails(id: String){
		this.router.navigate(['/school/', id]);
	}

}
