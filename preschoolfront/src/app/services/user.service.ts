import { Injectable } from '@angular/core';
import {Http, Headers} from '@angular/http';
import {AppConst} from '../constants/app-const';
import {User} from '../models/user';

@Injectable()
export class UserService {
	
	private serverPath: string = AppConst.serverPath;

  	constructor(
  		private http:Http
  	) { }

}
