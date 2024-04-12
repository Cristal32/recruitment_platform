import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyOffersComponent } from './my-offers.component';

describe('MyOffersComponent', () => {
  let component: MyOffersComponent;
  let fixture: ComponentFixture<MyOffersComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MyOffersComponent]
    });
    fixture = TestBed.createComponent(MyOffersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
