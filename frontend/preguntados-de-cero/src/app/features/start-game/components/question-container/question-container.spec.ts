import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuestionContainer } from './question-container';

describe('QuestionContainer', () => {
  let component: QuestionContainer;
  let fixture: ComponentFixture<QuestionContainer>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [QuestionContainer]
    })
    .compileComponents();

    fixture = TestBed.createComponent(QuestionContainer);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
