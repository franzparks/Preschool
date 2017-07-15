import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {HomeComponent} from './components/home/home.component';
import { MyProfileComponent } from './components/my-profile/my-profile.component';
import { MyAccountComponent } from './components/my-account/my-account.component';
import { SchoolDetailsComponent } from './components/school-details/school-details.component';
import { RatingComponent } from './components/rating/rating.component';
import { AddNewSchoolComponent } from './components/add-new-school/add-new-school.component';
import { SchoolListComponent } from './components/school-list/school-list.component';



const appRoutes: Routes = [
	{
		path: '',
		redirectTo: '/home',
		pathMatch: 'full'
	},
	{
		path: 'home',
		component: HomeComponent
	},
	{
		path: 'my-profile',
		component: MyProfileComponent
	},
	{
		path: 'my-account',
		component: MyAccountComponent
	},{
		path: 'school-reviews',
		component: SchoolListComponent
	},{
		path: 'school/:id',
		component: SchoolDetailsComponent
	},
	{
		path: 'school/:id/write-review',
		component: RatingComponent
	},{
		path: 'add-new-school',
		component: AddNewSchoolComponent
	}
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);