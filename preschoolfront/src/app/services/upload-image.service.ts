import { Injectable } from '@angular/core';

@Injectable()
export class UploadImageService {

	filesToUpload: Array<File>;


  	constructor() {
  		this.filesToUpload = [];
  	}

  	upload(schoolId: number) {
  	this.makeFileRequest("http://localhost:8080/school/add/image?id="+schoolId, [], this.filesToUpload).then((result) => {
  		console.log(result);
  	}, (error) => {
  		console.log(error);
  	});
  }

}
