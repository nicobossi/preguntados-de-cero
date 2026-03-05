import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ErrorServerPage } from './error-server-page';

describe('ErrorServerPage', () => {
  let component: ErrorServerPage;
  let fixture: ComponentFixture<ErrorServerPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ErrorServerPage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ErrorServerPage);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
