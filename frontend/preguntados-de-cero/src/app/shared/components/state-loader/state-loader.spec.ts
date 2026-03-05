import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StateLoader } from './state-loader';

describe('StateLoader', () => {
  let component: StateLoader;
  let fixture: ComponentFixture<StateLoader>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StateLoader]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StateLoader);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
