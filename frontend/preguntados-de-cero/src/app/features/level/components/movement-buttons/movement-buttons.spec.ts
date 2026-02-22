import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MovementButtons } from './movement-buttons';

describe('MovementButtons', () => {
  let component: MovementButtons;
  let fixture: ComponentFixture<MovementButtons>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MovementButtons]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MovementButtons);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
