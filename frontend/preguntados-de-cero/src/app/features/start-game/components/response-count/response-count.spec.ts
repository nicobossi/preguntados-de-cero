import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResponseCount } from './response-count';

describe('ResponseCount', () => {
  let component: ResponseCount;
  let fixture: ComponentFixture<ResponseCount>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ResponseCount]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ResponseCount);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
