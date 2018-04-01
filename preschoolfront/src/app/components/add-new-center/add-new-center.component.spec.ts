import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNewCenterComponent } from './add-new-center.component';

describe('AddNewCenterComponent', () => {
  let component: AddNewCenterComponent;
  let fixture: ComponentFixture<AddNewCenterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddNewCenterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddNewCenterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
