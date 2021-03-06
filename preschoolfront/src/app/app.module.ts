import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { routing } from './app.routing';
import {RatingModule} from "ngx-rating";

import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryDataService }  from './in-memory-data.service';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MaterialModule} from '@angular/material';
//import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {ToastModule} from 'ng2-toastr/ng2-toastr';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { MyProfileComponent } from './components/my-profile/my-profile.component';
import { MyAccountComponent } from './components/my-account/my-account.component';
import { CenterDetailsComponent } from './components/center-details/center-details.component';
import { RatingComponent } from './components/rating/rating.component';
import { AddNewCenterComponent } from './components/add-new-center/add-new-center.component';
import { FooterComponent } from './components/footer/footer.component';
import { CenterListComponent } from './components/center-list/center-list.component';
import { WishListComponent } from './components/wish-list/wish-list.component';

import { CenterService } from './services/center.service';
import { UserService } from './services/user.service';
import { LoginService } from './services/login.service';
import { AddRatingService } from './services/add-rating.service';
import { RatingAndReviewService } from './services/rating-and-review.service';
import { UploadImageService } from './services/upload-image.service';
import { ToasterService } from './services/toaster.service';

import { SearchPipe} from './pipes/filter.pipe';





@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavBarComponent,
    MyProfileComponent,
    MyAccountComponent,
    CenterDetailsComponent,
    RatingComponent,
    AddNewCenterComponent,
    FooterComponent,
    CenterListComponent,
    WishListComponent,
    SearchPipe
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing,
    BrowserAnimationsModule,
    RatingModule,
    MaterialModule,
    //ToastModule
    ToastModule.forRoot()
    //NgbModule
    //InMemoryWebApiModule.forRoot(InMemoryDataService)
    
  ],
  providers: [CenterService,UserService,LoginService,
  AddRatingService,RatingAndReviewService,UploadImageService,ToasterService],
  bootstrap: [AppComponent]
})
export class AppModule { }
/*References
https://github.com/pleerock/ngx-rating
*/