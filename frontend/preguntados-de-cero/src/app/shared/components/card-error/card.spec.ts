import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardError } from './card';

describe('Card', () => {
  let component: CardError;
  let fixture: ComponentFixture<CardError>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CardError]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardError);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
