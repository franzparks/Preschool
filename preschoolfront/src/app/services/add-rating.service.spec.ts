import { TestBed, inject } from '@angular/core/testing';

import { AddRatingService } from './add-rating.service';

describe('AddRatingService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AddRatingService]
    });
  });

  it('should ...', inject([AddRatingService], (service: AddRatingService) => {
    expect(service).toBeTruthy();
  }));
});
