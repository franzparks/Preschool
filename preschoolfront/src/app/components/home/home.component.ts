import { Component, OnInit } from '@angular/core';

import { School } from '../models/school';

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
