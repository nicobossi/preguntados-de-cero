import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisableButton } from './disable-button';

describe('DisableButton', () => {
  let component: DisableButton;
  let fixture: ComponentFixture<DisableButton>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DisableButton]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DisableButton);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
