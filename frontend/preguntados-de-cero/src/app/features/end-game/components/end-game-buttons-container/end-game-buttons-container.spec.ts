import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EndGameButtonsContainer } from './end-game-buttons-container';

describe('EndGameButtonsContainer', () => {
  let component: EndGameButtonsContainer;
  let fixture: ComponentFixture<EndGameButtonsContainer>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EndGameButtonsContainer]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EndGameButtonsContainer);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
