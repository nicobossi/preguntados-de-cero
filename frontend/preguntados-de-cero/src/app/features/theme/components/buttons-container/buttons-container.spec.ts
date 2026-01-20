import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ButtonsContainer } from './buttons-container';

describe('ButtonsContainer', () => {
  let component: ButtonsContainer;
  let fixture: ComponentFixture<ButtonsContainer>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ButtonsContainer]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ButtonsContainer);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
