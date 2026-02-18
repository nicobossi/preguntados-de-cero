import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssertsCounter } from './asserts-counter';

describe('AssertsCounter', () => {
  let component: AssertsCounter;
  let fixture: ComponentFixture<AssertsCounter>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AssertsCounter]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AssertsCounter);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
