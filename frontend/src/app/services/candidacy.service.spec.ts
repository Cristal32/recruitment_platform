import { TestBed } from '@angular/core/testing';

import { CandidacyService } from './candidacy.service';

describe('CandidacyService', () => {
  let service: CandidacyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CandidacyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
