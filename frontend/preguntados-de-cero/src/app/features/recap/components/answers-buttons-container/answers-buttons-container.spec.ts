import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnswersButtonsContainer } from './answers-buttons-container';

describe('AnswersButtonsContainer', () => {
  let component: AnswersButtonsContainer;
  let fixture: ComponentFixture<AnswersButtonsContainer>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AnswersButtonsContainer]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AnswersButtonsContainer);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
