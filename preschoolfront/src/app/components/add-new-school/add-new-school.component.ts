import { Component, OnInit } from '@angular/core';

import { School } from '../../models/school';

import {SchoolService} from '../../services/school.service';
import {UploadImageService} from '../../services/upload-image.service';

@Component({
  selector: 'app-add-new-school',
  templateUrl: './add-new-school.component.html',
  styleUrls: ['./add-new-school.component.css']
})
export class AddNewSchoolComponent implements OnInit {

	  newSchool: School = new School();
  	schoolAdded: boolean;

  	constructor(
  		private schoolService:SchoolService,
  		public uploadImageService:UploadImageService
  	) { }

  	onSubmit() {
  	this.schoolService.sendSchool(this.newSchool).subscribe(
  		res => {
  			this.uploadImageService.upload(JSON.parse(JSON.parse(JSON.stringify(res))._body).id);
  			this.schoolAdded=true;
  			this.newSchool = new School();
  		},
  		error => {
  			console.log(error);
  		}
  	);
  }

  	ngOnInit() {
  		this.schoolAdded=false;
  	}

}
