import { Component, OnInit } from '@angular/core';
import { Router, NavigationExtras } from '@angular/router';
import { LoginService } from '../../services/login.service';
import {CenterService} from '../../services/center.service';
import {Center} from '../../models/center';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

    public  sCollapsed = false;
	  loggedIn:boolean;
  	keyword: string;
  	centerList:Center[] =[];

    public isIn = true;

  	constructor(
  		private loginService: LoginService,
    	private router: Router,
    	private centerService: CenterService
  	) { }

  	ngOnInit() {
  		this.loginService.checkSession().subscribe(
  		res => {
  			console.log("successfully logged in: "+ res);
  			//this.loggedIn = true;
        this.loginService.setLoggedIn(true);
  		},
  		err => {
  			console.log("error loggin in: "+ err);
  			this.loggedIn =false;
  		});

      this.loginService.loggedInUpdated.subscribe(
      (loggedIn) => {
        this.loggedIn = this.loginService.getLoggedIn();
      }
    );
 	}
  	
    toggleState() { // click handler
        let bool = this.isIn;
        this.isIn = bool === false ? true : false; 
        console.log("toggled: "+ this.isIn);
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
