import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import {Params, ActivatedRoute, Router} from '@angular/router';

import { School } from '../../models/school';
import {SchoolService } from '../../services/school.service';

@Component({
  selector: 'app-school-list',
  templateUrl: './school-list.component.html',
  styleUrls: ['./school-list.component.css']
})
export class SchoolListComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
