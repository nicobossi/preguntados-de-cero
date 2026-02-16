import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuestionContent } from './question-content';

describe('QuestionContent', () => {
  let component: QuestionContent;
  let fixture: ComponentFixture<QuestionContent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [QuestionContent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(QuestionContent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
