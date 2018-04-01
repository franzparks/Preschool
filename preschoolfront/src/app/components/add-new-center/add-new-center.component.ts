import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

import { Center } from '../../models/center';

import {CenterService} from '../../services/center.service';
import {UploadImageService} from '../../services/upload-image.service';

import { LoginService } from '../../services/login.service';
import { ToasterService } from '../../services/toaster.service';

@Component({
  selector: 'app-add-new-center',
  templateUrl: './add-new-center.component.html',
  styleUrls: ['./add-new-center.component.css']
})
export class AddNewCenterComponent implements OnInit {

	  newCenter: Center = new Center();
    selectedType: string = 'Preschool';
    selectedCategory: string = 'Academic Based';
  	centerAdded: boolean;

  	constructor(
  		private centerService:CenterService,
  		public uploadImageService:UploadImageService,
      private loginService: LoginService,
      private toastr : ToasterService,
      private router: Router
  	) { }

  	onSubmit() {
      this.newCenter.type = this.selectedType;
      this.newCenter.category = this.selectedCategory;
    	this.centerService.sendCenter(this.newCenter).subscribe(
    		res => {
          let id = JSON.parse(JSON.parse(JSON.stringify(res))._body).id;
    			this.uploadImageService.upload(id);
    			this.centerAdded=true;
          this.toastr.success('Center successfully added!');
          this.router.navigate(['/center/', id]);
          this.newCenter = new Center();
    		},
    		error => {
          this.toastr.error('Error occured, center could not registered!');
    			console.log(error);
    		}
    	);
  }

  	ngOnInit() {
  		this.centerAdded=false;

      //check if user is logged in
      this.loginService.checkSession().subscribe(
        res => {
          this.loginService.setLoggedIn(true);
        },
        err => {
          //got login page if not logged in
          this.router.navigate(['/my-account']);
        }
      );
  	}

}
