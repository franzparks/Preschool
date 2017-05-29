import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {LoginService} from '../../services/login.service';
import {UserService} from '../../services/user.service';
import {AppConst} from '../../constants/app-const';


@Component({
  selector: 'app-my-account',
  templateUrl: './my-account.component.html',
  styleUrls: ['./my-account.component.css']
})
export class MyAccountComponent implements OnInit {

	private serverPath = AppConst.serverPath;
  	private loginError:boolean = false;
  	private loggedIn = false;
  	private credential = {'username':'', 'password':''};

  	private emailSent: boolean =false;
  	private usernameExists:boolean;
  	private emailExists:boolean;
  	private username:string;
  	private email:string;

  	private emailNotExists: boolean =false;
  	private forgetPasswordEmailSent: boolean;
  	private recoverEmail:string;  

  	constructor(
  		private loginService: LoginService,
  		private userService: UserService,
  		private router: Router
  	) { }

  	ngOnInit() {
  	}

}
