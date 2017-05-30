import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Router, NavigationExtras } from '@angular/router';
import {SchoolService} from '../../services/school.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  	constructor(
  		private loginService: LoginService,
    	private router: Router,
    	private bookService: BookService
  	) { }

  	ngOnInit() {
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
