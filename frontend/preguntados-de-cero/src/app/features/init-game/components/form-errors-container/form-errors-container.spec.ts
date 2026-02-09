import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormErrorsContainer } from './form-errors-container';

describe('FormErrorsContainer', () => {
  let component: FormErrorsContainer;
  let fixture: ComponentFixture<FormErrorsContainer>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormErrorsContainer]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormErrorsContainer);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
