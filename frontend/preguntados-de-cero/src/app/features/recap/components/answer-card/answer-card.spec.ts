import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnswerCard } from './answer-card';

describe('AnswerCard', () => {
  let component: AnswerCard;
  let fixture: ComponentFixture<AnswerCard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AnswerCard]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AnswerCard);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
