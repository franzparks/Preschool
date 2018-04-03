import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {HomeComponent} from './components/home/home.component';
import { MyProfileComponent } from './components/my-profile/my-profile.component';
import { MyAccountComponent } from './components/my-account/my-account.component';
import { CenterDetailsComponent } from './components/center-details/center-details.component';
import { RatingComponent } from './components/rating/rating.component';
import { AddNewCenterComponent } from './components/add-new-center/add-new-center.component';
import { CenterListComponent } from './components/center-list/center-list.component';
import { WishListComponent } from './components/wish-list/wish-list.component';



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
	},
	{
		path: 'my-wishlist',
		component: WishListComponent
	},
	{
		path: 'center-reviews',
		component: CenterListComponent
	},{
		path: 'center/:id',
		component: CenterDetailsComponent
	},
	{
		path: 'center/:id/write-review',
		component: RatingComponent
	},{
		path: 'add-new-center',
		component: AddNewCenterComponent
	}
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);