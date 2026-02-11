import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ErrorCode } from './error-code';

describe('ErrorCode', () => {
  let component: ErrorCode;
  let fixture: ComponentFixture<ErrorCode>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ErrorCode]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ErrorCode);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
