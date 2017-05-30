import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Router, NavigationExtras } from '@angular/router';
import {SchoolService} from '../../services/school.service';
import {School} from '../../models/school';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

	private loggedIn = false;
  	private keyword: string;
  	private schoolList:School[] =[];

  	constructor(
  		private loginService: LoginService,
    	private router: Router,
    	private schoolService: SchoolService
  	) { }

  	ngOnInit() {
  		this.loginService.checkSession().subscribe(
  		res => {
  			this.loggedIn = true;
  		},
  		err => {
  			console.log("error loggin in: "+ err);
  			this.loggedIn =false;
  		});
 	}
  	

  	logout() {
	  	this.loginService.logout().subscribe(
	  		res => {
	  			location.reload();
	  		},
	  		err => {
	  			console.log(err);
  		});
  	}

  	

}
