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

  	constructor(
  		private schoolService:SchoolService,
  		private uploadImageService:UploadImageService
  	) { }

  	ngOnInit() {
  	}

}
