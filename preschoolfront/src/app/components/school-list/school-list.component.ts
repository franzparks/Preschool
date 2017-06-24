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

	starsCount : number = 3;

	schools: School[] = [];

	constructor(
	  	private schoolService : SchoolService,
		private router:Router,
		private http:Http,
		private route:ActivatedRoute
	) { }

  	ngOnInit() {
  	}

}
