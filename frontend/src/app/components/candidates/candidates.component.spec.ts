import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CandidatesComponent } from './candidates.component';

describe('CandidatesComponent', () => {
  let component: CandidatesComponent;
  let fixture: ComponentFixture<CandidatesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CandidatesComponent]
    });
    fixture = TestBed.createComponent(CandidatesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
