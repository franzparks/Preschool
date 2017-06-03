import { TestBed, inject } from '@angular/core/testing';

import { RatingAndReviewService } from './rating-and-review.service';

describe('RatingAndReviewService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RatingAndReviewService]
    });
  });

  it('should ...', inject([RatingAndReviewService], (service: RatingAndReviewService) => {
    expect(service).toBeTruthy();
  }));
});
