import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EndGameIncorrectCard } from './end-game-incorrect-card';

describe('EndGameIncorrectCard', () => {
  let component: EndGameIncorrectCard;
  let fixture: ComponentFixture<EndGameIncorrectCard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EndGameIncorrectCard]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EndGameIncorrectCard);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
