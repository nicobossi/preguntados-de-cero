import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LevelCard } from './level-sheet';

describe('LevelCard', () => {
  let component: LevelCard;
  let fixture: ComponentFixture<LevelCard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LevelCard]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LevelCard);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
