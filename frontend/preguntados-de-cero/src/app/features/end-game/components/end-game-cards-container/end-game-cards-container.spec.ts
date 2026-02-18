import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EndGameCardsContainer } from './end-game-cards-container';

describe('EndGameCardsContainer', () => {
  let component: EndGameCardsContainer;
  let fixture: ComponentFixture<EndGameCardsContainer>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EndGameCardsContainer]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EndGameCardsContainer);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
