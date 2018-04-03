import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import  {Center} from '../models/center';
import {AppConst} from '../constants/app-consts';

@Injectable()
export class CenterService {

  private serverPath = AppConst.serverPath;


	constructor(private http: Http) { }

	getCenterList() {
  	return this.http.get(encodeURI(this.serverPath+'/center/centerList'), { withCredentials: true });
    /*let url = this.serverPath+ '/center/centerList';

    let tokenHeader = new Headers({
      'Content-Type' : 'application/json',
      'Access-Control-Allow-Origin': '*',
      'x-auth-token' : localStorage.getItem("xAuthToken")
    });//http://eyaseyes.com
    return this.http.get(encodeURI(url), {headers: tokenHeader});*/
	}

  getWishList(wishList: string){
    
    let url = this.serverPath+ '/center/wishList/'+wishList;

    let tokenHeader = new Headers({
      'Content-Type' : 'application/json',
      'x-auth-token' : localStorage.getItem("xAuthToken")
    });
    return this.http.get(encodeURI(url), {headers: tokenHeader});
  }

	getCenter(id: number) {

  	let url = this.serverPath+'/center/'+id;
  
  	let tokenHeader = new Headers({
  		'Content-Type' : 'application/json',
  		'x-auth-token' : localStorage.getItem("xAuthToken")
  	});
  	return this.http.get(encodeURI(url), {headers: tokenHeader});
  }

  sendCenter(center:Center) {

    let url = this.serverPath+ '/center/add';
    
    let headers = new Headers ({
      'Content-Type': 'application/json',
      'x-auth-token' : localStorage.getItem('xAuthToken')
    });

    return this.http.post(encodeURI(url), JSON.stringify(center), {headers: headers});
  }

}
