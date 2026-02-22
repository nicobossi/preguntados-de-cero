import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayAgainButton } from './play-again-button';

describe('PlayAgainButton', () => {
  let component: PlayAgainButton;
  let fixture: ComponentFixture<PlayAgainButton>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PlayAgainButton]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PlayAgainButton);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
