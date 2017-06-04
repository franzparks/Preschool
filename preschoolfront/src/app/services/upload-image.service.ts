import { Injectable } from '@angular/core';

@Injectable()
export class UploadImageService {

	filesToUpload: Array<File>;


  	constructor() {
  		this.filesToUpload = [];
  	}

}
