import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ErrorDescription } from './error-description';

describe('ErrorDescription', () => {
  let component: ErrorDescription;
  let fixture: ComponentFixture<ErrorDescription>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ErrorDescription]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ErrorDescription);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
