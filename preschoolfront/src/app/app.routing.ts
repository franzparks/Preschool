import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {HomeComponent} from './components/home/home.component';
import { MyProfileComponent } from './components/my-profile/my-profile.component';
import { MyAccountComponent } from './components/my-account/my-account.component';
import { SchoolDetailsComponent } from './components/school-details/school-details.component';
import { RatingComponent } from './components/rating/rating.component';



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
		path: 'school/:id',
		component: SchoolDetailsComponent
	},
	{
		path: 'write-review',
		component: RatingComponent
	}
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);