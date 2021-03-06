import { Component, OnInit } from '@angular/core';
import {Location} from '@angular/common';

import { ToasterService } from '../../services/toaster.service';

import {Router} from '@angular/router';
import {LoginService} from '../../services/login.service';
import {UserService} from '../../services/user.service';
import {AppConst} from '../../constants/app-consts';


@Component({
  selector: 'app-my-account',
  templateUrl: './my-account.component.html',
  styleUrls: ['./my-account.component.css']
})
export class MyAccountComponent implements OnInit {

	  private serverPath = AppConst.serverPath;
  	loginError:boolean = false;
  	loggedIn = false;
  	credential = {'username':'', 'password':''};

  	emailSent: boolean =false;
  	usernameExists:boolean;
  	emailExists:boolean;
  	username:string;
  	email:string;

  	emailNotExists: boolean =false;
  	forgotPasswordEmailSent: boolean;
  	recoverEmail:string; 

    selectedTab:string = 'login'; 

  	constructor(
  		private loginService: LoginService,
  		private userService: UserService,
  		private router: Router,
      private _location: Location,
      private toastr : ToasterService,
  	) { }

  	onLogin() {
  	this.loginService.sendCredential(this.credential.username, this.credential.password).subscribe(
  		res => {
  			console.log(res);
  			localStorage.setItem("xAuthToken", res.json().token);
  			this.loggedIn = true;
  			//location.reload();
        this._location.back();
        this.toastr.success('You have successfully logged in!');
        //location.reload();
  			//this.router.navigate(['/home']);
  		}, 
  		error => {
  			this.loggedIn = false;
  			this.loginError = true;
  		});
  	}

	onNewAccount() {
	  	this.usernameExists = false;
	  	this.emailExists = false;
	  	this.emailSent = false;

	  	this.userService.newUser(this.username, this.email).subscribe(
	  		res => {
	  			console.log(res);
	  			this.emailSent = true;
	  		}, 
	  		error => {
	  			console.log(error.text());
	  			let errorMessage = error.text();
	  			if(errorMessage==="usernameExists") this.usernameExists=true;
	  			if(errorMessage==="emailExists") this.emailExists=true;
	  		});
	}

	onForgotPassword() {
  	this.forgotPasswordEmailSent = false;
  	this.emailNotExists = false;

  	this.userService.retrievePassword(this.recoverEmail).subscribe(
  		res => {
  			console.log(res);
  			this.forgotPasswordEmailSent = true;
  		},
  		error => {
  			console.log(error.text());
  			let errorMessage = error.text();
  			if(errorMessage==="Email not found") this.emailNotExists=true;
  		});
    }


  	ngOnInit() {
  		this.loginService.checkSession().subscribe(
  		res => {
  			this.loggedIn = true;
  		},
  		error => {
  			this.loggedIn = false;
  		});
  	}

    onSelectTab(tab: string){
      console.log(tab);
      this.selectedTab = tab;
    }


}
