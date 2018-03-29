import { Component, OnInit } from '@angular/core';
import { AppConst } from '../../constants/app-consts';
import { UserService } from '../../services/user.service';
import { LoginService } from '../../services/login.service';
import { ToasterService } from '../../services/toaster.service';

import { User } from '../../models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.css']
})
export class MyProfileComponent implements OnInit {

	serverPath = AppConst.serverPath;
	dataFetched = false;
	loginError:boolean;
	loggedIn:boolean;
	credential = {'username':'', 'password':''};

	user: User = new User();
	updateSuccess: boolean;
	newPassword: string;
  confirmNewPassword: string;
	incorrectPassword: boolean;
	currentPassword: string;

	selectedProfileTab: number = 0;

	constructor(
		  private loginService: LoginService,
  		private userService: UserService,
      private toastr : ToasterService,
  		private router: Router
	) { }


	onUpdateUserInfo () {
  	this.userService.updateUserInfo(this.user, this.newPassword, this.currentPassword).subscribe(
  		res => {
  			console.log(res.text());
        this.loginService.setLoggedIn(true);
  			this.updateSuccess=true;
        this.toastr.success('Account successfully updated!');
        //this.router.navigate(['/my-account']);

  		},
  		error => {
  			console.log(error.text());
  			let errorMessage = error.text();
  			if(errorMessage==="Incorrect current password!") this.incorrectPassword=true;
  		});
  	}

  	getCurrentUser() {
  	this.userService.getCurrentUser().subscribe(
  		res => {
  			this.user = res.json();

  			this.dataFetched = true;
  		},
  		err => {
  			console.log(err);
  		});
    }

    ngOnInit() {
  		this.loginService.checkSession().subscribe(
    		res => {
    			this.loggedIn = true;
          this.loginService.setLoggedIn(true);
    		},
    		error => {
    			this.loggedIn = false;
    			console.log("inactive session");
    			this.router.navigate(['/my-account']);
    		});

    		this.getCurrentUser();
    	}


}
