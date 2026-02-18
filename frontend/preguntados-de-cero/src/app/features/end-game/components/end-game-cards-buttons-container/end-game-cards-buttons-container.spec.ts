import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EndGameCardsButtonsContainer } from './end-game-cards-buttons-container';

describe('EndGameCardsButtonsContainer', () => {
  let component: EndGameCardsButtonsContainer;
  let fixture: ComponentFixture<EndGameCardsButtonsContainer>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EndGameCardsButtonsContainer]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EndGameCardsButtonsContainer);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
