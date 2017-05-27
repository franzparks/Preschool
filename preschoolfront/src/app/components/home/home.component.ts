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

	constructor() { }

	ngOnInit() {

	}
	  

}
