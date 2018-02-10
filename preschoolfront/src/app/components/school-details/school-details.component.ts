import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { Headers, Http } from '@angular/http';
import {Params, ActivatedRoute, Router} from '@angular/router';

import { ToastsManager , ToastOptions} from 'ng2-toastr/ng2-toastr';

import {SchoolService } from '../../services/school.service';
import {RatingAndReviewService } from '../../services/rating-and-review.service';
import { LoginService } from '../../services/login.service';
import { ToasterService } from '../../services.toaster.service';

import  {RatingAndReview} from '../../models/rating-and-review';
import  {School} from '../../models/school';


@Component({
  selector: 'app-school-details',
  templateUrl: './school-details.component.html',
  styleUrls: ['./school-details.component.css']
})
export class SchoolDetailsComponent implements OnInit {

	schoolId : number;
	school: School = new School();
  reviewsList: RatingAndReview[];
  loggedIn:boolean;

	constructor(
		private router:Router,
		private http:Http,
		private route:ActivatedRoute,
    private schoolService: SchoolService,
    private ratingAndReviewService: RatingAndReviewService,
    private loginService: LoginService,
    private toastr : ToasterService,
    //private toastr: ToastsManager
    
	) {}

	ngOnInit() {

		this.route.params.forEach((params: Params) => {
  			this.schoolId = Number.parseInt(params['id']);
  		});

  		this.schoolService.getSchool(this.schoolId).subscribe(
  		res => {
  			this.school=res.json(); 
  		},
  		error => {
  			console.log(error);
  		});

      this.ratingAndReviewService.getReviewsList(this.schoolId).subscribe(
      res => {
        this.reviewsList=res.json(); 
      },
      error => {
        console.log(error);
      });

      //check if user is logged in
      this.loginService.checkSession().subscribe(
        res => {
          this.loggedIn = true;
        },
        err => {
          this.loggedIn =false;
        }
      );

	}

  addToWishList(){
    //use $mdToast if possible
  }
//, { toastLife: 5000, positionClass: 'toast-center-center'}
  showSuccess() {
    this.toastr.success('You are awesome!', 'Success!');
  }
  /*showSuccess() {
    let options = new ToastOptions({
        positionClass: 'toast-top-right',
        animate: 'flyRight',
        dismiss: 'click',
        toastLife:8000
    })

    //let toastManager: ToastsManager = new ToastsManager(this.componentFactoryResolver, this.appl, options);
    toastManager.success('message', 'title', { toastLife: 5000, dismiss: 'auto', positionClass: 'toast-top-right'});
}*/

  /*showError() {
    this.toastr.error('This is not good!', 'Oops!');
  }

  showWarning() {
    this.toastr.warning('You are being warned.', 'Alert!');
  }

  showInfo() {
    this.toastr.info('Just some information for you.');
  }*/

}
