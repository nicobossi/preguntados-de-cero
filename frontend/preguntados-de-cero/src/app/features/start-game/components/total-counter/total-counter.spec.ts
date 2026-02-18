import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TotalCounter } from './total-counter';

describe('TotalCounter', () => {
  let component: TotalCounter;
  let fixture: ComponentFixture<TotalCounter>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TotalCounter]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TotalCounter);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
