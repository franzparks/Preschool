import { Component, OnInit } from '@angular/core';
import {Params, ActivatedRoute, Router} from '@angular/router';

import {SchoolService } from '../../services/school.service';

@Component({
  selector: 'app-school-details',
  templateUrl: './school-details.component.html',
  styleUrls: ['./school-details.component.css']
})
export class SchoolDetailsComponent implements OnInit {

	constructor(
		private schoolService: SchoolService,
		private router:Router,
		private http:Http,
		private route:ActivatedRoute
	) { }

	ngOnInit() {
	}

}
