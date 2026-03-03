import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ButtonNavegate } from './button-navegate';

describe('ButtonNavegate', () => {
  let component: ButtonNavegate;
  let fixture: ComponentFixture<ButtonNavegate>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ButtonNavegate]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ButtonNavegate);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
