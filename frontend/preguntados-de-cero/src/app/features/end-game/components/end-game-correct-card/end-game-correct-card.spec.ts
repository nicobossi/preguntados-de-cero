import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EndGameCorrectCard } from './end-game-correct-card';

describe('EndGameCorrectCard', () => {
  let component: EndGameCorrectCard;
  let fixture: ComponentFixture<EndGameCorrectCard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EndGameCorrectCard]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EndGameCorrectCard);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
