import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReplayButton } from './replay-button';

describe('ReplayButton', () => {
  let component: ReplayButton;
  let fixture: ComponentFixture<ReplayButton>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ReplayButton]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReplayButton);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
