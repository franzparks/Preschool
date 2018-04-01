import { TestBed, inject } from '@angular/core/testing';

import { CenterService } from './center.service';

describe('CenterService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CenterService]
    });
  });

  it('should ...', inject([CenterService], (service: CenterService) => {
    expect(service).toBeTruthy();
  }));
});
