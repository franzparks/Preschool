import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { routing } from './app.routing';
import {RatingModule} from "ngx-rating";

import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryDataService }  from './in-memory-data.service';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MdButtonModule, MdCheckboxModule,MdTabsModule,MdCardModule} from '@angular/material';
import { MdToolbarModule, MdMenuModule } from '@angular/material';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { MyProfileComponent } from './components/my-profile/my-profile.component';
import { MyAccountComponent } from './components/my-account/my-account.component';
import { SchoolDetailsComponent } from './components/school-details/school-details.component';
import { SchoolService } from './services/school.service';
import { UserService } from './services/user.service';
import { LoginService } from './services/login.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavBarComponent,
    MyProfileComponent,
    MyAccountComponent,
    SchoolDetailsComponent
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing,
    BrowserAnimationsModule,
    RatingModule,
    MdButtonModule, MdCheckboxModule,
    MdTabsModule,
    MdCardModule,
    MdMenuModule
    //InMemoryWebApiModule.forRoot(InMemoryDataService)
    
  ],
  providers: [SchoolService,UserService,LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
/*References
https://github.com/pleerock/ngx-rating
*/